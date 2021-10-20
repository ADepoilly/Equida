<%-- 
    Document   : listerLesClientsParCategVente
    Created on : 18 août 2021, 17:52:16
    Author     : Zakina
--%>

<%@page import="model.Client"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Liste des clients par catégories de ventes</title>
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
        <p class="h1 text-center mt-5">LISTE DES CLIENTS POUR UNE CATEGORIE DE VENTE</p>

         <%
        ArrayList<Client> lesClients = (ArrayList)request.getAttribute("pLesClients");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Pays</th>
                    <th>Rue</th>
                    <th>Code Postal</th>
                    <th>Ville</th>
                    <th>Adresse Messagerie</th>
            <br>
            <br>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesClients.size();i++)
                    {
                        Client unClient = lesClients.get(i);
                        out.println("<tr><td>");
                        out.println(unClient.getId());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unClient.getNom());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unClient.getPrenom());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unClient.getLePays().getNom());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unClient.getAdrRue());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unClient.getCodePostal());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unClient.getVille());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unClient.getAdresseMessagerie());
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
