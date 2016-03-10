package com.crowdfundingServlets;

import com.crowdfundingJavaClass.ConnexionDB;
import com.crowdfundingProjectBeans.Utilisateur;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListeUtilisateurs
 */
@WebServlet("/ListeUtilisateurs")
public class ListeUtilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListeUtilisateurs() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionDB connexion = new ConnexionDB("/home/etudiant/git/JEEProject/CrowdfundingProject/databases/crowdfundingproject.db");
		connexion.connect();
		ResultSet resultSet = connexion.query("SELECT * FROM utilisateur;");
		try {
			while (resultSet.next()) {
				Utilisateur utilisateur2 = new Utilisateur();
				utilisateur2.setNom(resultSet.getString("nom"));
				utilisateur2.setPrenom(resultSet.getString("prenom"));
				utilisateur2.setAge(resultSet.getInt("age"));
				if(resultSet.getInt("actif") == 1)
					utilisateur2.setActif(true);
				else
					utilisateur2.setActif(false);
				
				request.setAttribute("user2", utilisateur2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setNom("Makoundou");
		utilisateur1.setPrenom("Deuneuv");
		utilisateur1.setAge(25);
		utilisateur1.setActif(true);
		
		request.setAttribute("user1", utilisateur1);
		System.out.println("Récupération des données sur la bdd réussi");
		connexion.close();
        this.getServletContext().getRequestDispatcher("/WEB-INF/listeUtilisateurs.jsp").forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
