/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_project2;
import java.util.Scanner;
/**
 *
 * @author Mohamed
 */
public class Functions {
    Scanner input = new Scanner(System.in);
    public int DisplayMenu(){
        String Lines[] = new String[14];
        Lines[1] = "1- List Airports";
        Lines[2] = "2- List Scheduled Flights"; 
        Lines[3] = "3- List Reservations";
        Lines[4] = "4- Schedule a flight";
        Lines[5] = "5- Make a reservisition";
        Lines[6] = "6- Cancel a reservisition";
        Lines[7] = "7- Register a person";
	Lines[8] = "8- Register a passenger";
        Lines[9] = "9- List persons";
        Lines[10] = "10- List passengers";
        Lines[11] = "11- Exit";
        for(int i=1;i<=11;i++){
            System.out.println(Lines[i]);
        }
        System.out.print("Enter your choice number: ");
        int value = input.nextInt();
        return value;
    }
}
