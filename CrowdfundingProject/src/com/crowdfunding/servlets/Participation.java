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

@WebServlet("/Participation")
public class Participation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String VUE1             = "/WEB-INF/projet.jsp";
	private ProjetDao     projetDao;

    public void init() throws ServletException{
    	this.projetDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getProjetDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("sessionUtilisateur");
		projetDao.participation(u.getId(),(int) request.getAttribute("idUser"),(int) request.getAttribute("montant"));
	}

}
