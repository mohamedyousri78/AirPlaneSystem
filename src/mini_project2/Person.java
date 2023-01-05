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
public class Person {
    //Declaring instances variables
    private String Name;
    private int Age;
    private String Nationality;
    private String Gender;
    private int SSN;
    
    //constructor signature
    public Person(String Name, int Age, String Nationality,String Gender,int SSN){
        setName(Name);
        setAge(Age);
        setNationality(Nationality);
        setGender(Gender);
        setSSN(SSN);
    }
    
    //Declaring Setter for each vaiable
    protected void setName(String Name){this.Name = Name;}
    protected void setAge(int Age){this.Age=Age;}
    protected void setNationality(String Nationality){this.Nationality=Nationality;}
    protected void setGender(String Gender){this.Gender=Gender;}
    protected void setSSN(int SSN){this.SSN=SSN;}
    
    //Declaring Getter for each vaiable
    protected String getName(){return Name;}
    protected int getAge(){return Age;}
    protected String getNationality(){return Nationality;}
    protected String getGender(){return Gender;}
    protected int getSSN(){return SSN;}
    
    
    @Override
    public String toString(){
        return String.format("Name: %s\t"
        +"Age: %d\n"
        +"Nationality: %s\t"
        +"Gender: %s\n"
        +"SSN: %d\n"
        ,getName(),getAge(),getNationality(),getGender(),getSSN());
    }
    
    public String toStringPassenger(){
        return String.format(
        "Name: %s\t\tSSN: %d\n"
         ,Name,SSN
        );
    }
    
}
