/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package components;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReminderComponent extends SecretaryComponent{
    protected LocalDate date;
    protected LocalTime time;

    private List<SecretaryComponent> components = new ArrayList<>();

    public ReminderComponent(String title, String description, LocalDate date, LocalTime time){
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public void addComponent(SecretaryComponent component){
        components.add(component);
    }

    public SecretaryComponent findComponent(String title){
        for(int i = 0; i < components.size(); i++){
            if(components.get(i).getTitle() == title){
                return components.get(i);
            }
        }
        System.out.println("Error. Component not found");
        return null;
    }
    public String compose(){
        /*
         Figure out how to compose here
         */
        String output = "";
        output += "Title: " + this.title + "\n";
        output += "Description: " + this.description + "\n";
        output += "Date: " + LocalDateToString() + "\n";
        output += "Time: " + LocalTimeToString() + "\n";
        return output;
    }

    protected String LocalDateToString(){
        String dateString = this.date.toString();
        String[] splitDate = dateString.split("-");
        return splitDate[1] + "-" + splitDate[2] + "-" + splitDate[0];
    }

    protected String LocalTimeToString(){
        String timeString = this.time.toString();
        String[] splitTime = timeString.split(":");
        return splitTime[0] + ":" + splitTime[1];
    }
}
