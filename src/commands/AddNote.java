/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */
package commands;

import main.*;
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

        temp.close();
        secretary.addNote(title, description);
    }
}
