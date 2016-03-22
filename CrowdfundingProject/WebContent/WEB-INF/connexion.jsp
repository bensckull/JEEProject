<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	   	<meta charset="utf-8" />
		<title>Connexion</title>
        <!-- J'ai déplacé l'inclusion du bootstrap parce que ça ne respectais la structure d'un doc html5 (2 balises <head>)--> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<style>
    		body {
        		padding-top: 60px;
        		/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
   			}
    	</style>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
		<%@ include file="menu.jsp" %>
        <form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                
                <div class="row">
                <div class="col-lg-offset-1 col-lg-3">${formInscription.resultat}</div>
                </div>
                <br>
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
	                <label for="nom">Adresse email <span class="requis">*</span></label>
	                <input type="email" id="email" name="email" class="form-control" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
	                <span class="erreur">${formConnexion.erreurs['email']}</span>
	                </div>
                </div>
                
                <br>
                
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
	                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
	                <input type="password" id="motdepasse" name="motdepasse" class="form-control" value="" size="20" maxlength="20" />
	                <span class="erreur">${formConnexion.erreurs['motdepasse']}</span>
	                </div>
                </div>
                
                <br>
                
                <div class="row">
                	<div class="col-lg-offset-3 col-lg-3">
	                <input type="submit" value="Connexion" class="sansLabel" />
	                <p class="${empty formconnexion.erreurs ? 'succes' : 'erreur'}">${formConnexion.resultat}</p>
	                <%-- Vérification de la présence d'un objet utilisateur en session --%>
	                </div>
	                <c:if test="${!empty sessionScope.sessionUtilisateur}">
	                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
	                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
	                    <c:redirect url="/pageUtilisateur"/>
	                </c:if>
                </div>
                
                
            </fieldset>
        </form>
    </body>
</html>