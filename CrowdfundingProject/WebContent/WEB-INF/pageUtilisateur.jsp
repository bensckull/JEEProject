<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Page Utilisateur</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<style>
    		body {
        		padding-top: 60px;
        		/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
   			}
    	</style>
</head>

<body>


	 <%@ include file="menu.jsp" %>
	 <legend>Page Utilisateur</legend>
	 
	 <div class="row">
     	<div class="col-lg-offset-1 col-lg-3">
     		<c:if test="${!empty sessionScope.sessionUtilisateur}">
	        	<%-- Si l'utilisateur existe en session, alors on affiche son nom. --%>
	        	<p class="succes">Nom : ${sessionScope.sessionUtilisateur.nom}</p>
	        </c:if>
     	</div>
     	
     	<form method="post" action="edit">
	     	<div class="col-lg-offset-3 col-lg-3">
	     		<!--<a type="submit" value="edit" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-pencil"></span> Editer Profil</a> -->
	     	</div>
     	</form>
     </div>
     
     <div class="row">
     	<div class="col-lg-offset-1 col-lg-3">
     		<c:if test="${!empty sessionScope.sessionUtilisateur}">
	        	<%-- Si l'utilisateur existe en session, alors on affiche son nom. --%>
	        	<p class="succes">Prénom : ${sessionScope.sessionUtilisateur.prenom}</p>
	        </c:if>
     	</div>
     </div>
     
     <div class="row">
     	<div class="col-lg-offset-1 col-lg-3">
     		<c:if test="${!empty sessionScope.sessionUtilisateur}">
	        	<%-- Si l'utilisateur existe en session, alors on affiche son nom. --%>
	        	<p class="succes">Age : ${sessionScope.sessionUtilisateur.age}</p>
	        </c:if>
     	</div>
     </div>
     
     <div class="row">
     	<div class="col-lg-offset-1 col-lg-3">
     		<c:if test="${!empty sessionScope.sessionUtilisateur}">
	        	<%-- Si l'utilisateur existe en session, alors on affiche son nom. --%>
	        	<p class="succes">Pseudo : ${sessionScope.sessionUtilisateur.pseudo}</p>
	        </c:if>
     	</div>
     </div>
     
     <div class="row">
     	<div class="col-lg-offset-1 col-lg-3">
     		<c:if test="${!empty sessionScope.sessionUtilisateur}">
	        	<%-- Si l'utilisateur existe en session, alors on affiche son nom. --%>
	        	<p class="succes">Adresse : ${sessionScope.sessionUtilisateur.adresse}</p>
	        </c:if>
     	</div>
     </div>
     
     <div class="row">
     	<div class="col-lg-offset-1 col-lg-3">
     		<c:if test="${!empty sessionScope.sessionUtilisateur}">
	        	<%-- Si l'utilisateur existe en session, alors on affiche son nom. --%>
	        	<p class="succes">Email : ${sessionScope.sessionUtilisateur.email}</p>
	        </c:if>
     	</div>
     </div>
     
     
     <div class="row">
     	<div class="col-lg-offset-1 col-lg-3">
     		<h3>Projets Contribués</h3>
     	</div>
     </div>
        <section class="col-lg-6">
        	<br>
        	<c:forEach items="${listeProjetsParUtilisateur}" var="projet" varStatus="status">
    			<li>Projet n° <c:out value="${status.count}" /> : <c:out value="${projet.nom}" /> 
    				<ol> Type : <c:out value="${projet.typeProject}" /></ol>
    				<ol>Description : <c:out value="${projet.description}" /></ol>
       				<ol>Date de fin de collecte : <c:out value="${projet.dateFin}" /></ol>    				
    			</li>
			</c:forEach>
        </section>
     

</body>
</html>