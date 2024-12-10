/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package components;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MeetingComponent extends ReminderComponent{
    protected List<String> people;

    public MeetingComponent(String title, String description, List<String> people, LocalDate date, LocalTime time){
        super(title, description, date, time);
        this.people = people;
    }

    @Override
    public String compose(){
        StringBuilder string = new StringBuilder();

        string.append("Title: " + this.title + "\n");
        string.append("Description: " + this.description + "\n");
        string.append("Date: " + LocalDateToString() + "\n");
        string.append("Time: " + LocalTimeToString() + "\n");

        Iterator<String> iterator = people.iterator();

        while (iterator.hasNext()){
            string.append(iterator.next());

            if (iterator.hasNext()){
                string.append(", ");
            }
            else{
                string.append("\n");
            }
        }

        for (SecretaryComponent component: components){
            string.append(component.compose());
        }

        return string.toString();
    }
}
