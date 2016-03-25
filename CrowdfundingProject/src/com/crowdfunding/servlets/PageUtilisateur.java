package com.crowdfunding.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crowdfunding.beans.Utilisateur;
import com.crowdfunding.dao.DAOFactory;
import com.crowdfunding.dao.ProjetDao;

/**
 * Servlet implementation class PageUtilisateur
 */
@WebServlet("/PageUtilisateur")
public class PageUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE1             = "/WEB-INF/pageUtilisateur.jsp";
	public static final String VUE2             = "/WEB-INF/editUser.jsp";
	public static final String CONF_DAO_FACTORY = "daofactory";
	private ProjetDao     projetDao;

	public void init() throws ServletException{
    	this.projetDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getProjetDao();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	
		HttpSession session = request.getSession();
	 	Utilisateur u = (Utilisateur) session.getAttribute("sessionUtilisateur");
	 	
	 	request.setAttribute("listeProjetsParUtilisateur", projetDao.listeProjetsParUtilisateur(u.getId()));
	
		this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
	}

}
