/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pays;

/**
 *
 * @author Zakina
 */
public class PaysDAO {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<Pays>  getLesPays(Connection connection){      
        ArrayList<Pays> lesPays = new  ArrayList<Pays>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from pays");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Pays avec les résultats de la requête
            while ( rs.next() ) {  
                Pays unPays = new Pays();
                unPays.setCode(rs.getString("pays_code"));
                unPays.setNom(rs.getString("pays_nom"));
                lesPays.add(unPays);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesPays ;    
    } 
     
     
     public static Pays ajouterPays(Connection connection, Pays unPays){      
        try
        {
            requete=connection.prepareStatement("INSERT INTO Pays ( pays_code, pays_nom)\n" +
                    "VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unPays.getCode());
            requete.setString(2, unPays.getNom());                     

           /* Exécution de la requête */
            requete.executeUpdate();           
                     
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unPays ;    
    }
     
     
     
     
     public static Pays modifierPays(Connection connection, Pays unPays){      
       
        try
        {
            requete=connection.prepareStatement("UPDATE Pays SET  pays_nom=? WHERE pays_code=?" );
            
            requete.setString(1, unPays.getNom());
            requete.setString(2, unPays.getCode());
                        

           /* Exécution de la requête */
            requete.executeUpdate();
                        
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unPays ;    
    }
    
     public static Pays getUnPays(Connection connection,String CodePays){      
        Pays unPays = new  Pays();
        try
        {
            //preparation de la requete     
           
            requete=connection.prepareStatement("SELECT pays_code, pays_nom from pays WHERE pays_code=?");
            requete.setString(1, CodePays);
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            if ( rs.next() ) {  

                unPays.setCode(rs.getString("pays_code"));
                unPays.setNom(rs.getString("pays_nom"));
                                
                  
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unPays ;    
    }
     
      
}
