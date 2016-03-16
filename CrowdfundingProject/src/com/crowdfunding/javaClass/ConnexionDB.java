package com.crowdfunding.javaClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionDB {
	private String url = "jdbc:mysql://localhost:3306/crowdfundingproject";
	private String user = "admin";
	private String mdp = "admin";
	private Connection connection = null;
	private Statement statement = null;

	public ConnexionDB() {
	}

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, mdp);
			statement = connection.createStatement();
			System.out.println("Connexion a la BDD réussi");
		} catch (ClassNotFoundException notFoundException) {
			notFoundException.printStackTrace();
			System.out.println("Erreur de connecxion");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Erreur de connecxion");
		}
	}

	public void close() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet query(String requet) {
		ResultSet resultat = null;
		try {
			resultat = statement.executeQuery(requet);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur dans la requet : " + requet);
		}
		return resultat;

	}
}
