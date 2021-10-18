<%-- 
    Document   : listerLesCourses
    Created on : 6 oct. 2021, 10:48:04
    Author     : Antonin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des courses</title>
    </head>
    <body>
        <h1>LISTE DES COURSES</h1>
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
    </body>
</html>
