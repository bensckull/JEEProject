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
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
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
						<label for="date">date de fin :</label>
		                <input type="date" class="form-control"  id="date" name="date" value="<c:out value=""/>" size="20" maxlength="20" />
                	</div>
                </div>
                
                
                <div class="row">
                	<div class="col-lg-offset-1 col-lg-3">
		                <div class="form-group">
						  <label for="descr">Description du projet:</label>
						  <textarea class="form-control" rows="5" id="comment" size="20"></textarea>
						</div>
                	</div>
                </div>
                
                <div class="row">
		
		        <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker1').datetimepicker();
		            });
		        </script>
                
                </div>
                
        </fieldset>
</body>
</html>