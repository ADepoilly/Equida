<%--
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Zakina
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="model.Pays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../components/header.jsp" %>
<%@include file="../components/css.jsp" %>

<html>
        <title>Liste des Pays</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
         
                
    <body> 
        <h1>LISTE DES PAYS</h1>
         <%
        ArrayList<Pays> lesPays = (ArrayList)request.getAttribute("pListePays");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>Code</th>
                    <th>Nom</th>
                    <th></th>
            <br>
            <br>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesPays.size();i++)
                    {
                        
                        Pays unPays = lesPays.get(i);
                        out.println("<tr><td>");
                        out.println(unPays.getCode());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unPays.getNom());
                        out.println("</td>");
                        
                        out.println("<td><a href ='../ServletPays/modifierPays?codePays="+ unPays.getCode()+ "'>");
                        out.println("Modifier");
                        out.println("</td>");
                       
                        
                         

                        
                    }
                    %>
                    
                    
                    
                </tr>
            </tbody>            
        </table>
                    
                    
                    <div class="nav-item active"><a href="../ServletPays/ajouterPays" class="nav-link">Ajouter un Pays</a></div>
                    
    </body>
    
</html>


<%@include file="../components/footer.jsp" %>
