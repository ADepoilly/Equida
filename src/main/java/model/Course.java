/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


/**
 *
 * @author Antonin
 */
public class Course {
    
    private int id;
    private String nom;
    private String lieu;
    private String date;
    private ArrayList<Participer> lesParticipations;
    
    public Course(){
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Participer> getLesParticipations() {
        return lesParticipations;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLesParticipations(ArrayList<Participer> lesParticipations) {
        this.lesParticipations = lesParticipations;
    }
    
    public void addLesParticipations(Participer pUneParticipation){
        if (lesParticipations == null){
            lesParticipations = new ArrayList<Participer>();
        }
        lesParticipations.add(pUneParticipation);
    }
    
}
