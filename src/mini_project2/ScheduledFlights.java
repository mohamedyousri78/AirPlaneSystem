/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_project2;

/**
 *
 * @author Mohamed
 */
public class ScheduledFlights {
    //Declaring instances variables
    private FlightDescriptions Flight;
    private Time Depature;
    private Time Arrival;
    private int FlightID;
    
     //constructor signature
    public ScheduledFlights(FlightDescriptions Flight,Time Depature,Time Arrival, int FlightID){
        setFlight(Flight);
        setDepature(Depature);
        setArrival(Arrival);
        setFlightID(FlightID);
    }
    //Declaring Setter for each vaiable
    protected void setFlight(FlightDescriptions Flight ){this.Flight = Flight;}
    protected void setDepature(Time Depature){this.Depature = Depature;}
    protected void setArrival(Time Arrival){this.Arrival = Arrival;}
    protected void setFlightID(int FlightID){this.FlightID=FlightID;}
    
//Declaring Getter for each vaiable
    protected FlightDescriptions getFlight(){return Flight;}
    protected Time getArrival(){return Arrival;}
    protected Time getDepature(){return Depature;}
    protected int getFlightID(){return FlightID;}
    
    @Override
    public String toString(){
        
        return String.format("Flight ID: %d\n"
                +Flight.toString()
                +"Depature Time: %s"
                +"Arrival Time : %s",FlightID,Depature.toString(),Arrival.toString());
    }
}
