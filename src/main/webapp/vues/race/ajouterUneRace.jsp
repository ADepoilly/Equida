<%-- 
    Document   : ajouterUneRace
    Created on : 13 oct. 2021, 09:21:03
    Author     : Donatien
--%>

<%@page import="forms.FormTypeCheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../components/header.jsp" %>
<%@include file="../components/css.jsp" %>


<html>
        <title>AjouterUneRace</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        
    <body>        
        <br>
        <br>
        <br>
        <h1>Ajout d'une nouvelle Race</h1>
        <br>
    </body>
    <%
                
                FormTypeCheval form = (FormTypeCheval)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouterUneRace" method="POST">
                <label for="typ_libelle">Libelle de la race : </label>
                <input id="typ_libelle" type="text" name="typ_libelle"  size="30" maxlength="50">
                </br>
                
                <label for="typ_description">Description de la race : </label>
                <input id="typ_description"  type="text"  name="typ_description" size="30" maxlength="255">      
                 </br>
                
            <br>     
            <br> 
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
    </body>    
        
    
</html>


<%@include file="../components/footer.jsp" %>
