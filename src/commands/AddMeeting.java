/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package commands;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import main.*;

public class AddMeeting extends AddReminder {

    public AddMeeting(ElectronicSecretary secretary){
        super(secretary);
    }

    @Override
    public void execute(){
        /*
         Same functionality as AddReminder with different user prompts and the addition of a meeting list
         */
        //Name
        Scanner temp = new Scanner(System.in);
        System.out.print("Meeting Name: ");
        String title = temp.nextLine();

        //Description
        System.out.print("Meeting Description: ");
        String description = temp.nextLine();

        //Date and Time
        LocalDate date = getDate(temp);
        LocalTime time = getTime(temp);

        //People
        List<String> people = new ArrayList<String>();
        System.out.println("Who will be at the meeting? Type 'done' to continue");
        while(true){
            String nextLine = temp.nextLine();
            if(nextLine.toLowerCase() == "done"){
                break;
            }
            else{
                people.add(nextLine);
            }
        }

        String answer;

        while(true){
            System.out.println("Do you want to add this meeting to an existing item? (yes/no): ");
            answer = temp.nextLine();
            if (answer.toLowerCase() == "yes"){
                System.out.println("Enter the title of the item you want to add this meeting to: ");
                String existingComponentTitle = temp.nextLine();
                try {
                    secretary.addMeeting(title, description, people, date, time, existingComponentTitle);
                    break;
                }
                catch (ComponentNotFoundException e){
                    System.out.println("Item not found.");
                }
                catch (UnsupportedOperationException e){
                    System.out.println("Notes cannot be added to.");
                }
            }
            else if (answer.toLowerCase() == "no"){
                secretary.addReminder(title, description, people, date, time);
                break;
            }
        }
        System.out.println("Meeting added successfully.");
        temp.close();
    }
}
