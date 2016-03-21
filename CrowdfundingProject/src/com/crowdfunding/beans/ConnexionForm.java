package com.crowdfunding.beans;

import java.util.HashMap;
import java.util.Map;
import com.crowdfunding.dao.UtilisateurDao;
import com.crowdfunding.javaClass.FormValidationException;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public final class ConnexionForm {
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";
    private String resultat;
    private UtilisateurDao utilisateurDao;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    private static final String ALGO_CHIFFREMENT = "SHA-256";

    public ConnexionForm(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;

    }
    
    public String getResultat() {
        return resultat;
    }
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur( HttpServletRequest request ) {

    	String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        Utilisateur utilisateur = new Utilisateur();

        traiterEmail(email);
        traiterMotDePasse(motDePasse);
        
        if (erreurs.isEmpty()) {
        	utilisateur = utilisateurDao.trouver(email);
        	if(utilisateur!=null){
        		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
                passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
                passwordEncryptor.setPlainDigest(false );
                String motDePasseChiffre = utilisateur.getMotdepasse();
                if(passwordEncryptor.checkPassword(motDePasse, motDePasseChiffre)){
                    resultat = "Succès de la connexion.";
                }
                else{
                	resultat = "mot de passe incorrect";
                }
        	}
        	else{
        		resultat = "Utilisateur inconnu";
        	}
            
        } else {
            resultat = "Échec de la connexion.";
        }
        return utilisateur;
    }

    private void traiterEmail( String email) {
        try {
            validationEmail( email );
        } catch (FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
    }

    private void traiterMotDePasse(String motDePasse) {
        try {
            validationMotDePasse(motDePasse);
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        } 
    }
    
    private void validationEmail(String email) throws FormValidationException {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new FormValidationException( "Merci de saisir une adresse mail valide." );
        }
    }

    private void validationMotDePasse(String motDePasse) throws FormValidationException {
    	if ( motDePasse.length() < 3 ) {
                throw new FormValidationException( "Le mot de passe doit contenir au moins 3 caractères." );
        }
//        else {
//            throw new FormValidationException( "Merci de saisir votre mot de passe." );
//        }
    }

    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
