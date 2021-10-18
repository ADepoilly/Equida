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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des informations de la course</title>
    </head>
    <body>
        <h1>LISTE DES INFORMATIONS DE LA COURSE</h1>
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
                        
                             out.println("<td>");
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
</html>
