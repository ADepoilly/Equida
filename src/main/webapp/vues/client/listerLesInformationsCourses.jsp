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
        <p class="h1 text-center mt-5">INFORMATIONS DE LA COURSE</p>

        <%
        ArrayList<Participer> lesParticipations = (ArrayList)request.getAttribute("pLesParticipations");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    
                    <th>Nom</th>
                 
                    <th>Id du cheval</th>
                    <th>Nom du cheval</th>
                    <th>Place du cheval</th>
          
                </tr>
            </thead>
            <tbody>
                
                    <%
                    for(int i = 0; i < lesParticipations.size();i++)
                    {
                        Participer uneParticipation = lesParticipations.get(i);
                        
                        Course uneCourse = uneParticipation.getCourse();
                        
                        out.println("<tr>");
                        out.println("<td>");
                        out.println(uneCourse.getNom());
                        out.println("</td>");
                        
                          Cheval unCheval = uneParticipation.getCheval();
                        
                        out.println("<td>");
                        out.println(unCheval.getId());
                        out.println("</td>");
                        
                        out.println("<td><a href='../ServletCheval/voirCheval?chevalID="+unCheval.getId()+"'>");
                        out.println(unCheval.getNom());
                        out.println("</a></td>");
                    
                         out.println("<td>");
                        out.println(uneParticipation.getPlace());
                        out.println("</a></td>");
                        
                        out.println("</tr>");
                      
                    }
                    %>
                                                             
                
            </tbody>
        </table>
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
