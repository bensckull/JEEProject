<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Site CrowdFounding</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/CrowdfundingProject/">Accueil</a></li>
            
            <c:choose>
		      <c:when test="${!empty sessionScope.sessionUtilisateur}">
		  		<li><a href="/CrowdfundingProject/deconnexion">Deconnexion</a></li>
		  		<li><a href="/CrowdfundingProject/createProjet">Nouveau Projet</a></li>
		  		<li><a href="/CrowdfundingProject/pageUtilisateur">Profil</a></li>
		      </c:when>
		
		      <c:otherwise>
		      	<li><a href="/CrowdfundingProject/inscription">Inscription</a></li>
		      	<li><a href="/CrowdfundingProject/connexion">Connexion</a></li>
		      </c:otherwise>
            </c:choose>
            
            <li><a href="/CrowdfundingProject/listeProjets">Projets</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
</div>