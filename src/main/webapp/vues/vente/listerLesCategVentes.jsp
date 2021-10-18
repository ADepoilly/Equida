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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lister les catégories de vente</title>
    </head>
    <body>
        <h1>LISTE DES CATEGORIES DE VENTE</h1>
        <%
        ArrayList<CategVente> lesCategVentes = (ArrayList)request.getAttribute("pLesCategVente");
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
                    for(int i = 0; i < lesCategVente.size();i++)
                    {
                        
                        CategVente uneCategorie = lesCategVente.get(i);
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
</html>
