/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package component;

public abstract class SecretaryComponent{
    protected title;
    protected description;

    public abstract String compose();

    public void addElement(SecretaryComponent element) {
        throw new UnsupportedOperationException("This Element cannot have child nodes.");
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

    public void setDescription(String title){
        this.description = description;
    }


}
