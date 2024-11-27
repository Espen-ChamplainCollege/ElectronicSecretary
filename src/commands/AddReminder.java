/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package command;

public class AddReminder implements Command {
    ElectronicSecretary secretary;

    public AddReminder (ElectronicSecretary secretary){
        this.secretary = secretary;
    }

    public void execute(){
        /*
         Figure out how to get a title, description, date, and time from user input
         */
        secretary.addReminder(title, description, date, time);
    }
}
