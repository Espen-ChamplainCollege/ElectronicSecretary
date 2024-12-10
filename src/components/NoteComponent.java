/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package components;

public class NoteComponent extends SecretaryComponent{

    public NoteComponent(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String compose(){
        String output = "";
        output += "Note Title: " + this.title + "\n";
        output += "Description: " + this.description + "\n";
        return output;
    }
}
