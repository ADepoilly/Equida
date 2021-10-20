<%-- 
    Document   : listerLesCategVentes
    Created on : 18 oct. 2021, 09:35:55
    Author     : Antonin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.CategVente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Liste des catégories de ventes</title>
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
        <p class="h1 text-center mt-5">CATEGORIES DE VENTES</p>
        <%
        ArrayList<CategVente> lesCategVentes = (ArrayList)request.getAttribute("pLesCategVentes"); 
        %>
    <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>Code</th>
                    <th>Libelle</th>                                     
            <br>
            <br>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesCategVentes.size();i++)
                    {
                        
                        CategVente uneCategorie = lesCategVentes.get(i);
                        out.println("<tr><td>");
                        out.println(uneCategorie.getCode());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(uneCategorie.getLibelle());
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletVente/listerLesCategVentes?codeCategVente="+ uneCategorie.getCode()+ "'>");
                        out.println("</td>");
                    }
                    %>
                </tr>
            </tbody>
        </table>
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
