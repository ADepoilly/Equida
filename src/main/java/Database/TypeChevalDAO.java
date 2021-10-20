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
import model.TypeCheval;

/**
 *
 * @author Zakina
 */
public class TypeChevalDAO {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<TypeCheval>  getLesTypesChevaux(Connection connection){      
        ArrayList<TypeCheval> lesTypesChevaux = new  ArrayList<TypeCheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from TypeCheval");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier TypeCheval avec les résultats de la requête
            while ( rs.next() ) {  
                TypeCheval unTypeCheval = new TypeCheval();
                unTypeCheval.setId(rs.getInt("TYP_ID"));
                unTypeCheval.setLibelle(rs.getString("TYP_LIBELLE"));
                unTypeCheval.setDescription(rs.getString("TYP_DESCRIPTION"));
                lesTypesChevaux.add(unTypeCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesTypesChevaux ;    
    } 
     
     
     public static TypeCheval ajouterUnTypeCheval(Connection connection, TypeCheval unTypeCheval){      
        try
        {
            requete=connection.prepareStatement("INSERT INTO TypeCheval (TYP_ID, TYP_LIBELLE, TYP_DESCRIPTION)\n" +
                    "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unTypeCheval.getId());
            requete.setString(2, unTypeCheval.getLibelle());
            requete.setString(3, unTypeCheval.getDescription());                     

           /* Exécution de la requête */
            requete.executeUpdate();           
                     
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unTypeCheval ;    
    }
}
