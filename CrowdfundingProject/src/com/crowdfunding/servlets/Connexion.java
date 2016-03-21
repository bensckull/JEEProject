package com.crowdfunding.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crowdfunding.beans.ConnexionForm;
import com.crowdfunding.beans.Utilisateur;
import com.crowdfunding.dao.UtilisateurDao;


public class Connexion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "formConnexion";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE1              = "/WEB-INF/connexion.jsp";
    public static final String VUE2              = "/WEB-INF/pageUtilisateur.jsp";
	private UtilisateurDao     utilisateurDao;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE1).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
    	ConnexionForm form = new ConnexionForm(utilisateurDao);
        Utilisateur utilisateur = form.connecterUtilisateur(request);
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if (form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );

        this.getServletContext().getRequestDispatcher(VUE1).forward( request, response );
    }
}
