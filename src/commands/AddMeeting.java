/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package command;

public class AddMeeting extends AddReminder {

    @Override
    public void execute(){
        /*
         Same functionality as AddReminder with different user prompts and the addition of a meeting list
         */
        secretary.addReminder(title, description, people, date, time);
    }
}
