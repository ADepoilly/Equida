<%-- 
    Document   : listerLesChevauxParVente
    Created on : 22 sept. 2021, 10:41:41
    Author     : Matteo
--%>

<%@page import="model.Lot"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Liste des chevaux en fonction d'une vente</title>
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
        <p class="h1 text-center mt-5">LISTE DES CHEVAUX PAR VENTE</p>
        <%
            ArrayList<Lot> lesLots = (ArrayList)request.getAttribute("pLesLots");
        %>
        <table class="table table-bordered table-striped table-condensed">
            <thead>
                <tr>
                    <th>id</th>
                    <th>PrixDepart</th>
                    <th>Nom</th>
                    <th>Sexe</th>
                    <th>Sire</th>
                    <th>DateDeNaissance</th>
                    <th>race</th>
                    <th>description</th>
                    <th>Pere</th>
                    <th>Mere</th>
            <br>
            <br>
                </tr>
                </thead>
                <tbody>
                    <tr>
                    <%
                        for(int i = 0; i <lesLots.size();i++)
                        {
                            
                        Lot unLot = lesLots.get(i);
                        System.out.println(unLot.getId());
                        out.println("<tr><td>");
                        out.println(unLot.getId());
                        out.println("</a></td>");
                        
                        out.println("<td>");
                        out.println(unLot.getPrixDepart());
                        out.println("</td>");
                        
                      
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getNom());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getSexe());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getSire());
                        out.println("</td>");
                      
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getDateNaissance());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getLeTypeCheval().getLibelle());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getLeTypeCheval().getDescription());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getPere().getNom());
                        out.println("</td>");
                      
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getMere().getNom());
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
