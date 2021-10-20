 <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
   <div class="container">
     <a class="navbar-brand" href="http://localhost:8080/equida/">Equida<span>Chevaux</span></a>
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
       <span class="oi oi-menu"></span> Menu
   </button>

   <div class="collapse navbar-collapse" id="ftco-nav">
       <ul class="navbar-nav ml-auto">
         <li class="nav-item"><a href="#" class="nav-link">Accueil</a></li>
         
         
      <% Integer connected = (Integer) session.getAttribute("connected");
        System.out.println(connected);
        if (connected != null && connected == 1) {
            
      
      %>
        <li class="nav-item"><a href="http://localhost:8080/equida/ServletConnexion/afficherLoginForm" class="nav-link">Courses</a></li>
        <li class="nav-item active"><a href="http://localhost:8080/equida/ServletVente/listerLesVentes" class="nav-link">Ventes</a></li>
         <li class="nav-item"><a href="ServletConnexion/deconnexion" class="nav-link">Déconnexion</a></li>
        
      <% } else { %>
         <li class="nav-item"><a href="#" class="nav-link">A propos de nous</a></li>
         <li class="nav-item"><a href="http://localhost:8080/equida/ServletConnexion/afficherLoginForm" class="nav-link">Connexion</a></li>
         <li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
      <% } %>

 
         
     </ul>
 </div>
</div>
</nav>