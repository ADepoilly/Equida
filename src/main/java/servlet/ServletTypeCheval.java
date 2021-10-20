/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Database.TypeChevalDAO;
import forms.FormTypeCheval;
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
import model.TypeCheval;


/**
 *
 * @author adminsio
 */
@WebServlet(name = "ServletTypeCheval", urlPatterns = {"/ServletTypeCheval"})
public class ServletTypeCheval extends HttpServlet {
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
            out.println("<title>Servlet ServletTypeCheval</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletTypeCheval at " + request.getContextPath() + "</h1>");
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
        System.out.println(url);
        
        
        if(url.equals("/equida/ServletTypeCheval/listerLesRaces"))
        {   
            ArrayList<TypeCheval> lesTypesChevaux = TypeChevalDAO.getLesTypesChevaux(connection);
            request.setAttribute("pListeTypeCheval", lesTypesChevaux);
            getServletContext().getRequestDispatcher("/vues/race/listerLesRaces.jsp").forward(request, response);
        }
        
        if(url.equals("/equida/ServletTypeCheval/ajouterUneRace"))
        {  
            ArrayList<TypeCheval> lesTypesChevaux = TypeChevalDAO.getLesTypesChevaux(connection);
            request.setAttribute("pLesTypesChevaux", lesTypesChevaux);
            getServletContext().getRequestDispatcher("/vues/race/ajouterUneRace.jsp").forward(request, response);
        }
        
        if(url.equals("/equida/ServletTypeCheval/modifierUneRace"))
        { 
            
            Integer typ_id = Integer.parseInt((String)request.getParameter("typ_id"));
            
           
            
            TypeCheval unTypeCheval = TypeChevalDAO.getUnTypeCheval(connection,typ_id);
            request.setAttribute("pListeTypeCheval", unTypeCheval);
            this.getServletContext().getRequestDispatcher("/vues/race/modifierUneRace.jsp").forward(request, response);
      
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
        
        FormTypeCheval form = new FormTypeCheval();
        String url = request.getRequestURI();           
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        TypeCheval unTypeCheval= null; 
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "pUnTypeCheval", unTypeCheval );

        if (form.getErreurs().isEmpty()){
            if(url.equals("/equida/ServletTypeCheval/ajouterUneRace"))
                {                   
                TypeCheval unTypeChevalAjout =  form.ajouterUnTypeCheval(request);
                unTypeCheval =  TypeChevalDAO.ajouterUnTypeCheval(connection, unTypeChevalAjout);

                }
            
            if(url.equals("/equida/ServletTypeCheval/modifierUneRace"))
                {
                TypeCheval unTypeChevalModifie =  form.modifierUneRace(request);
                unTypeCheval =  TypeChevalDAO.modifierUneRace(connection, unTypeChevalModifie);
                
 
                }
          
            
            if (unTypeCheval != null ){
                ArrayList<TypeCheval> TypeChevalSelect = TypeChevalDAO.getLesTypesChevaux(connection);
                request.setAttribute("pListeTypeCheval", TypeChevalSelect);
                this.getServletContext().getRequestDispatcher("/vues/race/listerLesRaces.jsp" ).forward( request, response );
                }
            else 
                {
                // Cas oùl'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
                }      
                  
        }
        
        else       
        
            if(url.equals("/equida/ServletTypeCheval/ajouterUneRace"))
                { 
		ArrayList<TypeCheval> LesTypesChevaux = TypeChevalDAO.getLesTypesChevaux(connection);
                request.setAttribute("pLesTypesChevaux", LesTypesChevaux);
                this.getServletContext().getRequestDispatcher("/vues/race/listerLesRaces.jsp" ).forward( request, response );
                }
            
            else if(url.equals("/equida/ServletTypeCheval/modifierUneRace"))
                {
                ArrayList<TypeCheval> LesTypesChevaux = TypeChevalDAO.getLesTypesChevaux(connection);
                request.setAttribute("pLesTypesChevaux", LesTypesChevaux);
                this.getServletContext().getRequestDispatcher("/vues/race/listerLesRaces.jsp" ).forward( request, response );
                }
        
    }
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
