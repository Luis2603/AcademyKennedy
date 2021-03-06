<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.Alumno"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%  UserService us = UserServiceFactory.getUserService();
	com.google.appengine.api.users.User user = us.getCurrentUser();
	boolean hayusuarioactivo=false;
	if(user != null){
		hayusuarioactivo=true;
	}else{
		hayusuarioactivo=false;
	}							
																	%>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Agregar Alumno</title>

  <!-- Bootstrap -->
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <link rel="../stylesheet" href="css/font-awesome.min.css">
  <link rel="../stylesheet" href="css/animate.css">
  <link href="../css/prettyPhoto.css" rel="stylesheet">
  <link href="../css/style.css" rel="stylesheet" />
  <link href="../css/form.css" rel="stylesheet">
  <!-- =======================================================
    Theme Name: Company
    Theme URL: https://bootstrapmade.com/company-free-html-bootstrap-template/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>
  <header>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="navigation">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse.collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
            <div class="navbar-brand">
              <a href="index.html"><h1><span>Aca</span>demy</h1></a>
            </div>
          </div>

          <div class="navbar-collapse collapse">
            <div class="menu">
              <ul class="nav nav-tabs" role="tablist">
                <li role="presentation"><a href="/index1.html">Home</a></li>
                <li role="presentation"><a href="/alumnos">Alumnos</a></li>
                <li role="presentation"><a href="/seminaries">Seminarios</a></li>
                <li role="presentation"><a href="/roles">Roles</a></li>
                <li role="presentation"><a href="/users">Users</a></li>
                <li role="presentation"><a href="/resources">Resources</a></li>
                <li role="presentation"><a href="/access">Access</a></li>
                <%if(hayusuarioactivo){ %>
                <li role="presentation"><a href="/users/login"><%= user.getEmail() %></a></li>
                <li role="presentation"><a href="/users/logout">Salir</a></li>
                <% }else{ %>
                <li role="presentation"><a href="/users/login">Iniciar Sesión</a></li>
                <% }%>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </nav>
  </header>

  <div id="breadcrumb">
    <div class="container">
      <div class="breadcrumb">
        <li><a href="index.html">Home</a></li>
        <li>Contact</li>
      </div>
    </div>
  </div>

  

 
	<h2 align="center" >Actions</h2>
	
  					<h3 align="center"><a href="/seminaries">Ver Seminarios Programados</a></h3>
					<form method="post" action="/seminaries/add">
				
					<table border="0" style="color: black;">
						<tr>
							<td>Curso:</td>
							<td><select name="course">
								  <option value="Matematica Básica">Matemática Basica</option>
								  <option value="Fisica I">Física I</option>
								  <option value="Fisica II">Física II</option>
								  <option value="Fisica III">Física III</option>
								  <option value="Química I">Química I</option>
								  <option value="Química II">Química II</option>
								  <option value="Química III">Química III</option>
								  <option value="Biologia I">Biologia I</option>
								  <option value="Biologia II">Biologia II</option>
								  <option value="Constitución">Constitución</option>
								  <option value="Trigonometria">Trigonometria</option>
								  <option value="Historia">Historia</option>
								  <option value="Psicotecnico">Psicotecnico</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Profesor a cargo:</td>
							<td><input type="text" name="teacher" required></td>
						</tr>
						<tr>
							<td>Aula:</td>
							<td><input type="text" name="classroom" required></td>
						</tr>
						<tr>
							<td>Fecha:</td>
							<td><input type="text" name="date"></td>
						</tr>
						<tr>
							<td>Hora:</td>
							<td><select name="hour">
								<option value="1:00pm - 3:00pm">1:00pm - 3:00pm</option>
								<option value="2:00pm - 4:00pm">2:00pm - 4:00pm</option>
								<option value="3:00pm - 5:00pm">3:00pm - 5:00pm</option>
								<option value="4:00pm - 6:00pm">4:00pm - 6:00pm</option>
								<option value="5:00pm - 7:00pm">5:00pm - 7:00pm</option>
								<option value="6:00pm - 8:00pm">6:00pm - 8:00pm</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input id="botonsubmit" type="submit" value="Guardar"></td>

						</tr>
					</table>
  				</form>


  
    <!--/.container-->
  </section>
  <!--/#contact-page-->

  <footer>
    <div class="footer">
      <div class="container">
        <div class="social-icon">
          <div class="col-md-4">
            <ul class="social-network">
              <li><a href="#" class="fb tool-tip" title="Facebook"><i class="fa fa-facebook"></i></a></li>
              <li><a href="#" class="twitter tool-tip" title="Twitter"><i class="fa fa-twitter"></i></a></li>
              <li><a href="#" class="gplus tool-tip" title="Google Plus"><i class="fa fa-google-plus"></i></a></li>
              <li><a href="#" class="linkedin tool-tip" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
              <li><a href="#" class="ytube tool-tip" title="You Tube"><i class="fa fa-youtube-play"></i></a></li>
            </ul>
          </div>
        </div>

        <div class="col-md-4 col-md-offset-4">
          <div class="copyright">
            &copy; Company Theme. All Rights Reserved.
            <div class="credits">
              <!--
                All the links in the footer should remain intact.
                You can delete the links only if you purchased the pro version.
                Licensing information: https://bootstrapmade.com/license/
                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Company
              -->
              <a href="https://bootstrapmade.com/bootstrap-business-templates/">Bootstrap Business Templates</a> by <a href="https://bootstrapmade.com/">BootstrapMade</a>
            </div>
          </div>
        </div>
      </div>
      <div class="pull-right">
        <a href="#home" class="scrollup"><i class="fa fa-angle-up fa-3x"></i></a>
      </div>
    </div>
  </footer>

  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="js/jquery-2.1.1.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.prettyPhoto.js"></script>
  <script src="js/jquery.isotope.min.js"></script>
  <script src="js/wow.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8HeI8o-c1NppZA-92oYlXakhDPYR7XMY">
  </script>
  <script src="js/functions.js"></script>
  <script src="contactform/contactform.js"></script>

</body>

</html>