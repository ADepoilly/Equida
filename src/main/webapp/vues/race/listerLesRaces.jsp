<%--
    Document   : listerLesVentes
    Created on : 18 août 2021, 16:52:29
    Author     : Donatien
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="model.TypeCheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../components/header.jsp" %>
<%@include file="../components/css.jsp" %>

<html>
        <title>Liste des Races</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
         
                
    <body> 
        <br>
        <br>
        <br>
        <br>
        <h1>Liste des Races</h1>
         <%
        ArrayList<TypeCheval> lesTypesChevaux = (ArrayList)request.getAttribute("pListeTypeCheval");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>ID</th>
                    <th>Libelle</th>
                    <th>Description</th>
            <br>
            <br>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesTypesChevaux.size();i++)
                    {
                        
                        TypeCheval unTypeCheval = lesTypesChevaux.get(i);
                        out.println("<tr><td>");
                        out.println(unTypeCheval.getId());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unTypeCheval.getLibelle());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unTypeCheval.getDescription());
                        out.println("</td>");  
                        
                        out.println("<td><a href ='../ServletTypeCheval/modifierTypeCheval?idTypeCheval="+ unTypeCheval.getId()+ "'>");
                        out.println("Modifier");
                        out.println("</td>");
                        
                    }
                    %>               
                    
                    
                </tr>
            </tbody>            
        </table>
                    
                    
                    <div class="nav-item active"><a href="../ServletTypeCheval/ajouterUneRace" class="nav-link">Ajouter une Race</a></div>
                    
    </body>
    
</html>


<%@include file="../components/footer.jsp" %>
