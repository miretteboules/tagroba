package busstation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author omar_
 */
public class trips {
    String tripCode;
    String depart;
    String destination;
    String date;
    String vehicle;
    String time;
    int way;
    int stops;
    int seats;
    int availableSeats;
    int price;
    public trips(String tripCode,String depart,String destination, String date,String vehicle,String time,String way,String stops,String seats,String availableSeats,String price)
    {
        this.tripCode=tripCode;
        this.depart=depart ;       
        this.destination=destination;
        this.date=date;
        this.vehicle=vehicle;
        this.time=time;
        this.way=Integer.parseInt(way);
        this.stops=Integer.parseInt(stops);
        this.seats=Integer.parseInt(seats);
        this.availableSeats=Integer.parseInt(availableSeats);  
         this.price=Integer.parseInt(price);
    }
    public trips()
    {
    }
    
}
