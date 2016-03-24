package com.crowdfunding.beans;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.crowdfunding.beans.Projet;
import com.crowdfunding.dao.DAOException;
import com.crowdfunding.javaClass.FormValidationException;
import com.crowdfunding.dao.ProjetDao;

public class ProjetValidation {
    private static final String CHAMP_RECOL       = "montant";
    private static final String CHAMP_DESC       = "comment";
    private static final String CHAMP_TYPE	 = "type";
    private static final String CHAMP_NOM		= "nom";
    private static final String CHAMP_DATE   = "date"; 
	
	private String              resultat;
	private Map<String, String> erreurs          = new HashMap<String, String>();
	private ProjetDao      projetDao;
	
    public ProjetValidation( ProjetDao projet ) {
        this.projetDao = projet;
    }
	
    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    
    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChampString( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
    private static int getValeurChampint( HttpServletRequest request, String nomChamp ) {
        int valeur = Integer.parseInt(request.getParameter( nomChamp ));
        if ( valeur <=0 ) {
            return 0;
        } else {
            return valeur;
        }
    }
    
    
    public Projet inscrireProjet( HttpServletRequest request, int id) {
        int montant = getValeurChampint( request, CHAMP_RECOL );
        String description = getValeurChampString( request, CHAMP_DESC );
        String typeProject = getValeurChampString(request, CHAMP_TYPE);
        String nom = getValeurChampString(request, CHAMP_NOM);

        Projet projet = new Projet();
        
        try {
        	traiterNom( nom, projet );
        	traiterType( typeProject, projet );
        	traiterDescription(description, projet);
        	//traitermontant
        	//traiterDate
        	
        	
            if ( erreurs.isEmpty() ) {
            	projetDao.creerProjet( projet, id);
                resultat = "Succès de l'enregistrement.";
            } else {
                resultat = "Échec de l'enregistrement.";
            }
        } catch ( DAOException e ) {
            resultat = "Échec de l'enregistrement : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

        return projet;
    }
    
    private void traiterNom( String nom, Projet projet ) {
        try {
            validationNom( nom );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        projet.setNom( nom );
    }
    
    
    private void validationNom( String nom ) throws FormValidationException {
        if ( nom != null && nom.length() < 3 ) {
            throw new FormValidationException( "Le nom du projet doit contenir au moins 3 caractères." );
        }
    }
    
    private void traiterType( String type, Projet projet ) {
        try {
        	validationType( type );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_TYPE, e.getMessage() );
        }
        projet.setTypeProject( type );
    }
    
    
    private void validationType( String type ) throws FormValidationException {
        if ( type != null && type.length() < 3 ) {
            throw new FormValidationException( "Le type du projet doit contenir au moins 3 caractères." );
        }
    }
    
    private void traiterDescription( String description, Projet projet ) {
        try {
        	validationType( description );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_DESC, e.getMessage() );
        }
        projet.setDescription( description );
    }
    
    
    private void validationDescription( String description ) throws FormValidationException {
        if ( description != null && description.length() < 3 ) {
            throw new FormValidationException( "Le type du projet doit contenir au moins 3 caractères." );
        }
    }
}
