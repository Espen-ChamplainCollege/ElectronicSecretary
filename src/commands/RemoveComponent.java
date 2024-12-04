/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package commands;

import main.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RemoveComponent implements Command {
    ElectronicSecretary secretary;

    public RemoveComponent (ElectronicSecretary secretary){
        this.secretary = secretary;
    }

    /*
    public void execute(){
        secretary.condensedPrint(true);
        Scanner temp = new Scanner(System.in);
        while(true){
            try {
                System.out.print("Select an item: ");
                componentIdx = temp.nextInt() - 1;
                secretary.printComponent(componentIdx, true);
                System.out.print("Select an item: ");
            }
            catch(InputMismatchException e){
                System.out.println("ERROR! Invalid Input. Please input an integer.");
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("ERROR! Invalid Integer. Please input an integer from the options available.");
            }
        }
    }
     */
}
