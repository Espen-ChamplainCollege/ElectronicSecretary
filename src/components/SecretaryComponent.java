/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package components;

public abstract class SecretaryComponent{
    protected String title;
    protected String description;

    public abstract String compose();

    public void addComponent(SecretaryComponent element) {
        throw new UnsupportedOperationException("This Element cannot have child nodes.");
    }

    public void removeComponent(SecretaryComponent element) {
        throw new UnsupportedOperationException("This Element does not have child nodes.");
    }

    public SecretaryComponent findComponent(String title) throws ComponentNotFoundException{
        throw new UnsupportedOperationException("This Element does not have child nodes.");
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
