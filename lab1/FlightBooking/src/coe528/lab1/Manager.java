/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

import java.util.ArrayList;

/**
 *
 * @author wahab
 */
public class Manager {
    private ArrayList<Flight> Flights;
    private ArrayList<Ticket> Tickets;
    
    /**
     *
     */
    public Manager(){
        this.Flights = new ArrayList<>();
        this.Tickets = new ArrayList<>();
    }
    
    public void createFlights(){
        Flights.add(new Flight(1000,"Toronto","Vancouver","06/30/2020 7:50 pm", 2,6590.32));
        Flights.add(new Flight(1001,"Vancouver","Toronto","07/10/2020 8:10 pm", 3,5268.70));
        Flights.add(new Flight(1002,"Toronto","Calgary","07/11/2020 6:20 pm", 2 ,10000));
        Flights.add(new Flight(1003,"Toronto","Calgary","07/12/2020 7:20 pm", 3 ,1000));
//        Flights.add(new Flight(1004,"Calgary","Toronto","07/12/2020 1:20 am", 17 ,3571.14));
//        Flights.add(new Flight(1005,"Calgary","Vancouver","07/16/2020 4:20 am", 13 ,2516.5));
    }
    
    
    public void displayAvalibleFlights(String origin, String destination){
        boolean foundAFlight = false;
        System.out.println(String.format("\nHere are the avalible flights from %s to %s:", origin, destination));
        for (Flight Flight : Flights) {
            if (Flight.getOrigin().equals(origin) && Flight.getDestination().equals(destination) && Flight.getNumberOfSeatsLeft() > 0){
                System.out.println(Flight);
                foundAFlight = true;
            }
        }
        if(!foundAFlight){
            System.out.println(String.format("There are no more avalible flights from %s to %s.", origin, destination));
        }
    }
    
    public Flight getFlight(int flightNumber){
        for(Flight Flight : Flights){
            if(Flight.getFlightNumber() == flightNumber){
                return Flight;
            }
        }
        return null; //if no Flight with that flightNumber was found, return null
    }
    
    public void bookSeat(int flightNumber, Passenger p){
        System.out.println(String.format("\nAttempting to book: %s on Flight %d", p.toString(), flightNumber));
        Flight Flight = this.getFlight(flightNumber);
        if (Flight == null){
            return;
        }
        if (Flight.bookASeat()){
            Tickets.add(new Ticket(p,Flight,p.applyDiscount(Flight.getOriginalPrice())));
        }
    }
    
    public static void main(String args[]){
        Manager manager = new Manager();
        Passenger[] passenger = {new Member("Wahab",22,6),new Member("Ian",24,4),new Member("Jerome",26,0),new Member("Farnaz",27,0),new NonMember("Frank",36), new NonMember("Smith",66)};
        manager.createFlights();
        manager.displayAvalibleFlights("Toronto","Calgary");
        manager.bookSeat(1002, passenger[0]); //will book successfully, discount of 50% will be applied
        System.out.println(String.format("One ticket with a 50%% discount on flight 1002 should have been booked:\n\t%s", manager.Tickets.get(0).toString()));
        manager.bookSeat(1002, passenger[1]); //will book successfully, discount of 10% will be applied
        System.out.println(String.format("One ticket with a 10%% discount on flight 1002 should have been booked:\n\t%s", manager.Tickets.get(1).toString()));
        manager.bookSeat(1002, passenger[2]); //will not book, since flight is full
        System.out.println(String.format("Booking should have failed, since flight is full (there should only be 2 tickets right now).\n\tNumber of booked tickets:%d", manager.Tickets.size()));
        manager.bookSeat(1003, passenger[2]); //will book successfully, no discount will be applied
        System.out.println(String.format("One ticket with no discount on flight 1003 should have been booked:\n\t%s", manager.Tickets.get(2).toString()));
        manager.bookSeat(1003, passenger[4]); //will book successfully, no discount will be applied
        System.out.println(String.format("One ticket with no discount on flight 1003 should have been booked:\n\t%s", manager.Tickets.get(3).toString()));
        manager.bookSeat(1003, passenger[5]); //will book successfully, discount of 10% will be applied
        System.out.println(String.format("One ticket with a 10%% discount on flight 1002 should have been booked:\n\t%s", manager.Tickets.get(4).toString()));
        manager.displayAvalibleFlights("Toronto","Calgary");
        
    }
}
