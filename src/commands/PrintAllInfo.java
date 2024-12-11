package commands;

import main.ElectronicSecretary;

public class PrintAllInfo implements Command{
    ElectronicSecretary secretary;

    public PrintAllInfo(ElectronicSecretary secretary){
        this.secretary = secretary;
    }

    public void execute(){
        secretary.printAllInfo();
    }
}
