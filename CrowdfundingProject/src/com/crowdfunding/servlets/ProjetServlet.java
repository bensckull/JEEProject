package com.crowdfunding.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crowdfunding.beans.InscriptionForm;
import com.crowdfunding.beans.Projet;
import com.crowdfunding.beans.ProjetValidation;
import com.crowdfunding.beans.Utilisateur;
import com.crowdfunding.dao.DAOFactory;
import com.crowdfunding.dao.ProjetDao;
import com.crowdfunding.dao.UtilisateurDao;

/**
 * Servlet implementation class Projet
 */
@WebServlet("/ProjetServlet")
public class ProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_USER         = "utilisateur";
	public static final String ATT_FORM         = "ProjetValidation";
	public static final String VUE1             = "/WEB-INF/createProjet.jsp";
	public static final String VUE2             = "/WEB-INF/projet.jsp";
	
	private ProjetDao     projetDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException{
    	this.projetDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getProjetDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjetValidation form = new ProjetValidation( projetDao );
		
		HttpSession session = request.getSession();
		int idutilisateur = (int) session.getAttribute("id");

        /* Traitement de la requête et récupération du bean en résultant */
		Projet projet = form.inscrireProjet( request, idutilisateur );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, projet );
        this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
	}

}
