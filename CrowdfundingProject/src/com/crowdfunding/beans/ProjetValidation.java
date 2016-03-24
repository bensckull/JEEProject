package com.crowdfunding.beans;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.crowdfunding.beans.ProjetForm;
import com.crowdfunding.dao.DAOException;
import com.crowdfunding.javaClass.FormValidationException;

public class ProjetValidation {
    private static final int CHAMP_RECOL       = 0;
    private static final String CHAMP_DESC       = "description";
    private static final int CHAMP_TOTAL     = 0;
    private static final String CHAMP_TYPE	 = "typeProject";
    private static final String CHAMP_NOM		= "nom";
	
	private String              resultat;
	private Map<String, String> erreurs          = new HashMap<String, String>();
	private ProjetForm      projet;
	
    public ProjetValidation( ProjetForm projet ) {
        this.projet = projet;
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
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return 0;
        } else {
            return Integer.parseInt(valeur);
        }
    }
    
    
    public ProjetForm inscrireProjet( HttpServletRequest request ) {
        //int montantRecolte = getValeurChamp( request, CHAMP_RECOL );
        //int montantTotal = getValeurChamp( request, CHAMP_TOTAL );
        String description = getValeurChampString( request, CHAMP_DESC );
        String typeProject = getValeurChampString(request, CHAMP_TYPE);
        String nom = getValeurChampString(request, CHAMP_NOM);

        ProjetForm projet = new ProjetForm();
        
        try {
        	traiterNom( nom, projet );
        	traiterType( typeProject, projet );
        	
        	
            if ( erreurs.isEmpty() ) {
                //projetDao.creer( projet );
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
    
    private void traiterNom( String nom, ProjetForm projet ) {
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
    
    private void traiterType( String type, ProjetForm projet ) {
        try {
        	validationType( type );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_TYPE, e.getMessage() );
        }
        projet.settypeProjet( type );
    }
    
    
    private void validationType( String type ) throws FormValidationException {
        if ( type != null && type.length() < 3 ) {
            throw new FormValidationException( "Le type du projet doit contenir au moins 3 caractères." );
        }
    }
}
