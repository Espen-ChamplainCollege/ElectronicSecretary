/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package command;

public class AddNote implements Command {
    ElectronicSecretary secretary;

    public AddNote (ElectronicSecretary secretary){
        this.secretary = secretary;
    }

    public void execute(){
        /*
         Get note string from user input here
         */
        secretary.addNote(title, description);
    }
}
