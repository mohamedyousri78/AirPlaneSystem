package mini_project2;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.lang.Math;

public class CreatingData {
    Time x = new Time(1,2,3,4,5);
    
    protected ArrayList<Airports> CreateAirportsData(){
        //creating arraylist of airports objects carrying airports names and location
        String[] AirportNames = {"Cairo International Airport", "Tokyo Haneda Airport",
        "Borg El Arab International Airport","Dubai International Airport",
        "Istanbul Sabiha Gökçen International Airport"};
        String[] AirportsLocations = {"Cairo, Egypt","Ōta, Tokyo","Alexandria, Egypt",
        "Garhoud, Dubai, United Arab Emirates","Pendik, Istanbul, Turkey"};
        ArrayList<Airports> data= new ArrayList<Airports>();
        Airports temp ;
        for(int index=0;index<5;index++){
            temp = new Airports(AirportNames[index], AirportsLocations[index]);
            data.add(temp);
        }
        
        return data;
    }
        
    public ArrayList<Time> CreateTimes(){
        Random randomGenrator = new Random();
        int year=2023, month, day, hours, minutes;
        //creating arraylist of random values dates
        ArrayList<Time> Times = new ArrayList<Time>();
        //genrating just 28 date
        for(int i=0; i<28;i++){
        month = 1+Math.abs(randomGenrator.nextInt(12)); // creating random month
        day = 1 +Math.abs(randomGenrator.nextInt(30)); //no more than 28 day in month
        hours = Math.abs(randomGenrator.nextInt(12));  
        //create hours not more than 12 so when adding flight duration from flight 
        //descriptions the sum wont be greater 24
        minutes = Math.abs(randomGenrator.nextInt()%31); // the same as hours
        Time temp = new Time(day,month,year,hours,minutes);
        Times.add(temp);
        
        }
        
        return Times;
    } 
    
    ArrayList<FlightDescriptions> CreateFlightDescription(ArrayList<Airports> airports,ArrayList<Time> Times){
        Random randomGenrator = new Random();
        //creating arraylist of flightDescriptions objects from Times and Airports objects
        ArrayList<FlightDescriptions> flights = new ArrayList<FlightDescriptions>();
        String from, to;
        int cap, temp, duration;
        int maxi = Times.size();
        int faxi = airports.size();
        FlightDescriptions value;
        for(int i =0;i<10;i++){
            temp = Math.abs(randomGenrator.nextInt());
            from = airports.get(temp%faxi).getName();
            temp+=1;
            to = airports.get(temp%faxi).getName();
            cap = 10*(5+Math.abs(randomGenrator.nextInt(5)));
            duration = Math.abs(randomGenrator.nextInt(13));
            value = new FlightDescriptions(duration,cap,from,to,i);
            flights.add(value);
        }
        //Iterator<FlightDescriptions> ite = flights.iterator();
       
        return flights;
        
    }
    
    ArrayList<ScheduledFlights> CreateScheduledFlights(ArrayList<FlightDescriptions> flights,ArrayList<Time> Times){
        ArrayList<ScheduledFlights> DatedFlights = new ArrayList<>();
        Random randomGenrator = new Random();
        ScheduledFlights value;
        Time depature, arrival ;
        int duration;
        FlightDescriptions myFlightDescription ;
        int ID = 100;
        for(int i=0;i<20;i++){
            //pick random flight description
            myFlightDescription = flights.get(Math.abs(randomGenrator.nextInt())%10);
            duration = myFlightDescription.getFlightDuration();
            
            depature = Times.get(Math.abs(randomGenrator.nextInt(28)));
            //creating arrival date from depature date + duration
            arrival = new Time(depature.getYear(),depature.getMonth(),depature.getDay()
            ,depature.getHour()+duration,depature.getMinutes());
            value = new ScheduledFlights(myFlightDescription,depature,arrival,ID);
            DatedFlights.add(value);
            ID += 1;
        }
        return DatedFlights;
    }
    
    ArrayList<Person> CreatingPersons(){
        
        String[] names = {"حبيب","عثمان","نصر","علي","احمد", "رفيق", 
                          "وائل","عبدالله", "فوده", "هادي","حيدر","ابراهيم",
                          "معتز","مؤمن","خالد","محمد","طارق","مهند",
                          "سامي","يحيي","توفيق","عاطف"};
        int namesLength=22;
        String[] nationalities = {"ألباني", "جزائري", "مصري",  "عراقي","أردني",
                                  "كويتي", "لبناني", "ليبي","مغربي","عماني","فلسطيني",
                                  "قطري","سعودي","صومالي","سوداني","سوري","تونسي","يمني"};
        Random randomGenrator = new Random();
        int age, ssn1, ssn2;
        String Nationality;
        Person value;
        ArrayList<Person> persons = new ArrayList<Person>();
        //ArrayList<String> fullName = new ArrayList<String>(Arrays.asList(names));
       // ArrayList<String> fullName = new ArrayList<String>();
        String theName, gender, TheSSN;
        for(int i=2;i<52;i++){
            int temp = Math.abs(randomGenrator.nextInt());
            theName = names[temp%namesLength];
            theName+=" ";
            theName+= names[(temp+1)%namesLength];
          //  fullName.add(theName);
            age = 16+ randomGenrator.nextInt(30);
            Nationality = nationalities[randomGenrator.nextInt(18)];
            gender = "Male";
            ssn1 = 100 + randomGenrator.nextInt(900);
            ssn2 = randomGenrator.nextInt(1000);
            ssn2 = 1000*ssn1 + ssn2;
            value = new Person(theName,age,Nationality,gender,ssn2);
            persons.add(value);
        }
        
        return persons;
    }
    
    ArrayList<Passenger> CreatingPassengers(ArrayList<Person> persons){
          int ID = 33000;
          int flightID = 0;
          int maxi = persons.size();
          Person passengerInfo;
          Passenger value;
          ArrayList<Passenger> result = new ArrayList<>();
          for(int i=0;i<50;i++){
              passengerInfo = persons.get(i%maxi);
              
              value = new Passenger(passengerInfo,ID,flightID);
              ID+=1;
              result.add(value);
          }
          
          
          return result;
      }
    
    ArrayList<Reservations> CreateReservations(ArrayList<Passenger> passenger,ArrayList<ScheduledFlights> DatedFlights){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        ArrayList<Reservations> result = new ArrayList<Reservations>();
        Random randomGenrator = new Random();
        int maxi = passenger.size();
        int faxi = DatedFlights.size();
        if(faxi > maxi) maxi= faxi;
        ScheduledFlights thisFlight;
        Passenger thisPassenger;
        Reservations value;
        for(int i=0;i<maxi;i++){
            date = new Date(); 
            thisPassenger = passenger.get(Math.abs(randomGenrator.nextInt())%maxi);
            thisFlight = DatedFlights.get(Math.abs(randomGenrator.nextInt())%faxi);
            thisPassenger.setFlightID(thisFlight.getFlightID());
            value = new Reservations(thisFlight,thisPassenger,date,i);
            result.add(value);
        }
        return result;
    }
    
}
