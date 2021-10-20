<%-- 
    Document   : ajouterPays
    Created on : 13 oct. 2021, 09:21:03
    Author     : Donatien
--%>

>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
    <head>
        <title>AjouterUnPays</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@include file="../components/css.jsp" %>
    </head>
        
    <body>        
        <%@include file="../components/header.jsp" %>
        
        
        <section class="hero-wrap hero-wrap-2" style="height: 10vh; background-image: url('https://picardie.media.tourinsoft.eu/upload/Hippodrome-Chantilly--1-.jpg');">

</section>

<section>
        <p class="h1 text-center mt-5">Ajouter un pays</p>
        
        
    <%
                //Pays Pays=(Pays)request.getAttribute("Pays");
                
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



