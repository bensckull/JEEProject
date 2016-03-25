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
        <form method="post" action="participation">
            <fieldset>
                <legend>Participer</legend>
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
	                <label for="montant">Montant a donner <span class="requis">*</span></label>
	                <input type="texte" id="montant" name="montant" class="form-control" value="<c:out value=""/>" size="20" maxlength="60" />
	                </div>
                
                <br>
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-1">
	                <input type="submit" value="Participer" class="sansLabel" />
                </div>
                
                
            </fieldset>
        </form>
    </body>
</html>