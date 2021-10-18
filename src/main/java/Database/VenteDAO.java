/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.ClientDAO.requete;
import static Database.ClientDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CategVente;
import model.Cheval;
import model.Vente;
import model.Courriel;
import model.Lot;
import model.PieceJointe;
import model.TypeCheval;


/**
 *
 * @author Zakina
 */
public class VenteDAO {
    
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    /* @author Zakina - 25/08/2021
    /* Méthode permettant de lister toutes les ventes enregistrées en base, triées par date décroissante.
    /* Pour chaque vente, on récupère aussi sa catégorie.
    /* La liste des vente est stockée dans une ArrayList
    */
    public static ArrayList<Vente>  getLesVentes(Connection connection){    
        
        ArrayList<Vente> lesVentes = new  ArrayList<Vente>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from vente, categvente where categvente.cat_code=vente.ven_codeCategVente order by ven_dateDebut desc");          
            //executer la requete
            rs=requete.executeQuery();
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Vente uneVente = new Vente();
                uneVente.setId(rs.getInt("ven_id"));
                uneVente.setNom(rs.getString("ven_nom"));
                uneVente.setDateDebutVente(rs.getString("ven_dateDebut"));
                
                CategVente laCategVente = new CategVente();
                laCategVente.setCode(rs.getString("cat_code"));  // on aurait aussi pu prendre CodeCateg
                laCategVente.setLibelle(rs.getString("cat_libelle"));
                
                uneVente.setCategVente(laCategVente);
                lesVentes.add(uneVente);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesVentes ;    
    }
    public static ArrayList<Courriel>  getLesCourriels(Connection connection, int idVente){    
        
        ArrayList<Courriel> lesCourriels = new  ArrayList<Courriel>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from courriel,vente where  courriel.cou_venteCourriel=vente.ven_id AND courriel.cou_venteCourriel=?");
            requete.setInt(1, idVente);
            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Courriel unCourriel = new Courriel();
                unCourriel.setId(rs.getInt("cou_id"));
                unCourriel.setCorps(rs.getString("cou_corps"));
                unCourriel.setObjet(rs.getString("cou_objet"));
              
                
                lesCourriels.add(unCourriel);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesCourriels ;    
    }
    public static ArrayList<Lot> getLesLots(Connection connection, int idVente){
        
        ArrayList<Lot> lesLots = new ArrayList<Lot>();
        try
        {
            requete=connection.prepareStatement("Select c.che_id, c.che_sexe, c.che_sire, c.che_dateNaissance, l.lot_id, l.lot_prixDepart, v.ven_id, v.ven_nom, v.ven_dateDebut, t.typ_id, t.typ_libelle, t.typ_description, c.che_nom , p.che_nom , m.che_nom  from cheval c left outer join cheval p on c.pere=p.che_id left outer join cheval m on c.mere=m.che_id inner join lot l on l.che_lot=c.che_id inner join vente v on l.ven_lot=v.ven_id inner join typeCheval t on c.che_Typ=t.typ_id where v.ven_id=?");
            requete.setInt(1, idVente);
            
            
            rs=requete.executeQuery();
             System.out.println(requete);
            while(rs.next()){
                Lot unLot = new Lot();
                unLot.setId(rs.getInt("l.lot_id"));
                unLot.setPrixDepart(rs.getInt("l.lot_prixDepart"));
                
                
                
                TypeCheval unTypeCheval = new TypeCheval();
                unTypeCheval.setId(rs.getInt("t.typ_id"));
                unTypeCheval.setLibelle(rs.getString("t.typ_libelle"));
                unTypeCheval.setDescription(rs.getString("t.typ_description"));
                
                
                 
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt ("c.che_id"));
                unCheval.setNom(rs.getString("c.che_nom"));
                unCheval.setSexe(rs.getString("c.che_sexe"));
                unCheval.setSire(rs.getString("c.che_sire"));
                unCheval.setDateNaissance(rs.getString("c.che_dateNaissance"));
                
                unCheval.setLeTypeCheval(unTypeCheval);
                
                Cheval pereCheval = new Cheval();
                pereCheval.setNom(rs.getString("p.che_nom"));
                
                Cheval mereCheval = new Cheval();
                mereCheval.setNom(rs.getString("m.che_nom"));
                
                
                unCheval.setPere(pereCheval);
                unCheval.setMere(mereCheval);
                unLot.setLeCheval(unCheval);
             
                
                lesLots.add(unLot);
            }
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
       
        return lesLots;
    }
    
    public static ArrayList<PieceJointe>  getLesPiecesJointes(Connection connection, int idCourriel){    
        
        ArrayList<PieceJointe> lesPiecesJointes = new  ArrayList<PieceJointe>();
        try
        {

            //preparation de la requete     
            requete=connection.prepareStatement("select * from courriel,vente,piecejointe, attacher where courriel.cou_venteCourriel=vente.ven_id AND piecejointe.pij_id=attacher.piecejointe_id AND courriel.cou_id=attacher.courriel_id AND courriel.cou_id=?");

            requete.setInt(1, idCourriel);
            //executer la requete
            rs=requete.executeQuery();
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                PieceJointe unePieceJointe = new PieceJointe();
                unePieceJointe.setId(rs.getInt("pij_id"));
                unePieceJointe.setChemin(rs.getString("pij_chemin"));
                unePieceJointe.setDescription(rs.getString("pij_description"));
              
                
                lesPiecesJointes.add(unePieceJointe);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesPiecesJointes ;    
    }
	
}
