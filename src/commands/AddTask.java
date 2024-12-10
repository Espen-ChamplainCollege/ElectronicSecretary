/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package commands;

import main.*;
import utilities.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddTask extends AddReminder {

    public AddTask(ElectronicSecretary secretary){
        super(secretary);
    }

    @Override
    public void execute(){
        /*
         Same functionality as AddReminder with different user prompts
         */
        Scanner temp = new Scanner(System.in);
        System.out.print("Title of Task: ");
        String title = temp.nextLine();
        title = "Task: " + title;

        System.out.print("Task Description: ");
        String description = temp.nextLine();

        LocalDate date = getDate(temp);
        LocalTime time = getTime(temp);

        String answer;
        String buffer = temp.nextLine();

        while(true){
            System.out.println("Do you want to add this task to an existing item? (yes/no): ");
            answer = temp.nextLine();
            if (answer.toLowerCase().equals("yes")){
                System.out.println("Enter the title of the item you want to add the task to: ");
                String existingComponentTitle = temp.nextLine();
                try {
                    secretary.addReminder(title, description, date, time, existingComponentTitle);
                    break;
                }
                catch (ComponentNotFoundException e){
                    System.out.println("Item not found.");
                }
                catch (UnsupportedOperationException e){
                    System.out.println("Notes cannot be added to.");
                }
            }
            else if (answer.toLowerCase().equals("no")){
                secretary.addReminder(title, description, date, time);
                break;
            }
        }
        System.out.println("Task added successfully.");
    }
}
