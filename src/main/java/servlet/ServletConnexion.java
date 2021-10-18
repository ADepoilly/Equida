/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Database.CategVenteDAO;
import Database.ClientDAO;
import Database.CompteDAO;
import Database.PaysDAO;
import forms.FormClient;
import forms.FormCompte;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategVente;
import model.Client;
import model.Compte;
import model.Pays;

/**
 *
 * @author adminsio
 */
public class ServletConnexion extends HttpServlet {
    Connection connection ;
      
        
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        connection=(Connection)servletContext.getAttribute("connection");
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletConnexion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletConnexion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        String url = request.getRequestURI();  

            // Récup et affichage des clients interessés par une certaine catégorie de ventes
            if(url.equals("/equida/ServletConnexion/afficherLoginForm"))
            {  
                getServletContext().getRequestDispatcher("/vues/connexion/connexion.jsp").forward(request, response);
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FormCompte form = new FormCompte();
		 
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Compte unCompte = form.testerConnexion(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );

            Compte compteTeste =  CompteDAO.getCompte(connection, unCompte);
            
            System.out.println(compteTeste.getMdp());
            
            if (compteTeste.getLogin() != null){
                
                
                
                        HttpSession session = request.getSession();

                        session.setAttribute("client", compteTeste.getLeClient());
                        session.setAttribute("compte", compteTeste);
                        session.setAttribute("connected", 1);
                
                
                
                
               response.sendRedirect("http://localhost:8080/equida/");
                

            }
            else 
            {
                this.getServletContext().getRequestDispatcher("/vues/connexion/connexion.jsp" ).forward( request, response );
            }

        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
