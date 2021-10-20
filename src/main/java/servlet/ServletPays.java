/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Database.PaysDAO;
import forms.FormPays;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pays;


/**
 *
 * @author adminsio
 */
@WebServlet(name = "ServletPays", urlPatterns = {"/ServletPays"})
public class ServletPays extends HttpServlet {
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
            out.println("<title>Servlet ServletPays</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPays at " + request.getContextPath() + "</h1>");
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
        
        
        if(url.equals("/equida/ServletPays/listerLesPays"))
        {   
            ArrayList<Pays> lesPays = PaysDAO.getLesPays(connection);
            request.setAttribute("pListePays", lesPays);
            getServletContext().getRequestDispatcher("/vues/pays/listerLesPays.jsp").forward(request, response);
        }
        
        if(url.equals("/equida/ServletPays/ajouterPays"))
        {  
            ArrayList<Pays> lesPays = PaysDAO.getLesPays(connection);
            request.setAttribute("pLesPays", lesPays);
            getServletContext().getRequestDispatcher("/vues/pays/ajouterPays2.jsp").forward(request, response);
      
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
        
        FormPays form = new FormPays();
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Pays unPays = form.ajouterPays(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "pPays", unPays );
		
        if (form.getErreurs().isEmpty()){
            // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du Pays 
            Pays PaysInsere =  PaysDAO.ajouterPays(connection, unPays);
            if (PaysInsere != null ){
                ArrayList<Pays> lesPays = PaysDAO.getLesPays(connection);
                request.setAttribute("pListePays", lesPays);
                this.getServletContext().getRequestDispatcher("/vues/pays/listerLesPays.jsp").forward( request, response );
            }
            else 
            {
                // Cas oùl'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
            }
        }
    }
     
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
