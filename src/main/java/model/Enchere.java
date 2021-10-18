/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author adminsio
 */
public class Enchere {
    
    
    private int num;
    private int montant;
    private Client leClient;   
    private Lot leLot;
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Client getLeClient() {
        return leClient;
    }

    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

    public Lot getLeLot() {
        return leLot;
    }

    public void setLeLot(Lot leLot) {
        this.leLot = leLot;
    }

   

    
    
}
