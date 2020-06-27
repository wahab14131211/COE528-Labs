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
public class Manager {
    private Flight[] Flights;
    private Ticket[] Tickets;
    
    public Manager(){
        this.Flights = new Flight[5];
        this.Tickets = new Ticket[100];
    }
    
    public void createFlights(){
        Flights[0] = new Flight(1000,"Toronto","Vancouver","06/30/2020 7:50 pm", 10,6590.32);
        Flights[1] = new Flight(1001,"Vancouver","Toronto","07/10/2020 8:10 pm", 16,5268.70);
        Flights[2] = new Flight(1002,"Toronto","Calgary","07/11/2020 6:20 pm", 7 ,4523.65);
        Flights[3] = new Flight(1003,"Calgary","Toronto","07/12/2020 1:20 am", 17 ,3571.14);
        Flights[4] = new Flight(1004,"Calgary","Vancouver","07/16/2020 4:20 am", 13 ,2516.5);
    }
    
    public void displayAvalibleFlights(String origin, String destination){
        System.out.println(String.format("Here are the Avalible Flights from %s to %s:", origin, destination));
        for (Flight Flight : Flights) {
            if (Flight.getOrigin().equals(origin) && Flight.getDestination().equals(destination) && Flight.getNumberOfSeatsLeft() > 0){
                System.out.println(Flight);
            }
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
        Flight Flight = this.getFlight(flightNumber);
        if (Flight == null){
            return;
        }
        if (Flight.bookASeat()){
            for(int i=0; i<Tickets.length;i++){
                if(Tickets[i] == null){
                    Tickets[i] = new Ticket(p,Flight,p.applyDiscount(Flight.getOriginalPrice()));
                }
            }
            return; //Tickets Array is full
        }
    }
    
}
