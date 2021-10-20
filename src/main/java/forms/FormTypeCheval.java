/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.TypeCheval;

/**
 *
 * @author adminsio
 */
public class FormTypeCheval {
    
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
    private void validationLibelle( String typ_libelle ) throws Exception {
        if ( typ_libelle != null && typ_libelle.length() < 3 ) {
        throw new Exception( "Le type de cheval doit contenir au moins 3 caractères." );
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
    
    
    public TypeCheval ajouterUnTypeCheval( HttpServletRequest request ) {
      
        TypeCheval unTypeCheval  = new TypeCheval();
         
        String typ_libelle = getDataForm( request, "typ_libelle" );
        String typ_description = getDataForm( request, "typ_description");
           
        try {
             validationLibelle( typ_libelle );
        } catch ( Exception e ) {
            setErreur( "typ_libelle", e.getMessage() );
        }
        unTypeCheval.setLibelle(typ_libelle); 
       
        
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
      
        unTypeCheval.setLibelle(typ_libelle);
        unTypeCheval.setDescription(typ_description);
                
        return unTypeCheval;
    }
    
    
}
