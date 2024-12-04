/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package commands;

import main.*;

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

        temp.close();
        
        secretary.addReminder(title, description, date, time);
    }
}
