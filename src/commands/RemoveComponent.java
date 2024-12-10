/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package commands;

import main.*;
import components.*;
import java.util.Scanner;

public class RemoveComponent implements Command {
    ElectronicSecretary secretary;

    public RemoveComponent (ElectronicSecretary secretary){
        this.secretary = secretary;
    }

    public void execute(){
        Scanner temp = new Scanner(System.in);
        System.out.print("Title of Item to Remove: ");
        String title = temp.nextLine();
        temp.close();

        try {
            secretary.removeComponent(title);
            System.out.println("Item successfully removed.");
        }
        catch (ComponentNotFoundException e){
            System.out.println("Item not found.");
        }
        catch (ComponentNotTopLevelException e){
            System.out.println("Item is not a parent, child items cannot be removed.");
        }
    }
}
