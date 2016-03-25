package com.crowdfunding.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crowdfunding.beans.Projet;
import com.crowdfunding.dao.DAOFactory;
import com.crowdfunding.dao.ProjetDao;

/**
 * Servlet implementation class ListeProjets
 */
@WebServlet("/ListeProjets")
public class ListeProjets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	private ProjetDao     projetDao;

	public void init() throws ServletException{
    	this.projetDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getProjetDao();
    }
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List< Projet> listeP = projetDao.listeProjets(10);
		System.out.println("Nombre de contributeur"+projetDao.countParticipants(listeP.get(0).getIdProjet()));

    	request.setAttribute("listeProjets", listeP);

		this.getServletContext().getRequestDispatcher("/WEB-INF/listeProjets.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeProjets.jsp").forward(request, response);

	}

}
