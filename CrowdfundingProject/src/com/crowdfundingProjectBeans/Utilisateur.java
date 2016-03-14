package com.crowdfundingProjectBeans;

public class Utilisateur implements java.io.Serializable{
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		this.email = Email;
	}
	public String getMotDePasse() {
		return MotDePasse;
	}
	public void setMotDePasse(String MotDePasse) {
		this.MotDePasse = MotDePasse;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	private String Prenom;
	private int age;
	private String pseudo;
	private String email;
	private String MotDePasse;
	private boolean active;
	
}