package main;

import commands.*;
import java.util.ArrayList;
import java.util.List;

public class CommandCenter {
    private List<Command> commandList = new ArrayList<Command>();

    public void performCommand(Command command){
        command.execute();
        commandList.add(command);
    }
}
