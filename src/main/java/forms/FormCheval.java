/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Cheval;
import model.Pays;
import model.TypeCheval;

/**
 *
 * @author floro
 */
public class FormCheval {
     private String resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }
    
    //méthode de validation du champ de saisie nom
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
        throw new Exception( "Le nom du Pays doit contenir au moins 3 caractères." );
        }
    }
    
    //méthode de validation du champ de saisie nom
    private void validationCode( String code) throws Exception {
        if ( code != null && code.length() > 4 ) {
        throw new Exception( "Le code du Pays doit contenir au maximum 3 caractères." );
        }
    }

    private void setErreur( String champ, String message ) {
    erreurs.put(champ, message );
    }    
    
    private static String getDataForm( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }   
    }
    
    
    public Cheval ajouterCheval( HttpServletRequest request ) {
      
        Cheval unCheval = new Cheval();
        Cheval unChevalPere = new Cheval();
        Cheval unChevalMere = new Cheval();
        
        TypeCheval unTypeCheval = new TypeCheval();
        
         
        String chevalNom = getDataForm( request, "chevalNom" );
        String chevalSexe = getDataForm( request, "chevalSexe");
        String chevalSire = getDataForm( request, "chevalSire");
        String chevalDateNaissance = getDataForm(request, "chevalDateNaissance");
        String chevalType = getDataForm(request, "chevalType");
        String chevalMere = getDataForm(request, "chevalMere");
        String chevalPere = getDataForm(request, "chevalPere");
        
        
        System.out.println("ID CHeval mère :" +chevalMere);
        System.out.println("ID CHeval père :" +chevalPere);

        

        
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
        unCheval.setNom(chevalNom);
        unCheval.setSexe(chevalSexe);
        unCheval.setSire(chevalSire);
        unCheval.setDateNaissance(chevalDateNaissance);
        unCheval.setLeTypeCheval(unTypeCheval);
        unTypeCheval.setId(Integer.valueOf(chevalType));  
        
        unChevalMere.setId(Integer.valueOf(chevalMere));
        unChevalPere.setId(Integer.valueOf(chevalPere));
        
        
        unCheval.setPere(unChevalPere);
        unCheval.setMere(unChevalMere);
        
        return unCheval;
    }

}
