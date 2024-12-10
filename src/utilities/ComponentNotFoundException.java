package utilities;

public class ComponentNotFoundException extends Exception {
    public ComponentNotFoundException(){
        super("Component not found.");
    }
}
