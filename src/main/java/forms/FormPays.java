/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Pays;

/**
 *
 * @author adminsio
 */
public class FormPays {
    
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
    
    
    public Pays ajouterPays( HttpServletRequest request ) {
      
        Pays unPays  = new Pays();
         
        String codePays = getDataForm( request, "codePays" );
        String nomPays = getDataForm( request, "nomPays");
           
        try {
             validationCode( codePays );
        } catch ( Exception e ) {
            setErreur( "code", e.getMessage() );
        }
        unPays.setNom(nomPays); 
       
        try {
             validationNom( nomPays );
        } catch ( Exception e ) {
            setErreur( "nom", e.getMessage() );
        }
        unPays.setNom(nomPays);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
      
        unPays.setCode(codePays);
        unPays.setNom(nomPays);
                
        return unPays;
    }
    
    public Pays modifierPays( HttpServletRequest request ) {
      
        Pays unPays  = new Pays();
         
        String codePays = getDataForm( request, "codePays" );
        String nomPays = getDataForm( request, "nomPays");
           
        try {
             validationCode( codePays );
        } catch ( Exception e ) {
            setErreur( "code", e.getMessage() );
        }
        unPays.setNom(nomPays); 
       
        try {
             validationNom( nomPays );
        } catch ( Exception e ) {
            setErreur( "nom", e.getMessage() );
        }
        unPays.setNom(nomPays);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
      
        unPays.setCode(codePays);
        unPays.setNom(nomPays);
                
        return unPays;
    }
    
    
    
    
}
