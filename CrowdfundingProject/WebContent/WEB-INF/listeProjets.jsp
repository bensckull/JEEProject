<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
  <style type="text/css">
    .col-lg-8 { line-height: 200px; }
    .col-lg-12 { line-height: 80px; }
    body {
        		padding-top: 60px;
        		/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
   			}
  </style>
  </head>
  <body>
  <%@ include file="menu.jsp" %>
    <div class="container">

      <header class="row">
        <div class="col-lg-12">
          <h2>Liste des projets présents sur le site </h2>
        </div>
      </header>

      <div class="row">

        <div class="col-lg-1">
          <br>
        </div>

        <section class="col-lg-6">
        	<br>
        	<c:forEach items="${listeProjets}" var="projet" varStatus="status">
    			<li>Projet n° <c:out value="${status.count}" /> : <c:out value="${projet.nom}" /> 
    				<ol> Type : <c:out value="${projet.typeProject}" /></ol>
    				<ol>Description : <c:out value="${projet.description}" /></ol>
       				<ol>Date de fin de collecte : <c:out value="${projet.dateFin}" /></ol>    				
    			</li>
			</c:forEach>
        </section>

        <div class="col-lg-2">
          <div class="row">
              <b>Ici mettre JSTLCore pour afficher le Nombre de projets en cours sur le site</b>
          </div>
        </div>
      </div>

    </div>
  </body>
</html>