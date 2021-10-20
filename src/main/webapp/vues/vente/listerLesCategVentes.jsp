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
        
         <%@include file="../components/css.jsp" %> 
    </head>
    <body>
        
        
        <%@include file="../components/header.jsp" %> 
        
        
<section class="hero-wrap hero-wrap-2" style="height: 10vh; background-image: url('https://picardie.media.tourinsoft.eu/upload/Hippodrome-Chantilly--1-.jpg');">

</section>

<section>
        <p class="h1 text-center mt-5">LISTE DES CATEGORIES DE VENTES</p>

        <%
        ArrayList<CategVente> lesCategVentes = (ArrayList)request.getAttribute("pLesCategVente");
        %>
        <table  class="table table-bordered table-striped table-condensed" style="width: 80%; margin: 0 auto;">  
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
                    for(int i = 0; i < lesCategVentes.size();i++)
                    {
                        
                        CategVente uneCategorie = lesCategVentes.get(i);
                        out.println("<tr><td>");
                        out.println(uneCategorie.getCode());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(uneCategorie.getLibelle());
                        out.println("</td>");
                        
                    }
                    %>
                </tr>
            </tbody>
        </table>
</section>
    </body>
</html>
