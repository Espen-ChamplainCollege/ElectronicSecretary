package components;

public class ComponentNotFoundException extends Exception {
    public ComponentNotFoundException(){
        super("Component not found.");
    }
}
