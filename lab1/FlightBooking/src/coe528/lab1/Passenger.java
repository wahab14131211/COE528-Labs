/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author wahab
 */
public abstract class Passenger {
    String name;
    int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //<editor-fold desc="Implement getter functions" defaultstate="collapsed">
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    //</editor-fold>
    
    //<editor-fold desc="Implement setter functions" defaultstate="collapsed">
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //</editor-fold>
    
    public abstract double applyDiscount(double p);
    
}
