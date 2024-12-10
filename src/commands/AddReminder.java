/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package commands;

import main.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddReminder implements Command {
    ElectronicSecretary secretary;

    public AddReminder (ElectronicSecretary secretary){
        this.secretary = secretary;
    }

    public void execute(){
        /*
         Same functionality as AddReminder with different user prompts
         */
        Scanner temp = new Scanner(System.in);
        System.out.print("Title of Reminder: ");
        String title = temp.nextLine();

        System.out.print("Reminder Description: ");
        String description = temp.nextLine();

        LocalDate date = getDate(temp);
        LocalTime time = getTime(temp);

        String answer;

        while(true){
            System.out.println("Do you want to add this reminder to an existing item? (yes/no): ");
            answer = temp.nextLine();
            if (answer.toLowerCase() == "yes"){
                System.out.println("Enter the title of the item you want to add this reminder to: ");
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
            else if (answer.toLowerCase() == "no"){
                secretary.addReminder(title, description, date, time);
                break;
            }
        }
        System.out.println("Reminder added successfully.");
        temp.close();
    }

    protected LocalDate getDate(Scanner temp){
        boolean dayValid = false;
        int month = 0;
        int day = 0;

        while(true){
            try{
                //Gets month based on user input
                System.out.print("Month (1-12): ");
                month = temp.nextInt();
                if(month <= 0 || month >= 13){
                    System.out.println("ERROR! Invalid month");
                    continue;
                }

                try{
                    //Get day based on user input, limited based on month
                    if(month == 2){
                        System.out.print("Day (1-29); ");
                        day = temp.nextInt();
                        if(day <= 0 || day >= 30){
                            System.out.println("ERROR! Invalid day.");
                        }
                        else{
                            dayValid = true;
                        }
                    }
                    else if(month == 4 || month == 6 || month == 9 || month == 12){
                        System.out.print("Day (1-30): ");
                        day = temp.nextInt();
                        if(day <= 0 || day >= 31){
                            System.out.println("ERROR! Invalid day.");
                        }
                        else{
                            dayValid = true;
                        }
                    }
                    else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 11){
                        System.out.print("Day (1-31): ");
                        day = temp.nextInt();
                        if(day <= 0 || day >= 32){
                            System.out.println("ERROR! Invalid day.");
                        }
                        else{
                            dayValid = true;
                        }
                    }
                }catch(InputMismatchException e){
                    System.out.println("ERROR! Invalid Input. Please input an integer");
                }
            }catch(InputMismatchException e){
                System.out.println("ERROR! Invalid Input. Please input an integer.");
            }

            if(dayValid){
                break;
            }
        }
    
        //If valid month and day, get next Date

        LocalDate today = LocalDate.now();
        LocalDate target = LocalDate.of(today.getYear(), month, day);

        if(target.isBefore(today) || target.equals(today)){
            target = target.plusYears(1);
        }
        return target;
    }

    protected LocalTime getTime(Scanner temp){
        int hour = 0;
        int minute = 0;

        while(true){
            try{
                System.out.print("Reminder hour (0-23): ");
                hour = temp.nextInt();
                if(hour < 0 || hour >= 24){
                    System.out.println("ERROR! Invalid hour");
                    continue;
                }

                System.out.print("Reminder minute (0-59): ");
                minute = temp.nextInt();
                if(minute < 0 || minute >=60){
                    System.out.println("ERROR! Invalid minute");
                    continue;
                }

                LocalTime time = LocalTime.of(hour, minute);
                return time;
            }catch(InputMismatchException e){
                System.out.print("ERROR!. Invalid Input. Please input an integer.");
            }

        }
    }
}
