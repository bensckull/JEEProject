<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<style>
	    	body {
	        	padding-top: 60px;
	        	/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
	   		}
			body, p, legend, label, input {font: normal 8pt verdana, helvetica, sans-serif;}
			fieldset { padding: 10px; border: 1px #0568CD solid;}
			legend { font-weight: bold; color: #0568CD;	}			
			form label {float: left; width: 200px;margin: 3px 0px 0px 0px;}
			form input { margin: 3px 3px 0px 0px; border: 1px #999 solid;}
			form input.sansLabel { margin-left: 200px;}
			form .requis {color: #c00;}
			form .erreur {color: #900;}
			form .succes {color: #090;}
	    </style>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
				<label for="nom">Nom</label>
                <input type="text" id="nom" name="nom" value="<c:out value="${param.nom}"/>" size="20" maxlength="20" />
                <span class="erreur">${erreurs['nom']}</span>
                <br />
                <label for="prenom">Prenom</label>
                <input type="text" id="prenom" name="prenom" value="<c:out value="${param.prenom}"/>" size="20" maxlength="20" />
                <span class="erreur">${erreurs['prenom']}</span>
                <br />

				<label for="pseudo">Pseudo</label>
                <input type="text" id="pseudo" name="pseudo" value="<c:out value="${param.pseudo}"/>" size="20" maxlength="20" />
                <span class="erreur">${erreurs['pseudo']}</span>
                <br />
                
                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${param.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${erreurs['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['motdepasse']}</span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['confirmation']}</span>
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
                <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
            </fieldset>
        </form>
    </body>
</html>