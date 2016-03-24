package com.crowdfunding.beans;

import java.sql.Timestamp;

@SuppressWarnings("serial")
public class Projet implements java.io.Serializable{

	private int idProjet;
	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public int getIdPromoteur() {
		return idPromoteur;
	}
	public void setIdPromoteur(int idPromoteur) {
		this.idPromoteur = idPromoteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTypeProject() {
		return typeProject;
	}
	public void setTypeProject(String typeProject) {
		this.typeProject = typeProject;
	}
	public int getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(int montantTotal) {
		this.montantTotal = montantTotal;
	}
	public Timestamp getDateFin() {
		return dateFin;
	}
	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMontantRecolte() {
		return montantRecolte;
	}
	public void setMontantRecolte(int montantRecolte) {
		this.montantRecolte = montantRecolte;
	}
	private int idPromoteur;
	private String nom;
	private String typeProject;
	private int montantTotal;
	private Timestamp dateFin;
	private String description;
	private int montantRecolte;
}
