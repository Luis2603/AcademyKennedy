<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.*"%>
<%@ page import="model.entity.*" %>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>


<% Alumno alumno=(Alumno)request.getAttribute("alumno"); %>

<%String us=alumno.getNames();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Agregar usuarios</title>

  <!-- Bootstrap -->
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <link rel="../stylesheet" href="css/font-awesome.min.css">
  <link rel="../stylesheet" href="css/animate.css">
  <link href="../css/prettyPhoto.css" rel="stylesheet">
  <link href="../css/style.css" rel="stylesheet" />
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
                <li role="presentation"><a href="index1.html">Home</a></li>
                <li role="presentation"><a href="/alumnos">Alumnos</a></li>
                 <li role="presentation"><a href="/pensiones">Pensiones</a></li>
                 <li role="presentation"><a href="/seminaries">Seminarios</a></li>
                <li role="presentation"><a href="/roles">Roles</a></li>
                <li role="presentation"><a href="/users">Users</a></li>
                <li role="presentation"><a href="/resources">Resources</a></li>
                <li role="presentation"><a href="/access">Access</a></li>
                <li role="presentation"><a href="/users/login">Login</a></li>
                <li role="presentation"><a href="/users/logout">Logout</a></li>
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
        <li>Alumnos</li>
      </div>
    </div>
  </div><br>
 </ul>
</nav><br><br>
<a>
	  <form action="/pagar" method="get" id="newsletter-form" >
	            <fieldset>
	            <div class="rowElem">
	               <h2>Pagar Pension</h2>
	               <h4>Mes:</h4>
	               <select name="mes">
					   <option value="Marzo">Marzo</option>
					   <option value="Abril">Abril</option>
					   <option value="Mayo">Mayo</option>
					   <option value="Junio">Junio</option>
					   <option value="Julio">Julio</option>
					   <option value="Agosto">Agosto</option>
					   <option value="Septiembre">Septiembre</option>
					   <option value="Octubre">Octubre</option>
					   <option value="Noviembre">Noviembre</option>
					   <option value="Diciembre">Diciembre</option>
				   </select>
				   <br><br>
				   <h4>Ingrese Monto:</h4>
	               <div class="input"><input type="number" name="monto" required><br></div>
						
			       <input type="submit" value="Aceptar">
			      <h3>ALUMNO: <%=alumno.getNames() %></h3><br>
			 
			<h2><span>DEUDAS AÑO 2015</span></h2>
			
			<div class="table">
                    <table class="listing" cellpadding="0" cellspacing="0">
                        <tr>
                            <th>Mes</th>
                            <th>Monto</th>
                            <th>Saldo</th>                        
                         
                        </tr>
                        
                        	<%for( Pension p : alumno.getPensiones() ) {%>
                        <tr>
							    <td class="style1"><p><%=p.getMes() %></p></td>
								<td><p><%=p.getMonto() %></p></td>
								<td><p><%=p.getSaldo()%></p></td>
						</tr>
						    <%}%>
						             
                    </table>

		
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
