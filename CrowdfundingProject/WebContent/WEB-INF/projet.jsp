<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <style type="text/css">
     /* Style pour l'exemple*/
      article.col-sm-10, nav.col-sm-2 {
        line-height: 100px;
      }
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
        <div class="col-lg-12">
        		<div class="container">
	              		<div class="bs-example">
    						<div class="progress">
       							 <div class="progress-bar" style="width: 60%;">60%</div>
						    </div>
						</div>
              		</div>
        	<br>
          <h1>Nom Du Projet</h1>
                     
        </div>
      </header>
      <div class="row">
        <section class="col-sm-10">
          <d>Image de présentation du projet</d>
          <div class="row">
            <article class="col-sm-10">
              <d>Présentation détaiilé du projet</d>
            </article>
            <div class="col-lg-2">
              <div class="row">
				  <div class="container">
				    <h3>Participer</h3>
				    <p><a class="btn btn-info btn-lg" role="button">Cliquez Maintenant !  <span class="glyphicon glyphicon-euro"></span></a></p>
				  </div>
              </div>
              <div class="row">
                 <li><d> XXX Comtributeurs </d></li>
                 <li><d> 000€/$ récoltés</d></li>
                 <li><d> 00 jours restants </d></li>
              </div>
            </div>
          </div>
        </section>
      </div>
      <footer class="row">
        <div class="col-lg-12">
          Pied de page
        </div>
      </footer>
    </div>
  </body>
</html>