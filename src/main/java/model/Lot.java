/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Matteo
 */
public class Lot {
    private int id;
    private int prixDepart;
    private Cheval leCheval;
    private Vente laVente;
    private ArrayList<Enchere> lesEncheres;
            
            
    public  Lot(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(int prixDepart) {
        this.prixDepart = prixDepart;
    }
    
    public Cheval getLeCheval(){
        return leCheval;
    }
    
    public void setLeCheval(Cheval pLeCheval){
        this.leCheval = pLeCheval;
    }
    
    public Vente getLaVente(){
        return laVente;
    }
    
    public void setLaVente(Vente pLaVente){
        this.laVente = pLaVente;
    }
    
     public ArrayList<Enchere> getLesEncheres() {
        return lesEncheres;
    }
    
     public void setLesEncheres(ArrayList<Enchere> lesEncheres) {
        this.lesEncheres = lesEncheres;
    }
    
    public void addUneEnchere(Enchere Enchere){
        if (lesEncheres == null){
            lesEncheres = new ArrayList<Enchere>();
        }
        lesEncheres.add(Enchere);
    }
    
}
