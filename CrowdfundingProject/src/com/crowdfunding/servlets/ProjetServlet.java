package com.crowdfunding.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crowdfunding.beans.Projet;
import com.crowdfunding.beans.ProjetValidation;
import com.crowdfunding.beans.Utilisateur;
import com.crowdfunding.dao.DAOFactory;
import com.crowdfunding.dao.ProjetDao;

@WebServlet("/ProjetServlet")
public class ProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_FORM         = "projetValidation";
	public static final String ATT_PROJET         = "projet";
	public static final String VUE1             = "/WEB-INF/createProjet.jsp";
	public static final String VUE2             = "/WEB-INF/participation.jsp";
	
	private ProjetDao     projetDao;
    
    public void init() throws ServletException{
    	this.projetDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getProjetDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjetValidation form = new ProjetValidation(projetDao );
		
		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("sessionUtilisateur");
		Projet projet = form.inscrireProjet( request, u.getId());
        request.setAttribute( ATT_FORM, form );
        request.setAttribute(ATT_PROJET, projet);
        this.getServletContext().getRequestDispatcher(VUE2).forward(request, response);
	}

}
