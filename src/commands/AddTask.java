/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package command;

public class AddTask extends AddReminder {

    @Override
    public void execute(){
        /*
         Same functionality as AddReminder with different user prompts
         */
        secretary.addReminder(title, description, date, time);
    }
}
