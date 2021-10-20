<%-- 
    Document   : ajouterPays
    Created on : 13 oct. 2021, 09:21:03
    Author     : Donatien
--%>

<%@page import="forms.FormPays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../components/header.jsp" %>
<%@include file="../components/css.jsp" %>


<html>
        <title>AjouterUnPays</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        
    <body>        
        <br>
        <br>
        <br>
        <h1>Ajout d'un nouveau Pays</h1>
        <br>
    </body>
    <%
                //Pays Pays=(Pays)request.getAttribute("Pays");
                FormPays form = (FormPays)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouterPays" method="POST">
                <label for="codePays">Code du Pays : </label>
                <input id="codePays" type="text" name="codePays"  size="30" maxlength="30">
                </br>
                
                <label for="nomPays">Nom du Pays : </label>
                <input id="nomPays"  type="text"  name="nomPays" size="30" maxlength="30">      
                 </br>
                
            <br>     
            <br> 
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
    </body>    
        
    
</html>


<%@include file="../components/footer.jsp" %>
