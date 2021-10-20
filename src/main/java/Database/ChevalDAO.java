/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.ClientDAO.requete;
import static Database.ClientDAO.rs;
import static Database.TypeChevalDAO.requete;
import static Database.TypeChevalDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CategVente;
import model.Cheval;
import model.Client;
import model.Pays;
import model.TypeCheval;

/**
 *
 * @author floro
 */
public class ChevalDAO {
        Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    /* @author Zakina - 25/08/2021
    /* Méthode permettant de lister les clients interessés par la catégorie de la vente selectionnée (passée en paramètre de la méthode)
    /* Pour chaque client, on récupère aussi le nom de son pays
    /* La liste des clients est stockée dans une ArrayList
    */
public static ArrayList<Cheval>  getLesChevauxDeTypeMasculin(Connection connection){      
        ArrayList<Cheval> lesChevaux = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT * FROM CHEVAL, TYPECHEVAL WHERE CHE_TYP = TYP_ID AND CHE_SEXE = ?");
            requete.setString(1, "M");

            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("CHE_ID"));
                unCheval.setNom(rs.getString("CHE_NOM"));
                unCheval.setSexe(rs.getString("CHE_SEXE"));
                unCheval.setSire(rs.getString("CHE_SIRE"));
                unCheval.setDateNaissance(rs.getString("CHE_DATENAISSANCE"));
                
                TypeCheval unType = new TypeCheval();
                unType.setLibelle(rs.getString("TYP_LIBELLE"));
                unType.setDescription(rs.getString("TYP_DESCRIPTION"));
                unCheval.setLeTypeCheval(unType);
                
                
                
                lesChevaux.add(unCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesChevaux;    
    } 


public static ArrayList<Cheval>  getLesChevauxDeTypeFeminin(Connection connection){      
        ArrayList<Cheval> lesChevaux = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT * FROM CHEVAL, TYPECHEVAL WHERE CHE_TYP = TYP_ID AND CHE_SEXE = ?");
            requete.setString(1, "F");

            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("CHE_ID"));
                unCheval.setNom(rs.getString("CHE_NOM"));
                unCheval.setSexe(rs.getString("CHE_SEXE"));
                unCheval.setSire(rs.getString("CHE_SIRE"));
                unCheval.setDateNaissance(rs.getString("CHE_DATENAISSANCE"));
                
                TypeCheval unType = new TypeCheval();
                unType.setLibelle(rs.getString("TYP_LIBELLE"));
                unType.setDescription(rs.getString("TYP_DESCRIPTION"));
                unCheval.setLeTypeCheval(unType);
                
                
                
                lesChevaux.add(unCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesChevaux;    
    } 




public static ArrayList<Cheval>  getLesChevaux(Connection connection){      
        ArrayList<Cheval> lesChevaux = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT * FROM CHEVAL c, CHEVAL chevalp, CHEVAL chevalm, TYPECHEVAL WHERE c.pere = chevalp.CHE_ID AND c.mere = chevalm.CHE_ID AND c.CHE_TYP = TYP_ID;");
            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                Cheval unCheval = new Cheval();
                Cheval unChevalMere = new Cheval();
                Cheval unChevalPere = new Cheval();
                
                
                unCheval.setId(rs.getInt("CHE_ID"));
                unCheval.setNom(rs.getString("CHE_NOM"));
                unCheval.setSexe(rs.getString("CHE_SEXE"));
                unCheval.setSire(rs.getString("CHE_SIRE"));
                unCheval.setDateNaissance(rs.getString("CHE_DATENAISSANCE"));
                
                unChevalMere.setId(rs.getInt("chevalm.CHE_ID"));
                unChevalMere.setNom(rs.getString("chevalm.CHE_NOM"));

                unChevalPere.setId(rs.getInt("chevalp.CHE_ID"));
                unChevalPere.setNom(rs.getString("chevalp.CHE_NOM"));

                
                TypeCheval unType = new TypeCheval();
                unType.setLibelle(rs.getString("TYP_LIBELLE"));
                unType.setDescription(rs.getString("TYP_DESCRIPTION"));
                unCheval.setLeTypeCheval(unType);
                
                unCheval.setPere(unChevalPere);
                unCheval.setMere(unChevalMere);
                
                
                lesChevaux.add(unCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesChevaux;    
    } 
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
     
     
    public static Cheval ajouterCheval(Connection connection, Cheval unCheval){      
        int idGenere = -1;
        Cheval unChevalInsere = new Cheval();
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO CHEVAL (CHE_NOM, CHE_SEXE, CHE_SIRE,CHE_DATENAISSANCE, CHE_TYP, pere, mere)" +
                    "VALUES (?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unCheval.getNom());
            requete.setString(2, unCheval.getSexe());
            requete.setString(3, unCheval.getSire());
            requete.setString(4, unCheval.getDateNaissance());
            requete.setInt(5,unCheval.getLeTypeCheval().getId());
            requete.setInt(6, unCheval.getPere().getId());
            requete.setInt(7, unCheval.getMere().getId());
            
            System.out.println(requete);
            

           /* Exécution de la requête */
            requete.executeUpdate();
            
            rs = requete.getGeneratedKeys();
            if(rs.next()){
                idGenere = rs.getInt( 1 );
                unChevalInsere.setId(idGenere);
            }
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unChevalInsere;    
    }
    
    
    
    
    public static Cheval  getUnCheval(Connection connection, String idCheval){      
        Cheval unCheval = new Cheval();
        try
        {
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT * FROM CHEVAL c, CHEVAL chevalp, CHEVAL chevalm, TYPECHEVAL WHERE c.pere = chevalp.CHE_ID AND c.mere = chevalm.CHE_ID AND c.CHE_TYP = TYP_ID AND c.CHE_ID = ?;");
            //executer la requete
            requete.setString(1, idCheval);
            System.out.println(requete);
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                
                Cheval unChevalMere = new Cheval();
                Cheval unChevalPere = new Cheval();
                
                
                unCheval.setId(rs.getInt("CHE_ID"));
                unCheval.setNom(rs.getString("CHE_NOM"));
                unCheval.setSexe(rs.getString("CHE_SEXE"));
                unCheval.setSire(rs.getString("CHE_SIRE"));
                unCheval.setDateNaissance(rs.getString("CHE_DATENAISSANCE"));
                
                unChevalMere.setId(rs.getInt("chevalm.CHE_ID"));
                unChevalMere.setNom(rs.getString("chevalm.CHE_NOM"));

                unChevalPere.setId(rs.getInt("chevalp.CHE_ID"));
                unChevalPere.setNom(rs.getString("chevalp.CHE_NOM"));

                
                TypeCheval unType = new TypeCheval();
                unType.setLibelle(rs.getString("TYP_LIBELLE"));
                unType.setDescription(rs.getString("TYP_DESCRIPTION"));
                unCheval.setLeTypeCheval(unType);
                
                unCheval.setPere(unChevalPere);
                unCheval.setMere(unChevalMere);
                
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval;    
    } 
     
     
     

}
