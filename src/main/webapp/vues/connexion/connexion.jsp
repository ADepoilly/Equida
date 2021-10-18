<%-- 
    Document   : connexion
    Created on : 6 oct. 2021, 08:46:04
    Author     : adminsio
--%>

<%@page import="forms.FormCompte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Equida</title>

 <%@include file="../home/css.jsp" %>   
    
</head>
    <body>
        
        <style>
            .login {
  min-height: 100vh;
}

.bg-image {
  background-image: url('https://images5.alphacoders.com/347/thumb-1920-347516.jpg');
  background-size: cover;
  background-position: center;
}

.login-heading {
  font-weight: 300;
}

.btn-login {
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
  padding: 0.75rem 1rem;
}

        </style>
<%
                //Client client=(Client)request.getAttribute("client");
                FormCompte form = (FormCompte)request.getAttribute("form");
            %>
        
        <!--<form class="form-inline" action="afficherLoginForm" method="POST">
                <label for="id">IDENTIFIANT : </label>
                <input id="nom" type="text" name="id"  size="30" maxlength="30">
                </br>
                
                <label for="password">MOT DE PASSE : </label>
                <input id="prenom"  type="password"  name="password" size="30" maxlength="30">      
                 </br>
              
                
                
                

                                
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
            -->
            
            <div class="container-fluid ps-md-0">
              <div class="row g-0">
                <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
                <div class="col-md-8 col-lg-6">
                  <div class="login d-flex align-items-center py-5">
                    <div class="container">
                      <div class="row">
                        <div class="col-md-9 col-lg-8 mx-auto flex-column">
                          <h3 class="login-heading mb-4">Equida Login</h3><br>

                          <!-- Sign In Form -->
                          <form action="afficherLoginForm" method="POST">
                            <div>
                                <label for="id">IDENTIFIANT</label>
                              <input type="text" class="form-control" name="id" id="id" placeholder="Mon identifiant">
                              
                            </div><br>
                            <div>
                              <label for="password">MOT DE PASSE</label>
                              <input type="password" class="form-control" name="password" id="password" placeholder="Password">

                            </div><br>


                            <div>
                                <button class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-5" type="submit">Se connecter</button>
                            </div>

                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>            
            
            
            
<!-- END nav -->
    </body>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery-migrate-3.0.1.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.easing.1.3.js"></script>
<script src="../js/jquery.waypoints.min.js"></script>
<script src="../js/jquery.stellar.min.js"></script>
<script src="../js/owl.carousel.min.js"></script>
<script src="../js/jquery.magnific-popup.min.js"></script>
<script src="../js/jquery.animateNumber.min.js"></script>
<script src="../js/bootstrap-datepicker.js"></script>
<script src="../js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="../js/google-map.js"></script>
<script src="../js/main.js"></script>
    
</html>
