<%-- 
    Document   : modifierPays
    Created on : 13 oct. 2021, 09:21:03
    Author     : Donatien
--%>

<%@page import="model.Pays"%>
<%@page import="forms.FormPays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../components/header.jsp" %>
<%@include file="../components/css.jsp" %>


<html>
        <title>Modifier un Pays</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        
    <body>        
        <br>
        <br>
        <br>
        <h1>Modification d'un Pays</h1>
        <br>
    
            <%
                Pays unPays=(Pays)request.getAttribute("pPays");
                FormPays form = (FormPays)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="modifierPays" method="POST">
                <label for="codePays">Code du Pays : </label>
                <input id="codePays" type="text" name="codePays"  size="30" maxlength="30" value='<% out.println(unPays.getCode()); %>'>
                </br>
                
                <label for="nomPays">Nom du Pays : </label>
                <input id="nomPays"  type="text"  name="nomPays" size="30" maxlength="30" value='<% out.println(unPays.getNom()); %>'>      
                 </br>
                
                <br>     
                <br> 
                <input type="submit" name="valider" id="valider" value="Valider"/>
        </form>
    </body>    
        <%@include file="../components/footer.jsp" %>

    
</html>

