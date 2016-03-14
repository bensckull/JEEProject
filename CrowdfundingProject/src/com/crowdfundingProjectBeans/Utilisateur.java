package com.crowdfundingProjectBeans;

@SuppressWarnings("serial")
public class Utilisateur implements java.io.Serializable{
	private String Prenom;
	private int age;
	private String pseudo;
	private String adresse;
	private String Email;
	private String MotDePasse;
	private boolean actif;
	
	public Utilisateur() {
		super();
	}
	private String nom;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getMotDePasse() {
		return MotDePasse;
	}
	public void setMotDePasse(String motdepasse) {
		this.MotDePasse = motdepasse;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}

}