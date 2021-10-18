package Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adminsio
 */



import static Database.ClientDAO.requete;
import static Database.ClientDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Client;
import model.Compte;



public class CompteDAO {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    
        public static Compte getCompte(Connection connection, Compte unCompte){
        Compte compte = new Compte();
        try
        {
            
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT * FROM compte INNER JOIN client ON com_cli = cli_id WHERE com_login = ? AND com_mdp = ?");
            requete.setString(1, unCompte.getLogin());
            requete.setString(2, unCompte.getMdp());
            
            System.out.println(requete);
            
            
            //executer la requete
            rs=requete.executeQuery();
            

             
            //On hydrate l'objet métier Client avec les résultats de la requête
            if ( rs.next() ) {  
                
                
                compte.setId(rs.getInt("com_id"));
                compte.setLogin(rs.getString("com_login"));
                compte.setMdp(rs.getString("com_mdp"));
                
                Client unClient = new Client();
                unClient.setId(rs.getInt("cli_id"));
                unClient.setNom(rs.getString("cli_nom"));
                unClient.setPrenom(rs.getString("cli_prenom"));
                unClient.setVille(rs.getString("cli_ville"));
                unClient.setCodePostal(rs.getString("cli_copos"));
                unClient.setAdresseMessagerie(rs.getString("cli_adresseMessagerie"));
                
                
                compte.setLeClient(unClient);
            }
            
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return compte;    
    } 
    
    
    
}
