<%-- 
    Document   : listerLesChevauxParVente
    Created on : 22 sept. 2021, 10:41:41
    Author     : Matteo
--%>

<%@page import="model.Lot"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des Chevaux </title>
    </head>
    <body>
        <h1>LISTE DES CHEVAUX</h1>
        <%
            ArrayList<Lot> lesLots = (ArrayList)request.getAttribute("pLesLots");
        %>
        <table class="table table-bordered table-striped table-condensed">
            <thead>
                <tr>
                    <th>id</th>
                    <th>PrixDepart</th>
                    <th>Nom</th>
                    <th>Sexe</th>
                    <th>Sire</th>
                    <th>DateDeNaissance</th>
                    <th>race</th>
                    <th>description</th>
                    <th>Pere</th>
                    <th>Mere</th>
            <br>
            <br>
                </tr>
                </thead>
                <tbody>
                    <tr>
                    <%
                        for(int i = 0; i <lesLots.size();i++)
                        {
                            
                        Lot unLot = lesLots.get(i);
                        System.out.println(unLot.getId());
                        out.println("<tr><td>");
                        out.println(unLot.getId());
                        out.println("</a></td>");
                        
                        out.println("<td>");
                        out.println(unLot.getPrixDepart());
                        out.println("</td>");
                        
                      
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getNom());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getSexe());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getSire());
                        out.println("</td>");
                      
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getDateNaissance());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getLeTypeCheval().getLibelle());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getLeTypeCheval().getDescription());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getPere().getNom());
                        out.println("</td>");
                      
                        out.println("<td>");
                        out.println(unLot.getLeCheval().getMere().getNom());
                        out.println("</td>");
                      
                    }
                    %>
                    </tr>
                </tbody>
        </table>
    </body>
</html>
