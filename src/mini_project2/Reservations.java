/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_project2;
import java.util.Date; 
import java.text.SimpleDateFormat;  
/**
 *
 * @author Mohamed
 */

public class Reservations {
    //Declaring instances variables
    private SimpleDateFormat formatter ;
    private ScheduledFlights scheduledFlight;
    private Passenger passenger;
    private Date ReservationDate;
    private int ReservationID;
    //constructor signature
    public Reservations(ScheduledFlights scheduledFlight, Passenger passenger,Date ReservationDate, int ReservationID){
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        setScheduledFlight(scheduledFlight);
        setPassenger(passenger);
        setReservationDate(ReservationDate);
        setReservationID(ReservationID);
    }
    
    //Declaring Setter for each vaiable
    protected void setScheduledFlight(ScheduledFlights scheduledFlight){this.scheduledFlight = scheduledFlight;}
    protected void setPassenger(Passenger passenger){this.passenger = passenger;}
    protected void setReservationDate(Date ReservationDate){this.ReservationDate= ReservationDate;}
    protected void setReservationID(int ReservationID){this.ReservationID= ReservationID;}
    
//Declaring Getter for each vaiable
    protected ScheduledFlights getScheduledFlight(){return scheduledFlight;}
    protected Passenger getPassenger(){return passenger;}
    protected Date getReservationDate(){return ReservationDate;}
    protected int getReservationID(){return ReservationID;}
    
    @Override
    public String toString(){
        return String.format("Reservation ID: %d\n"+scheduledFlight.toString()+passenger.toString()+ ReservationDate,ReservationID);
    }
}
