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
public class NonMember extends Passenger{
    
    /**
     *
     * @param name
     * @param age
     */
    public NonMember(String name, int age){
        super(name, age);
    }
    
    @Override
    public double applyDiscount(double p){
        if(this.age > 65){
            return p*0.9;
        }else{
            return p;
        }
    }
    
    @Override
    public String toString(){
        return String.format("NonMember --> Name:%s, Age:%d", this.name, this.age);
    }
}
