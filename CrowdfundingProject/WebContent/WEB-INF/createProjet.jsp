<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Nouveau Projet</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css" type="text/css" media="all" />
       <link rel="stylesheet" href="http://static.jquery.com/ui/css/demo-docs-theme/ui.theme.css" type="text/css" media="all" />
		
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js" type="text/javascript"></script>
       <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js" type="text/javascript"></script>
       <script src="http://jqueryui.com/resources/demos/datepicker/datepicker-fr.js" type="text/javascript"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
		<style>
    		body {
        		padding-top: 60px;
        		/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
   			}
   			
   			textarea{ 
			  width: 400px; 
			  min-width:400px; 
			  max-width:400px; 
			
			  height:400px; 
			  min-height:400px;  
			  max-height:400px;
			}
    	</style>
</head>
<body>
		<%@ include file="menu.jsp" %>
		<form method="post" action="ProjetServlet">
		<fieldset>
                <legend>Création projet</legend>
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
						<label for="nom">Nom du projet:</label>
		                <input type="text" class="form-control"  id="nom" name="nom" value="<c:out value=""/>" size="20" maxlength="20" />
                	</div>
                </div>
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
						<label for="type">type :</label>
		                <input type="text" class="form-control"  id="type" name="type" value="<c:out value=""/>" size="20" maxlength="20" />
                	</div>
                </div>
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
						<label for="montant">Montant maximum :</label>
		                <input type="montant" class="form-control"  id="montant" name="montant" value="<c:out value=""/>" size="20" maxlength="20" />
                	</div>
                </div>
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
						<label for="datepicker">date de fin :</label>
		                <input type="text" class="form-control" id="datepicker" name="datepicker"  value="<c:out value=""/>" size="20" maxlength="20" />
		 			</div>
				</div>
				<script type="text/javascript">
					$(document).ready(function(){
						$('#datepicker').datepicker($.datepicker.regional['fr']);
					});
				</script>
                
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
		                <div class="form-group">
						  <label for="descr">Description du projet:</label>
						  <textarea class="form-control" rows="5" id="comment" size="20"></textarea>
						</div>
                	</div>
                </div>
                
                <div class="row">
                	<div class="col-lg-offset-4 col-lg-3">
                	<input type="submit" value="Créer" class="sansLabel" />
                	</div>
                </div>
        </fieldset>
        </form>
        
</body>
</html>