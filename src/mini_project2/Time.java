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
public class Time {
    //Declaring instances variables
    private int Year;
    private int Month;
    private int Day;
    private int Hour;
    private int Minute;
    //constructor signature
    public Time(int Year, int Month,int Day,int Hour,int Minutes){
        setYear( Year);
        setMonth( Month);
        setDay( Day);
        setHour( Hour);
        setMinutes( Minutes);
    }
    
    //Declaring Setter for each vaiable
    protected void setYear(int Year){this.Year = Year;}
    protected void setMonth(int Month){this.Month = Month;}
    protected void setDay(int Day){this.Day = Day;}
    protected void setHour(int Hour){this.Hour = Hour;}
    protected void setMinutes(int Minutes){this.Minute = Minutes;}
    
    //Declaring Getter for each vaiable
    protected int getYear(){return Year;}
    protected int getMonth(){return Month;}
    protected int getDay(){return Day;}
    protected int getHour(){return Hour;}
    protected int getMinutes(){return Minute;}
    
    //converting time to a string
    @Override
    public String toString(){
         return String.format("%02d/%02d/%d  %02d:%02d\n",Day, Month, Year ,Hour, Minute);
    }
    
    public String toStringTime(){
        return String.format("%02d:%02d\n", Hour, Minute);
    }
    
    public String toStringDate(){
        return String.format("%02d/%02d/%d\n", Day, Month, Year);
    }
}
