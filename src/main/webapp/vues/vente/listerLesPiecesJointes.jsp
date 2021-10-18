<%-- 
    Document   : listerLesPiecesJointes
    Created on : 20 sept. 2021, 14:57:44
    Author     : Matteo
--%>


<%@page import="model.PieceJointe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des Pieces Jointes</title>
    </head>
    <body>
        <h1>LISTE DES PIECES JOINTES</h1>
         <%
        ArrayList<PieceJointe> lesPiecesJointes = (ArrayList)request.getAttribute("pLesPiecesJointes");
        %>
        <table  class="table table-bordered table-striped table-condensed">
            <thead>
                <tr>
                    <th>id</th>
                    <th>chemin</th>
                    <th>description</th> 
                    <th></th>
            <br>
            <br>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesPiecesJointes.size();i++)
                    {

                        PieceJointe unePieceJointe = lesPiecesJointes.get(i);
                        out.println("<tr><td>");
                        out.println(unePieceJointe.getId());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unePieceJointe.getChemin());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unePieceJointe.getDescription());
                        out.println("</td>");


                    }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
