
package mini_project2;
import java.util.ArrayList;
/**
 *
 * @author Mohamed
 */
public class Airports {
    //Declaring instances variables
    private String Name;
    private String Location;
    
    //constructor signature
    public Airports(String Name, String Location){
        setName( Name);
        setLocation( Location);
    }
    
    //Declaring Setter for each vaiable
    protected void setName(String Name){this.Name = Name;}
    protected void setLocation(String Location){this.Location = Location;}
    
    //Declaring Getter for each vaiable
    protected String getName(){return Name;}
    protected String getLocation(){return Location;}
    
    @Override
    public String toString(){
        return String.format("Airport name: %s\nLocated in: %s\n",Name, Location);
    }
    
}
