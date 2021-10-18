<%-- 
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Zakina
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Courriel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des courriel</title>
    </head>
    <body>
        <h1>LISTE DES COURRIELS</h1>
         <%
        ArrayList<Courriel> lesCourriels = (ArrayList)request.getAttribute("pLesCourriels");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>Corps</th>
                    <th>Objet</th> 
                    <th></th>
            <br>
            <br>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesCourriels.size();i++)
                    {
                        
                        Courriel unCourriel = lesCourriels.get(i);
                        out.println("<tr><td>");
                        out.println(unCourriel.getId());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unCourriel.getCorps());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unCourriel.getObjet());
                        out.println("</td>");
                       
                        
                        out.println("<td><a href ='../ServletVente/listerLesPiecesJointes?idCourriel="+ unCourriel.getId()+ "'>");
                        out.println("Lister des pièces jointes");
                        out.println("</td>");
                    }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
