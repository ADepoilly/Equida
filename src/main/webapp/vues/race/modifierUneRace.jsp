<%-- 
    Document   : modifierUneRace
    Created on : 20 oct. 2021, 08:37:23
    Author     : adminsio
--%>

<%@page import="model.TypeCheval"%>
<%@page import="forms.FormTypeCheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../components/header.jsp" %>
<%@include file="../components/css.jsp" %>


<html>
        <title>Modifier une Race</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        
    <body>        
        <br>
        <br>
        <br>
        <h1>Modification d'une Race</h1>
        <br>
    
            <%
                TypeCheval unTypeCheval=(TypeCheval)request.getAttribute("pListeTypeCheval");
                FormTypeCheval form = (FormTypeCheval)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="modifierUneRace" method="POST">
                <label for="typ_libelle">Libelle de la race : </label>
                <input id="typ_libelle" type="text" name="typ_libelle"  size="30" maxlength="30" value='<% out.println(unTypeCheval.getLibelle()); %>'>
                </br>
                
                <label for="typ_description">Description de la race : </label>
                <input id="typ_description"  type="text"  name="typ_description" size="30" maxlength="30" value='<% out.println(unTypeCheval.getDescription()); %>'>      
                 </br>
                
                <br>     
                <br> 
                <input type="submit" name="valider" id="valider" value="Valider"/>
        </form>
    </body>    
        <%@include file="../components/footer.jsp" %>

    
</html>

