<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
	   	<meta charset="utf-8" />
		<title>Inscription</title>
        <!-- J'ai déplacé l'inclusion du bootstrap parce que ça ne respectais la structure d'un doc html5 (2 balises <head>)--> 
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
        <form method="post" action="Inscription">
        
            <fieldset>
                <legend>Inscription</legend>
                
                <div class="row">
                <div class="col-lg-offset-1 col-lg-3"><p>Vous pouvez vous inscrire via ce formulaire.</p></div>
                </div>
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
					<label for="nom">Nom</label>
	                <input type="text" class="form-control"  id="nom" name="nom" value="<c:out value="${param.nom}"/>" size="20" maxlength="20" />
	                <span class="erreur">${formInscription.erreurs['nom']}</span>
                	</div>
                </div>
                <br />
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
	                <label for="prenom">Prenom</label>
	                <input type="text" class="form-control"  id="prenom" name="prenom" value="<c:out value="${param.prenom}"/>" size="20" maxlength="20" />
	                <span class="erreur">${formInscription.erreurs['prenom']}</span>
                	</div>
                </div>
                
                <br />
				
				<div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
					<label for="pseudo">Pseudo</label>
	                <input type="text" class="form-control"  id="pseudo" name="pseudo" value="<c:out value="${param.pseudo}"/>" size="20" maxlength="20" />
	                <span class="erreur">${formInscription.erreurs['pseudo']}</span>
               		 </div>
                </div>
                <br />
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
	                <label for="email">Adresse email <span class="requis">*</span></label>
	                <input type="email" class="form-control"  id="email" name="email" value="<c:out value="${param.email}"/>" size="20" maxlength="60" />
	                <span class="erreur">${formInscription.erreurs['email']}</span>
                	</div>
                </div>
                <br />

				<div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
	                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
	                <input type="password" class="form-control"  id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
	                <span class="erreur">${formInscription.erreurs['motdepasse']}</span>
                	</div>
                </div>
                <br />
				
				<div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
	                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
	                <input type="password" class="form-control"  id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
	                <span class="erreur">${formInscription.erreurs['confirmation']}</span>
                	</div>
                </div>
                <br />
				
				<div class="row">
                	<div class="col-lg-offset-3 col-lg-3">
                	<input type="submit" value="Inscription" class="sansLabel" />
                	</div>
                </div>
                <br />
                
                <p class="${empty formInscription.erreurs ? 'succes' : 'erreur'}">${formInscription.resultat}</p>
            </fieldset>
        </form>
    </body>
</html>