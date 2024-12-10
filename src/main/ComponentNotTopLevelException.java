package main;

public class ComponentNotTopLevelException extends Exception {
    public ComponentNotTopLevelException(){
        super("Only top level components can be removed");
    }
}