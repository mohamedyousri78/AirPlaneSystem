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
public class FlightDescriptions {
    //Declaring instances variables
    private int ID;
    private int FlightDuration;
    private int Capicaty;
    private String FromAirport;
    private String ToAirport;
   
    //constructor signature
    public FlightDescriptions( int FlightDuration, int Capicaty , String FromAirport, String ToAirport , int ID){
        
        
        setFlightDuration(FlightDuration);
        setCapicaty(Capicaty);
        setFromAirport(FromAirport);
        setToAirport(ToAirport);
        setID(ID);
        
    }
    
    //Declaring Setter for each vaiable
    protected void setFlightDuration(int FlightDuration){this.FlightDuration = FlightDuration;}
    protected void setCapicaty(int Capicaty){this.Capicaty = Capicaty;}
    protected void setFromAirport(String FromAirport){this.FromAirport = FromAirport;}
    protected void setToAirport(String ToAirport){this.ToAirport = ToAirport;}
    protected void setID(int ID){this.ID = ID;}
    //Declaring Getter for each vaiable
    protected int getFlightDuration(){return FlightDuration;}
    protected int getCapicaty(){return Capicaty;}
    protected String getFromAirport(){return FromAirport;}
    protected String getToAirport(){return ToAirport;} 
    protected int getID(){return ID;}
    @Override
    public String toString(){
        return String.format("Flight Description ID: %d\nFlight Duration: %d Hours,\t"
                + "Flight capicaty: %d\n"
                + "From: %s Airport\n"
                + "To: %s Airport\n",ID,FlightDuration
                , Capicaty ,FromAirport, ToAirport
                );
    }
}
