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


//extending the person class to passenger class
public class Passenger  {
    //Declaring instances variables
    private Person Info;
    private int PassengerID;
    private int FlightID;
    
    //constructor signature
    public Passenger(Person Info ,int PassengerID, int FlightID){
        setInfo(Info);
        setPassengerID( PassengerID);
        setFlightID(FlightID);
    }
    
    //Declaring Setter for each vaiable
    protected void setInfo(Person Info){this.Info=Info;}
    protected void setPassengerID(int PassengerID){this.PassengerID = PassengerID;}
    protected void setFlightID(int FlightID){this.FlightID = FlightID;}
    
    //Declaring Getter for each vaiable
    protected Person getInfo(){return Info;}
    protected int getPassengerID(){return PassengerID;}
    protected int getFlightID(){return FlightID;}
    
    @Override
    public String toString(){
        return String.format(   
         "Passenger ID: %d\t\t"
        +"Flight ID: %d\n"
        +Info.toStringPassenger()
        ,PassengerID   ,FlightID);
    }
}
