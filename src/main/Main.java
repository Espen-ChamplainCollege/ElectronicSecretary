/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
*/

package main;

import java.util.Scanner;
import commands.*;

public class Main {
    public static void main(String[] args){
        /*
         Initialization of the program
         */

        // Secretary initialization
        ElectronicSecretary secretary = new ElectronicSecretary();
        CommandCenter commandCenter = new CommandCenter();

        // Command initialization
        AddReminder addReminder = new AddReminder(secretary);
        AddTask addTask = new AddTask(secretary);
        AddMeeting addMeeting = new AddMeeting(secretary);
        AddNote addNote = new AddNote(secretary);
        RemoveComponent removeComponent = new RemoveComponent(secretary);
        PrintInfo printInfo = new PrintInfo(secretary);
        PrintAllInfo printAll = new PrintAllInfo(secretary);

        /*
         Interface
         */
        System.out.println("*************************************************");
        System.out.println("*                                               *");
        System.out.println("* Welcome to the Electronic Secretary Interface *");
        System.out.println("*                                               *");
        System.out.println("*************************************************\n");

        Scanner input = new Scanner(System.in);
        String selection = "";

        while (!selection.toLowerCase().equals("x")){
            System.out.println("Select an option from the menu:\n");
            System.out.println("[1] Add a reminder");
            System.out.println("[2] Add a task");
            System.out.println("[3] Add a meeting");
            System.out.println("[4] Add a note");
            System.out.println("[5] Remove an item");
            System.out.println("[6] View an item");
            System.out.println("[7] View all items");
            System.out.println("[X] Exit");

            selection = input.nextLine();
            
            switch (selection){
                case "1":
                    commandCenter.performCommand(addReminder);
                    break;

                case "2":
                    commandCenter.performCommand(addTask);
                    break;

                case "3":
                    commandCenter.performCommand(addMeeting);
                    break;

                case "4":
                    commandCenter.performCommand(addNote);
                    break;

                case "5":
                    commandCenter.performCommand(removeComponent);
                    break;
                case "6":
                    commandCenter.performCommand(printInfo);
                    break;
                case "7":
                    commandCenter.performCommand(printAll);
                    break;
            }
        }
        input.close();
    }
}
