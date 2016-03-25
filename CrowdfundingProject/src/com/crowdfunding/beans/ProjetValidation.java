package com.crowdfunding.beans;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.crowdfunding.beans.Projet;
import com.crowdfunding.dao.DAOException;
import com.crowdfunding.javaClass.FormValidationException;
import com.crowdfunding.dao.ProjetDao;

public class ProjetValidation {
    private static final String CHAMP_MONTANT   = "montant";
    private static final String CHAMP_DESCRIPTION = "description";
    private static final String CHAMP_TYPE	 	= "type";
    private static final String CHAMP_NOM		= "nom";
    private static final String CHAMP_DATE   	= "date"; 
	
	private String              resultat;
	private Map<String, String> erreurs          = new HashMap<String, String>();
	private ProjetDao      projetDao;
	
	public static Timestamp convStrToTimestamp(String str_date) {
	    try {
	      DateFormat formatter;
	      formatter = new SimpleDateFormat("dd/MM/yyyy");
	      Date date = (Date) formatter.parse(str_date);
	      java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

	      return timeStampDate;
	    } catch (ParseException e) {
	      System.out.println("Exception :" + e);
	      return null;
	    }
	}
	
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
    
    private static int getValeurChampInt( HttpServletRequest request, String nomChamp ) {
    	int valeur;
    	if(request.getParameter( nomChamp ) != null && request.getParameter( nomChamp ) != ""){
    		valeur = Integer.parseInt(request.getParameter( nomChamp ));
    	}else{
    		valeur = 0;
    	}
        if ( valeur <=0 ) {
            return 0;
        } else {
            return valeur;
        }
    }
    
	public Projet inscrireProjet( HttpServletRequest request, int id) {
        int montant = getValeurChampInt( request, CHAMP_MONTANT );
        String description = getValeurChampString( request, CHAMP_DESCRIPTION );
        String typeProject = getValeurChampString(request, CHAMP_TYPE);
        String nom = getValeurChampString(request, CHAMP_NOM);        
        Timestamp date= convStrToTimestamp(request.getParameter(CHAMP_DATE));
        Projet projet = new Projet();
    	projet.setDateFin(date);
        try {
        	traiterNom( nom, projet );
        	traiterType( typeProject, projet );
        	traiterDescription(description, projet);
        	traiterMontant(montant,projet);
        	
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
    
    private void validationMontant(int m) throws FormValidationException{
    	if(m < 500){
    		throw new FormValidationException("Vous ne pouvez déposer que des projets d'un montant de 500 euros minimum");
    	}
    }
    private void validationNom( String nom ) throws FormValidationException {
        if ( nom != null && nom.length() < 3 ) {
            throw new FormValidationException( "Le nom du projet doit contenir au moins 3 caractères." );
        }
        if ( nom == null) {
            throw new FormValidationException( "Veuillez entrer le nom du projet" );
        }
    }
    
    
    private void validationType( String type ) throws FormValidationException {
        if ( type != null && type.length() < 3 ) {
            throw new FormValidationException( "Le type du projet doit contenir au moins 3 caractères." );
        }
        if ( type ==null ) {
            throw new FormValidationException( "Renseigner le type du projet" );
        }
    }
    
    private void validationDescription( String description ) throws FormValidationException {
        if ( description != null && description.length() < 3 ) {
            throw new FormValidationException( "Description de plus de 3 caractères." );
        }
        if ( description == null || description.isEmpty() ) {
            throw new FormValidationException( "Veuillez décrire votre projet" );
        }
    }
    private void traiterDescription( String description, Projet projet ) {
        try {
        	validationDescription(description);
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_DESCRIPTION, e.getMessage() );
        }
        projet.setDescription( description );
    }
    private void traiterType( String type, Projet projet ) {
        try {
        	validationType( type );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_TYPE, e.getMessage() );
        }
        projet.setTypeProject( type );
    }
    private void traiterNom( String nom, Projet projet ) {
        try {
            validationNom( nom );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        projet.setNom( nom );
    }
    
    private void traiterMontant(int montant, Projet p){
    	try{
    		validationMontant(montant);
    	}
    	catch(FormValidationException e){
    		setErreur(CHAMP_MONTANT, e.getMessage());
    	}
    	p.setMontantTotal(montant);
    }
    
    
}
