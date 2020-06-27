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
public class Flight {
    private int flightNumber, capacity, numberOfSeatsLeft;
    private double originalPrice;
    private String origin, destination, departureTime;
    
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice){
        //TODO: Throw illegal Argument Exception if origin and destination are the same
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.numberOfSeatsLeft = capacity;
        this.originalPrice = originalPrice;
    }
    
    //<editor-fold desc="Implement getter functions" defaultstate="collapsed">
    
    public int getFlightNumber(){
        return this.flightNumber;
    }
    
    public String getOrigin(){
        return this.origin;
    }
    
    public String getDestination(){
        return this.destination;
    }
    
    public String getDepartureTime(){
        return this.departureTime;
    }
    
    public int getCapacity(){
        return this.capacity;
    }
    
    public int getNumberOfSeatsLeft(){
        return this.numberOfSeatsLeft;
    }
    
    public double getOriginalPrice(){
        return this.originalPrice;
    }
    //</editor-fold>
    
    //<editor-fold desc="Implement setter functions" defaultstate="collapsed">
    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }
    
    public void setOrigin(String origin){
        this.origin = origin;
    }
    
    public void setDestination(String destination){
        this.destination = destination;
    }
    
    public void setDepartureTime(String departureTime){
        this.departureTime = departureTime;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft){
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    
    public void setOriginalPrice(double originalPrice){
        this.originalPrice = originalPrice;
    }
    //</editor-fold>
    
    public boolean bootASeat(){
        if(this.numberOfSeatsLeft > 0){
            this.numberOfSeatsLeft--;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return String.format("Flight %d, %s to %s, %s, original price: %f$", this.flightNumber, this.origin, this.destination, this.departureTime, this.originalPrice);
    }
    
}
