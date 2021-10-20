/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Database.ChevalDAO;
import Database.PaysDAO;
import forms.FormCheval;
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
import model.Cheval;
import model.Pays;
import model.TypeCheval;

/**
 *
 * @author floro
 */
@WebServlet(name = "ServletCheval", urlPatterns = {"/ServletCheval"})
public class ServletCheval extends HttpServlet {

    
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
            out.println("<title>Servlet ServletCheval</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCheval at " + request.getContextPath() + "</h1>");
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
        if(url.equals("/equida/ServletCheval/ajouterCheval"))
        {  
                
            ArrayList<Cheval> lesChevauxMere = ChevalDAO.getLesChevauxDeTypeFeminin(connection);
            ArrayList<Cheval> lesChevauxPere = ChevalDAO.getLesChevauxDeTypeMasculin(connection);
            
            ArrayList<TypeCheval> lesTypesCheval = ChevalDAO.getLesTypesChevaux(connection);
            
            
            request.setAttribute("pLesChevauxMales", lesChevauxPere);
            request.setAttribute("pLesChevauxFemelles", lesChevauxMere);
            request.setAttribute("pLesTypeCheval", lesTypesCheval);
            getServletContext().getRequestDispatcher("/vues/client/ajouterCheval.jsp").forward(request, response);
        }

        if(url.equals("/equida/ServletCheval/listerLesChevaux"))
        {  
                
            ArrayList<Cheval> lesChevaux = ChevalDAO.getLesChevaux(connection);
            
            request.setAttribute("pLesChevaux", lesChevaux);
            getServletContext().getRequestDispatcher("/vues/client/listerLesChevaux.jsp").forward(request, response);
        }        
        
        if(url.equals("/equida/ServletCheval/voirCheval"))
        {  
            String chevalID = (String)request.getParameter("chevalID");
            
            Cheval unCheval = ChevalDAO.getUnCheval(connection, chevalID);
            System.out.println(chevalID);
            request.setAttribute("pLeCheval", unCheval);
            getServletContext().getRequestDispatcher("/vues/client/voirCheval.jsp").forward(request, response);
        }   
        
        if(url.equals("/equida/ServletCheval/modifierCheval"))
        {  
            String chevalID = (String)request.getParameter("idCheval");
            
            System.out.println("ID CHEVAL : " +chevalID);
            
            Cheval unCheval = ChevalDAO.getUnCheval(connection, chevalID);
            System.out.println("ID CHEVAL : " +chevalID);
            
            ArrayList<Cheval> lesChevauxMere = ChevalDAO.getLesChevauxDeTypeFeminin(connection);
            ArrayList<Cheval> lesChevauxPere = ChevalDAO.getLesChevauxDeTypeMasculin(connection);
            
            ArrayList<TypeCheval> lesTypesCheval = ChevalDAO.getLesTypesChevaux(connection);
            
            
            request.setAttribute("pLesChevauxMales", lesChevauxPere);
            request.setAttribute("pLesChevauxFemelles", lesChevauxMere);
            request.setAttribute("pLesTypeCheval", lesTypesCheval);
            

            
            request.setAttribute("pLeCheval", unCheval);
            System.out.println("Servlet Cheval ; "+unCheval.getNom());
            getServletContext().getRequestDispatcher("/vues/client/modifierCheval.jsp").forward(request, response);
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
        String url = request.getRequestURI();  
        
        if(url == "/equida/ServletCheval/ajouterCheval"){
            FormCheval form = new FormCheval();
            /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
            Cheval unCheval = form.ajouterCheval(request);

            /* Stockage du formulaire et de l'objet dans l'objet request */
            request.setAttribute( "form", form );
            request.setAttribute( "pCheval", unCheval );

            if (form.getErreurs().isEmpty()){
                // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du Pays 
                Cheval ChevalInsere =  ChevalDAO.ajouterCheval(connection, unCheval);
                if (ChevalInsere != null ){
                    response.sendRedirect("http://localhost:8080/equida/ServletCheval/listerLesChevaux");
                }
                else 
                {
                    // Cas oùl'insertion en bdd a échoué
                    //renvoyer vers une page d'erreur 
                }
            }            
        }

        if(url == "/equida/ServletCheval/modifierCheval"){
            FormCheval form = new FormCheval();
            /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
            Cheval unCheval = form.ajouterCheval(request);

            /* Stockage du formulaire et de l'objet dans l'objet request */
            request.setAttribute( "form", form );
            request.setAttribute( "pCheval", unCheval );

            if (form.getErreurs().isEmpty()){
                // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du Pays 
                Cheval ChevalInsere =  ChevalDAO.ajouterCheval(connection, unCheval);
                if (ChevalInsere != null ){
                    response.sendRedirect("http://localhost:8080/equida/ServletCheval/listerLesChevaux");
                }
                else 
                {
                    // Cas oùl'insertion en bdd a échoué
                    //renvoyer vers une page d'erreur 
                }
            }            
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
