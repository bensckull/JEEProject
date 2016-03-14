package com.crowdfundingProjectBeans;

@SuppressWarnings("serial")
public class Utilisateur implements java.io.Serializable{
	
	private String nom;
	private String prenom;
	private int age;
	private String pseudo;
	private String adresse;
	private String email; //les attributs s'écrivent avec une minuscule en début
	private String motDePasse;
	private boolean actif;
	
	public Utilisateur() {
		super();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motdepasse) {
		this.motDePasse = motdepasse;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}

}