
 <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
   <div class="container">
     <a class="navbar-brand" href="http://localhost:8080/equida/">Equida<span>Chevaux</span></a>
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
       <span class="oi oi-menu"></span> Menu
   </button>
<%-- 
    Document   : header
    Created on : 6 oct. 2021, 10:31:11
    Author     : adminsio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

   <div class="collapse navbar-collapse" id="ftco-nav">
       <ul class="navbar-nav ml-auto">
         <li class="nav-item"><a href="http://localhost:8080/equida" class="nav-link">Accueil</a></li>
         
         
      <% Integer connected = (Integer) session.getAttribute("connected");
        System.out.println(connected);
        if (connected != null && connected == 1) {
            Integer idSession = (Integer)session.getAttribute("idSession");
      
      %>
        <li class="nav-item"><a href="http://localhost:8080/equida/ServletClient/listerLesCourses" class="nav-link">Courses</a></li>
        <li class="nav-item"><a href="http://localhost:8080/equida/ServletVente/listerLesVentes" class="nav-link">Ventes</a></li>
        <li class="nav-item"><a href="http://localhost:8080/equida/ServletCheval/listerLesChevaux" class="nav-link">Liste Chevaux</a></li>
        <% out.print("<li class='nav-item'><a href='http://localhost:8080/equida/ServletClient/consulterProfil?idClient="+idSession+"' class='nav-link'>Profil</a></li>"); %>
        
        
        
         <li class="nav-item"><a href="ServletConnexion/deconnexion" class="nav-link">D�connexion</a></li>
        
      <% } else { %>
         <li class="nav-item"><a href="#" class="nav-link">A propos de nous</a></li>
         <li class="nav-item"><a href="http://localhost:8080/equida/ServletConnexion/afficherLoginForm" class="nav-link">Connexion</a></li>
         <li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
      <% } %>

 
         
     </ul>
 </div>
</div>
</nav>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="http://localhost:8080/equida/">Equida<span>Chevaux</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="#" class="nav-link">Accueil</a></li>
                <li class="nav-item"><a href="#" class="nav-link">A propos de nous</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Connexion</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>
