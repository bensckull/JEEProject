<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
		<%@ include file="menu.jsp" %>
        <form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                
                <div class="row">
                <div class="col-lg-offset-1 col-lg-3">Vous pouvez vous connecter via ce formulaire.</div>
                </div>
                
                <br>

                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
	                <label for="nom">Adresse email <span class="requis">*</span></label>
	                <input type="email" id="email" name="email" class="form-control" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
	                <span class="erreur">${form.erreurs['email']}</span>
	                </div>
                </div>
                
                <br>
                
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
	                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
	                <input type="password" id="motdepasse" name="motdepasse" class="form-control" value="" size="20" maxlength="20" />
	                <span class="erreur">${form.erreurs['motdepasse']}</span>
	                </div>
                </div>
                
                <br>
                
                <div class="row">
                	<div class="col-lg-offset-3 col-lg-3">
	                <input type="submit" value="Connexion" class="sansLabel" />
	                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
	                <%-- Vérification de la présence d'un objet utilisateur en session --%>
	                </div>
	                <c:if test="${!empty sessionScope.sessionUtilisateur}">
	                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
	                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
	                </c:if>
                </div>
                
                
            </fieldset>
        </form>
    </body>
</html>