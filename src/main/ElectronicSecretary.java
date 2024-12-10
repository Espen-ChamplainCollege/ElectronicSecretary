/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import components.*;

public class ComponentNotTopLevelException extends Exception {
    public ComponentNotTopLevelException(){
        super("Only top level components can be removed");
    }
}

public class ElectronicSecretary {
    List<SecretaryComponent> secretaryComponents;

    private SecretaryComponent findComponent(String title){
        for (SecretaryComponent component : secretaryComponents){
            if (component.getTitle().toLowerCase() == title.toLowerCase()){
                return component;
            }
            try {
                return component.findComponent(title);
            }
            catch (ComponentNotFoundException e){
                continue;
            }
        }
        throw new ComponentNotFoundException();
    }

    public void addReminder(String title, String description, LocalDate date, LocalTime time){
        /*
         basic add function for reminders and tasks
         */
        secretaryComponents.add(new ReminderComponent(title, description, date, time));
    }

    public void addMeeting(String title, String description, List<String> people, LocalDate date, LocalTime time){
        /*
         basic add function for meetings
         */
        secretaryComponents.add(new MeetingComponent(title, description, people, date, time));
    }

    public void addNote(String title, String description){
        /*
         basic add function for notes
         */
        secretaryComponents.add(new NoteComponent(title, description));
    }

    public void addReminder(String title, String description, LocalDate date, LocalTime time, String componentTitle){
        /*
         add function for adding reminders and tasks to existing components
         */
        SecretaryComponent component = findComponent(componentTitle);
        component.add(new ReminderComponent(title, description, date, time));
    }

    public void addMeeting(String title, String description, List<String> people, LocalDate date, LocalTime time, String componentTitle){
        /*
         add function for adding meetings to existing components
         */
        SecretaryComponent component = findComponent(componentTitle);
        component.add(new ReminderComponent(title, description, people, date, time));
    }

    public void addNote(String title, String description, String componentTitle){
        /*
         add function for adding notes to existing components
         */
        SecretaryComponent component = findComponent(componentTitle);
        component.add(new NoteComponent(title, description));
    }

    public void removeComponent(String title){
        boolean componentRemoved = secretaryComponents.remove(findComponent(title));

        if (!componentRemoved){
            throw new ComponentNotTopLevelException();
        }

    }

    public void printInfo(String untilDate){
        /*
         Sort elements by date, then print until date using compose()
         */
    }

}
