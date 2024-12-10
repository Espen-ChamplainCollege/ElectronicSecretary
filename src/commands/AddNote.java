/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */
package commands;

import main.*;
import utilities.*;
import java.util.Scanner;

public class AddNote implements Command {
    ElectronicSecretary secretary;

    public AddNote (ElectronicSecretary secretary){
        this.secretary = secretary;
    }

    public void execute(){
        Scanner temp = new Scanner(System.in);
        System.out.print("Note Title: ");
        String title = temp.nextLine();

        System.out.print("Note contents: ");
        String description = temp.nextLine();

        String answer;

        while(true){
            System.out.println("Do you want to add this note to an existing item? (yes/no): ");
            answer = temp.nextLine();
            if (answer.toLowerCase().equals("yes")){
                System.out.println("Enter the title of the item you want to add this note to: ");
                String existingComponentTitle = temp.nextLine();
                try {
                    secretary.addNote(title, description, existingComponentTitle);
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
                secretary.addNote(title, description);
                break;
            }
        }
        System.out.println("Note added successfully.");
    }
}
