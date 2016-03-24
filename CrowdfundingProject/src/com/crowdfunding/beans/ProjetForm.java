package com.crowdfunding.beans;
import java.sql.Timestamp;

public class ProjetForm  implements java.io.Serializable{
	private String nom;
	private String typeProject;
	private int montantTotal;
	private Timestamp dateFin;
	private String description;
	private int montantRecolte;
	private int idPromoteur;
	private int idProjet;
	
	public int getidProjet(){
		return this.idProjet;
	}
	
	public void setidProjet(int idprojet){
		this.idProjet = idprojet;
	}
	
	public int getidPromoteur(){
		return this.idPromoteur;
	}
	
	public void setidPromoteur(int idpromoteur){
		this.idPromoteur = idpromoteur;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public String gettypeProjet(){
		return this.typeProject;
	}
	
	public void settypeProjet(String type){
		this.typeProject = type;
	}
	
	public int getmontantTotal(){
		return this.montantTotal;
	}
	
	public void setmontantTotal(int montant){
		this.montantTotal = montant;
	}
	
	public Timestamp getdateFin(){
		return this.dateFin;
	}
	
	public void setdateFin(Timestamp date) {
		this.dateFin = date;
	}
	
	public String getdescription(){
		return this.description;
	}
	
	public void setdescription(String description){
		this.description = description;
	}
	
	public int getmontantRecolte(){
		return this.montantRecolte;
	}
	
	public void setmontantRecolte(int montant){
		this.montantRecolte = montant;
	}

}
