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
public class Cheval {
    
    
    private int id;
    private String nom;
    private String sexe;
    private String sire;
    private String dateNaissance;
    private Cheval pere;
    private Cheval mere;
    private TypeCheval leTypeCheval;
    private ArrayList<Lot> lesLots;
    
            
            
           
    public Cheval(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getSire() {
        return sire;
    }

    public void setSire(String sire) {
        this.sire = sire;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Cheval getPere() {
        return pere;
    }

    public void setPere(Cheval pere) {
        this.pere = pere;
    }

    public Cheval getMere() {
        return mere;
    }

    public void setMere(Cheval mere) {
        this.mere = mere;
    }
    
   
    public TypeCheval getLeTypeCheval(){
        return leTypeCheval;
    }
    
    public void setLeTypeCheval(TypeCheval pLeTypeCheval){
        this.leTypeCheval = pLeTypeCheval;
    }

   
    public ArrayList<Lot> getLesLots(){
        return lesLots;
    }
    
    public void setLesLots(ArrayList<Lot> lesLots){
        this.lesLots = lesLots;
    }
    
    public void addUnLot(Lot pUnLot){
        if (lesLots == null){
            lesLots = new ArrayList<Lot>();
        }
        lesLots.add(pUnLot);
    }
   
 
}
