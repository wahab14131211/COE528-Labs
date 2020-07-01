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
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int ID;
    private static int totalTickets = 0;

    /**
     *
     * @param p
     * @param f
     * @param price
     */
    public Ticket(Passenger p, Flight f, double price){
        this.passenger = p;
        this.flight = f;
        this.price = price;
        this.ID = ++Ticket.totalTickets;
    }

    //<editor-fold desc="Implement getter functions" defaultstate="collapsed">
    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public double getPrice() {
        return price;
    }

    public int getID() {
        return ID;
    }
    //</editor-fold>

    //<editor-fold desc="Implement setter functions" defaultstate="collapsed">
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("%s, Flight %d, %s to %s, %s, original price: $%.2f, ticket price: $%.2f",this.passenger.getName() , this.flight.getFlightNumber(), this.flight.getOrigin(), this.flight.getDestination(), this.flight.getDepartureTime(), this.flight.getOriginalPrice(), this.price); 
    }
}
