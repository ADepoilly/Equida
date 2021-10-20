<%-- 
    Document   : listerLesCourses
    Created on : 6 oct. 2021, 10:48:04
    Author     : Antonin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="fr">
<head>
    <title>Liste des courses</title>
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
        <p class="h1 text-center mt-5">LISTE DES COURSES</p>

        <%
        ArrayList<Course> lesCourses = (ArrayList)request.getAttribute("pLesCourses");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Lieu</th> 
                    <th>Date</th>
          
            
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesCourses.size();i++)
                    {
                        
                        Course uneCourse = lesCourses.get(i);
                        out.println("<tr><td>");
                        out.println(uneCourse.getId());
                        out.println("</a></td>");

                        out.println("<td><a href='http://localhost:8080/equida/ServletClient/listerLesInformationsCourses?idCourse="+uneCourse.getId()+"'>");
                        out.println(uneCourse.getNom());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(uneCourse.getLieu());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(uneCourse.getDate());
                        out.println("</td>");
                       
                      
                        out.println("</tr>");
                    }
                    %>
               
            </tbody>
        </table>
</section>
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
