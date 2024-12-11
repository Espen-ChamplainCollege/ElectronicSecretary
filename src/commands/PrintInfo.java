package commands;

import java.util.Scanner;

import main.ElectronicSecretary;
import utilities.ComponentNotFoundException;

public class PrintInfo implements Command{
    ElectronicSecretary secretary;

    public PrintInfo(ElectronicSecretary secretary){
        this.secretary = secretary;
    }

    public void execute(){
        Scanner temp = new Scanner(System.in);
        System.out.print("Enter the title of the item you want to display: ");
        String input = temp.nextLine();

        try{
            secretary.printInfo(input);
        }catch(ComponentNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
