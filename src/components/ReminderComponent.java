/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package components;

import utilities.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class ReminderComponent extends SecretaryComponent{
    protected LocalDate date;
    protected LocalTime time;

    protected List<SecretaryComponent> components = new ArrayList<SecretaryComponent>();

    public ReminderComponent(String title, String description, LocalDate date, LocalTime time){
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    @Override
    public void addComponent(SecretaryComponent component){
        components.add(component);
    }

    @Override
    public void removeComponent(SecretaryComponent component){
        components.remove(component);
    }

    @Override
    public SecretaryComponent findComponent(String title) throws ComponentNotFoundException{
        if (!components.isEmpty()){
            for (SecretaryComponent component: components){
                if (component.getTitle().toLowerCase().equals(title.toLowerCase())){
                    return component;
                }
                try {
                    return component.findComponent(title);
                }
                catch (Exception e){
                    continue;
                }
            }
        }
        throw new ComponentNotFoundException();
    }

    public String compose(){
        StringBuilder string = new StringBuilder();

        string.append("Title: " + this.title + "\n");
        string.append("Description: " + this.description + "\n");
        string.append("Date: " + LocalDateToString() + "\n");
        string.append("Time: " + LocalTimeToString() + "\n");

        for (SecretaryComponent component: components){
            string.append(component.compose());
        }

        return string.toString();
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
