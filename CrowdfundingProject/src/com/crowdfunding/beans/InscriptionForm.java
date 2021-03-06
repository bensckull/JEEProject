package com.crowdfunding.beans;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.crowdfunding.beans.Utilisateur;
import com.crowdfunding.dao.DAOException;
import com.crowdfunding.dao.UtilisateurDao;
import com.crowdfunding.javaClass.FormValidationException;

public final class InscriptionForm {
    private static final String CHAMP_EMAIL      = "email";
    private static final String CHAMP_PASS       = "motdepasse";
    private static final String CHAMP_CONF       = "confirmation";
    private static final String CHAMP_PSEUDO     = "pseudo";
    private static final String CHAMP_PRENOM	 = "prenom";
    private static final String CHAMP_NOM		= "nom";

    private static final String ALGO_CHIFFREMENT = "SHA-256";

    private String              resultat;
    private Map<String, String> erreurs          = new HashMap<String, String>();
    private UtilisateurDao      utilisateurDao;

    public InscriptionForm( UtilisateurDao utilisateurDao ) {
        this.utilisateurDao = utilisateurDao;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String pseudo = getValeurChamp( request, CHAMP_PSEUDO );
        String prenom = getValeurChamp(request, CHAMP_PRENOM);
        String nom = getValeurChamp(request, CHAMP_NOM);

        Utilisateur utilisateur = new Utilisateur();
        try {
            traiterEmail( email, utilisateur );
            traiterMotsDePasse( motDePasse, confirmation, utilisateur );
            traiterNom( nom, utilisateur );
            traiterPrenom(prenom, utilisateur);
            traiterPseudo(pseudo, utilisateur);
            
            if ( erreurs.isEmpty() ) {
                utilisateurDao.creer( utilisateur );
                resultat = "Succès de l'inscription.";
            } else {
                resultat = "Échec de l'inscription.";
            }
        } catch ( DAOException e ) {
            resultat = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

        return utilisateur;
    }

    private void traiterEmail( String email, Utilisateur utilisateur ) {
        try {
            validationEmail( email );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );
    }

    private void traiterMotsDePasse( String motDePasse, String confirmation, Utilisateur utilisateur ) {
        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }

        /*
         * Utilisation de la bibliothèque Jasypt pour chiffrer le mot de passe
         * efficacement.
         * 
         * L'algorithme SHA-256 est ici utilisé, avec par défaut un salage
         * aléatoire et un grand nombre d'itérations de la fonction de hashage.
         * 
         * La String retournée est de longueur 56 et contient le hash en Base64.
         */
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
        passwordEncryptor.setPlainDigest( false );
        String motDePasseChiffre = passwordEncryptor.encryptPassword( motDePasse );

        utilisateur.setMotdepasse( motDePasseChiffre );
    }

    private void traiterNom( String nom, Utilisateur utilisateur ) {
        try {
            validationNom( nom );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PSEUDO, e.getMessage() );
        }
        utilisateur.setNom( nom );
    }
    private void traiterPrenom(String prenom, Utilisateur utilisateur){
    	try {
			validationPrenom(prenom);
		} catch (FormValidationException e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
    	utilisateur.setPrenom(prenom);
    }
    
    private void traiterPseudo(String pseudo, Utilisateur utilisateur){
    	try{
    		validationPseudo(pseudo);
    	}
    	catch(FormValidationException e){
    		setErreur(CHAMP_PSEUDO, e.getMessage());
    	}
    	utilisateur.setPseudo(pseudo);
    }

    /* Validation de l'adresse email */
    private void validationEmail( String email ) throws FormValidationException {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new FormValidationException( "Merci de saisir une adresse mail valide." );
            } else if ( utilisateurDao.trouver( email ) != null ) {
                throw new FormValidationException( "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
            }
        } else {
            throw new FormValidationException( "Merci de saisir une adresse mail." );
        }
    }

    /* Validation des mots de passe */
    private void validationMotsDePasse( String motDePasse, String confirmation ) throws FormValidationException {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new FormValidationException( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( motDePasse.length() < 3 ) {
                throw new FormValidationException( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    private void validationNom( String nom ) throws FormValidationException {
        if ( nom != null && nom.length() < 3 ) {
            throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

    private void validationPrenom( String prenom ) throws FormValidationException {
        if ( prenom != null && prenom.length() < 3 ) {
            throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
        if(prenom==null)
        	throw new FormValidationException("Vous devez entrer impérativement un prenom");
    }
    private void validationPseudo( String pseudo ) throws FormValidationException {
        if ( pseudo != null && pseudo.length() < 3 ) {
            throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
//        if(pseudo==null){
//        	throw new FormValidationException("Vous devez entrer impérativement un pseudo");
//        	
//        }
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}