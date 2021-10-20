<%-- 
    Document   : consulterClient
    Created on : 19 août 2021, 15:17:27
    Author     : Zakina
--%>

<%@page import="model.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Consultation du profil</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
     <%@include file="../components/css.jsp" %> 
</head>
<body>
    <%@include file="../components/header.jsp" %> 
<!-- END nav -->

<section class="hero-wrap hero-wrap-2" style="height: 10vh; background-image: url('https://picardie.media.tourinsoft.eu/upload/Hippodrome-Chantilly--1-.jpg');">

</section>

<section>
        <p class="h1 text-center mt-5">INFORMATIONS DU CLIENT</p>
         <%
        Client unClient = (Client)request.getAttribute("pClient");
        %>
        
         
        <table class="float-center" style="margin-left: 45%;">
            <tr><td>ID </td><td class="text-center"><% out.println(unClient.getId());%></td></tr>
            <tr><td>NOM </td><td class="text-center"><% out.println(unClient.getNom());%></td></tr>
            <tr><td>PRENOM </td><td class="text-center"><%  out.println(unClient.getPrenom());%></td></tr>
            <tr><td>Rue </td><td class="text-center"><%  out.println(unClient.getAdrRue());%></td></tr>
            <tr><td>Code Postal </td><td class="text-center"><%  out.println(unClient.getCodePostal());%></td></tr>
            <tr><td>Ville </td><td class="text-center"><%  out.println(unClient.getVille());%></td></tr>
            <tr><td>Email </td><td class="text-center"><%  out.println(unClient.getAdresseMessagerie());%></td></tr>
            
        </table>
            
          <%-- 
            ! Catégories selectionnées
          <% for (int i=0; i<unClient.getLesCategVente().size(); i++){
               out.println(unClient.getLesCategVente().get(i).getCode() + "</br>");
             
          }
          %> 
          --%>
              
         
        
    </body>
    
    <%@include file="../components/footer.jsp" %> 

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
