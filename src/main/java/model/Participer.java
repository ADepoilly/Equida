/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Antonin
 */
public class Participer {
    
    private int id;
    private Cheval cheval;
    private Course course;
    private int place;
    
    public Participer(){
        
    }

    public int getId() {
        return id;
    }

    public Cheval getCheval() {
        return cheval;
    }

    public Course getCourse() {
        return course;
    }

    public int getPlace() {
        return place;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCheval(Cheval cheval) {
        this.cheval = cheval;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setPlace(int place) {
        this.place = place;
    }
    
   
}
