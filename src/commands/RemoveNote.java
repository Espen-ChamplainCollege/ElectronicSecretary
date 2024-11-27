/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package command;

public class RemoveNote implements Command {
    ElectronicSecretary secretary;

    public RemoveNote (ElectronicSecretary secretary){
        this.secretary = secretary;
    }

    public void execute(){
        /*
         Figure out how to specify which note to remove and get it from user input
         */
    }
}
