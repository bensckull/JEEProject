<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <style type="text/css">
     /* Style pour l'exemple*/
      body {
        		padding-top: 60px;
        		/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
   			}
   			
   	.bs-example{
    	margin: 1px;
    }
    </style>
  </head>
  <body>
    <%@ include file="menu.jsp" %>
    <div class="container">
      <header class="row">
        <div class="col-lg-6">
        		<div class="container">
	              		<div class="bs-example">
    						<div class="progress">
       							 <div class="progress-bar" style="width: 60%;">60%</div>
						    </div>
						</div>
              		</div>
        	<br>
          <h1>${projet.nom}</h1>
                     
        </div>
      </header>
      <div class="row">
        <section class="col-sm-10">
          <d name="idprojet" >id projet : ${projet.idProjet}</d>
          <div class="row">
            <article class="col-sm-10">
              <p>Description :</p>
              <p>${projet.description}</p>
            </article>
            <div class="col-lg-2">
				   <!-- <h3>Participer</h3> --> 
			    <form method="post" action="participation">
           			<fieldset>
           			<div class="row">
                	<h3>Participer</h3>
	                <div class="col-lg-13">
	                	<label for="montant">Montant a donner : </label>
	                	<input type="text" id="montant" name="montant" class="form-control" value="<c:out value=""/>" size="20" maxlength="60" />
	                	<input type="hidden" id="idUser" name="idUser" value="${projet.idProjet}" />
	                </div>
	                </div>
	                <br>
	                <div class="row">
	                <div class="col-lg-1">
	                	<p><input class="btn btn-info btn-lg" type="submit" value="Participer" class="sansLabel" />
	                </div>  
	                </div>              
          		 	</fieldset>
       			 </form>
              <div class="row">
                 <li><d>${projet.nbreParticipant} Contributeurs </d></li>
                 <li><d>${projet.montantRecolte} € récoltés</d></li>
                 <li><d> 00 jours restants </d></li>
              </div>
            </div>
          </div>
        </section>
      </div>
      <footer class="row">
        <div class="col-lg-12">
          <!-- Pied de page -->
        </div>
      </footer>
    </div>
  </body>
</html>