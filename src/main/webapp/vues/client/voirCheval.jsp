<%-- 
    Document   : listerLesInformationsCourses
    Created on : 11 oct. 2021, 11:00:29
    Author     : Antonin
--%>

<%@page import="model.Cheval"%>
<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Participer"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Liste des informations de la course</title>
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
        <p class="h1 text-center mt-5">INFORMATIONS D'UN CHEVAL</p>

        <%
        Cheval unCheval = (Cheval)request.getAttribute("pLeCheval");
        %>

        <div class="container mt-6" style="display: flex; flex-direction: row; margin-top: 10vh; align-items: center;">
            <div><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUCZD4h2cRPNdckX_8onUZTfHgRliRKWbI_F8RZZ6Gn-e_QzuaZt8ngJz8pYFxXJdRmy8&usqp=CAU"></div>
            <div style="margin-left: 5%;">
                <% out.println("<p>NOM : "+unCheval.getNom()+"</p>"); %>
                <% out.println("<p>SEXE : "+unCheval.getSexe()+"</p>"); %>
                <% out.println("<p>SIRE : "+unCheval.getSire()+"</p>"); %>
                <% out.println("<p>DATE DE NAISSANCE : "+unCheval.getDateNaissance()+"</p>"); %>
                <% out.println("<p>Race : "+unCheval.getLeTypeCheval().getLibelle()+"</p>"); %>
                <% out.println("<p>Père : "+unCheval.getPere().getNom()+"</p>"); %>
                <% out.println("<p>Mère : "+unCheval.getMere().getNom()+"</p>"); %>
            </div>
            
            
        </div>
                <a style="margin-top: 10vh;" href="../ServletCheval/modifierCheval?idCheval=<%out.println(unCheval.getId());%>" class="nav-link text-center">Modifier <% out.println(unCheval.getNom()); %></a>

                

                                                             

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
