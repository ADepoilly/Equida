<%-- 
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Zakina
--%>

<%@page import="model.Cheval"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Vente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="fr">
<head>
    <title>Equida</title>
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
        <p class="h1 text-center mt-5">Lister les chevaux</p>

         <%
        ArrayList<Cheval> lesChevaux = (ArrayList)request.getAttribute("pLesChevaux");
        %>
        <div class="nav-item active"><a href="../ServletCheval/ajouterCheval" class="nav-link text-center">Ajouter un Cheval</a></div>
        <table  class="table table-bordered table-striped table-condensed"   style="width: 80%; margin: 0 auto;">  
            <thead>
                <tr>             

                    <th>Nom</th>
                    <th>Sexe</th>
                    <th>Sire</th>  
                    <th>Date de naissance</th>
                    <th>Type</th>
                    <th>Père</th>
                    <th>Mère</th>


                </tr>
            </thead>
            <tbody>
                    <%
                    for(int i = 0; i < lesChevaux.size();i++)
                    {
                        
                        Cheval unCheval = lesChevaux.get(i);
                        out.println("<tr>");

                        out.println("<td><a href='../ServletCheval/voirCheval?chevalID="+unCheval.getId()+"'>");
                        out.println(unCheval.getNom());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unCheval.getSexe());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unCheval.getSire());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unCheval.getDateNaissance());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unCheval.getLeTypeCheval().getLibelle());
                        out.println("</td>");


                        out.println("<td>");
                        out.println(unCheval.getPere().getNom());
                        out.println("</td>");                     
     
                        
                        out.println("<td>");
                        out.println(unCheval.getMere().getNom());
                        out.println("</td>");   
                        
                        out.println("</tr>");
                    }
                    %>
            </tbody>

        </table>

                
                
              
                
                
                
                
</section>


 <%//@include file="../components/footer.jsp" %> 

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

</body>
</html>




