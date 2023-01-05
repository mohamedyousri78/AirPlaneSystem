/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_project2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Mohamed
 */
public class Display {
    
    public void yalaDisplay(){
    //Creating initial arrayLists with dummy data 
        CreatingData dummyData = new CreatingData();
        ArrayList<Airports> airports = dummyData.CreateAirportsData();        
        ArrayList<Time> someTimes = dummyData.CreateTimes();
        ArrayList<FlightDescriptions> flightDescriptionArray = dummyData.CreateFlightDescription(airports, someTimes);
       // for(FlightDescriptions flight : flightDescriptionArray) System.out.println(flight);
        ArrayList<ScheduledFlights> DatedFlights = dummyData.CreateScheduledFlights(flightDescriptionArray, someTimes);
        ArrayList<Person> persons = dummyData.CreatingPersons();
        ArrayList<Passenger> passengers = dummyData.CreatingPassengers(persons);
        ArrayList<Reservations> reservations = dummyData.CreateReservations(passengers, DatedFlights);
        //for(Reservations x : reservations) System.out.println(x);
        int globalFlightID = 120;
        int globalRemovedReservations = 0;

        //creating object to get input with
        Scanner input = new Scanner(System.in);
        Functions joker = new Functions();
        int EnteranceValue = 10;
        int exitCode = 1039;
        int year,month,day,hour,minute;
        
        System.out.println("Welcome message");
        while(EnteranceValue != exitCode){
            EnteranceValue = joker.DisplayMenu();
            if(EnteranceValue == 1){
                System.out.println("*************List of Airports*************");
                for(Airports x : airports){
                    System.out.println(x);
                    System.out.println("#####################################################################################################\n");
                    
                }
            }
            else if(EnteranceValue==2){
                System.out.println("*************List of Scheduled Flights*************");
                for(ScheduledFlights x : DatedFlights){
                    System.out.println(x);
                    System.out.println("#####################################################################################################\n");
                    
                }
            }
            else if(EnteranceValue==3){
                System.out.println("*************List of Reservations*************");
               for(Reservations x : reservations){
                   if(x.getReservationID()==-1) continue;
                    System.out.println(x);
                    System.out.println("#####################################################################################################\n");
                    
                } 
            }
            else if(EnteranceValue==4){
                System.out.println("*************List of Flight description*************");
                for(FlightDescriptions flight : flightDescriptionArray) {
                    System.out.println(flight);
                    System.out.println("#####################################################################################################\n");
                }
                System.out.print("Enter a FLIGHT DESCRIPTION ID to use to Schedule a flight:  ");
                int ScheduleVar = input.nextInt();
                System.out.println("");    
                  while(ScheduleVar>=flightDescriptionArray.size()){
                        System.out.println("Enter a vaild ID!!");
                        System.out.print("Enter a FLIGHT DESCRIPTION ID to use to Schedule a flight:  ");
                        ScheduleVar = input.nextInt();
                    }
                 
                 System.out.println("Enter the Depature Date!");
                        System.out.println("The date is in format yyyy/mm/dd  hh:mm");
                        System.out.print("Enter year: ");  year=input.nextInt();
                        System.out.print("Enter month: " );  month=input.nextInt();
                        System.out.print("Enter day: ");  day=input.nextInt();
                        System.out.print("Enter hours: ");  hour=input.nextInt();
                        System.out.print("Enter minutes: ");  minute=input.nextInt();
                        Time depature = new Time(year,month,day,hour,minute);
                        hour+=flightDescriptionArray.get(ScheduleVar).getFlightDuration();
                        Time arrival = new Time(year,month,day,hour,minute);
                ScheduledFlights newValue = new ScheduledFlights(flightDescriptionArray.get(ScheduleVar),depature,arrival,globalFlightID);
                globalFlightID+=1;
                DatedFlights.add(newValue);
                System.out.printf("Scheduling a flight is done successfully!\nThe Flight Schedule ID is: %d\n", globalFlightID-1 );
                System.out.println("#######################################################################################################################");
            }   
            else if(EnteranceValue==5){
                    System.out.println("************List of passengers************");
                for(Passenger x:passengers){
                    System.out.println(x);
                    System.out.println("###################################################################################################################################");
                }
                System.out.printf("Enter Passenger ID to Create a recervisation ticket!: ");
                int PassengerID = input.nextInt();
                System.out.println("");   
                PassengerID-=33000;
                  while(PassengerID>=passengers.size()){
                        System.out.println("Enter a vaild ID!!");
                        System.out.print("Enter a FLIGHT DESCRIPTION ID to use to Schedule a flight:  ");
                        PassengerID = input.nextInt();
                        PassengerID-=33000;
                    }
                 
                System.out.println("Passenger ID entered successfully!");
                for(ScheduledFlights x:DatedFlights){
                    System.out.println(x);
                    System.out.println("###################################################################################################################################");
                }
                System.out.printf("Enter Scheduled Flight ID to Create a recervisation ticket!: ");
                int FlightID = input.nextInt();
                FlightID-=100;
                System.out.println("");    
                  while(FlightID>=DatedFlights.size()){
                        System.out.println("Enter a vaild ID!!");
                        System.out.printf("Enter a FLIGHT DESCRIPTION ID to use to Schedule a flight:\n");
                        FlightID = input.nextInt();
                        FlightID-=100;
                    }
                System.out.println("Scheduled Flight Entered successfully!\n");
                int GlobalReserviationID = reservations.size();
                int faxi = DatedFlights.size();
                if(faxi > GlobalReserviationID) GlobalReserviationID= faxi;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                Date date = new Date(); 
                
                Reservations newValue = new Reservations(DatedFlights.get(FlightID),passengers.get(PassengerID),date,GlobalReserviationID);
                
                reservations.add(newValue);
                System.out.printf("Reservation is done successfully!\nNew Reservation ID is: %d\n\n\n", GlobalReserviationID );
                System.out.println("###################################################################################################################################");
                
            }
            else if(EnteranceValue==6){
                System.out.println("*************List of Reservations*************");
               for(Reservations x : reservations){
                   if(x.getReservationID()==-1) continue;
                    System.out.println(x);
                    System.out.println("#####################################################################################################\n");
                    
                } 
               System.out.printf("Enter Reserviations ID to Delete a recervisation ticket!: ");
                int ReserveationID = input.nextInt();
                
                System.out.println("");    
                  while(ReserveationID>=reservations.size()){
                        System.out.println("Enter a vaild ID!!");
                        System.out.print("Enter Reserviations ID to Delete a recervisation ticket!: ");
                        ReserveationID = input.nextInt();
                       
                    }
                System.out.println("Reserviations ID Entered successfully!\n");
               // reservations.remove(ReserveationID-globalRemovedReservations);
               // globalRemovedReservations+=1;
               reservations.get(ReserveationID).setReservationID(-1);
                System.out.println("Reserviations Ticket canceled successfully!");
                    System.out.println("#####################################################################################################\n");
            }
            else if(EnteranceValue==7){
                System.out.println("*************Registering a Person*************");
                String name,nationality,gender;
                int age, ssn;
                System.out.printf("Enter First name: ");
                name = input.next();
                System.out.printf("Enter Last name: ");
                name+= (" "+ input.next());
                System.out.printf("Enter nationality: ");
                nationality = input.next();
                System.out.printf("Enter gender: ");
                gender = input.next();
                System.out.printf("Enter age: ");
                age = input.nextInt();
                System.out.printf("Enter ssn: ");
                ssn = input.nextInt(); 
                Person value = new Person(name,age,nationality,gender,ssn);
                persons.add(value);
                System.out.println("Registering a person done successfully");
                    System.out.println("#####################################################################################################\n");
            }
            else if(EnteranceValue==8){
                System.out.println("*************Registering a Passenger*************");
                int id = 0;
                for(Person x : persons){
                    System.out.println(id); id+=1;
                    System.out.println(x);
                    System.out.println("#####################################################################################################\n");

                }
                System.out.print("Enter person ID to register him/her to passenger: ");
                int enterID = input.nextInt();
                Passenger value = new Passenger(persons.get(enterID),33000+passengers.size(),0);
                passengers.add(value);
                System.out.println("Registering is done successfully");
                System.out.println("#####################################################################################################\n");

            }
            else if(EnteranceValue==9){
                System.out.println("*************List of Persons*************");
                int id = 0;
                for(Person x : persons){
                    System.out.println(id); id+=1;
                    System.out.println(x);
                    System.out.println("#####################################################################################################\n");

                }
            }
            else if(EnteranceValue==10){
                System.out.println("*************List of Passenger*************");
                for(Passenger x : passengers){
                    System.out.println(x);
                    System.out.println("#####################################################################################################\n");

                }
            }
            else if(EnteranceValue==11){
                System.out.println("GoodBye");
                EnteranceValue=exitCode;
            }
            else{
              //look into try catch
                System.out.println("Enter a vaild option");
            }
            
        }
    }
}
