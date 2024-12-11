/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import components.*;
import utilities.*;

public class ElectronicSecretary {
    List<SecretaryComponent> secretaryComponents = new ArrayList<SecretaryComponent>();

    private SecretaryComponent findComponent(String title) throws ComponentNotFoundException{
        if (!secretaryComponents.isEmpty()){
            for (SecretaryComponent component : secretaryComponents){
                if (component.getTitle().toLowerCase().equals(title.toLowerCase())){
                    return component;
                }
                try {
                    return component.findComponent(title);
                }
                catch (ComponentNotFoundException e){
                    continue;
                }
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

    public void addReminder(String title, String description, LocalDate date, LocalTime time, String componentTitle) throws ComponentNotFoundException{
        /*
         add function for adding reminders and tasks to existing components
         */
        try{
            SecretaryComponent component = findComponent(componentTitle);
            component.addComponent(new ReminderComponent(title, description, date, time));
        }catch(ComponentNotFoundException e){
            throw e;
        }
    }

    public void addMeeting(String title, String description, List<String> people, LocalDate date, LocalTime time, String componentTitle) throws ComponentNotFoundException{
        /*
         add function for adding meetings to existing components
         */
        try{
            SecretaryComponent component = findComponent(componentTitle);
            component.addComponent(new MeetingComponent(title, description, people, date, time));
        }catch(ComponentNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void addNote(String title, String description, String componentTitle) throws ComponentNotFoundException{
        /*
         add function for adding notes to existing components
         */
        try{
            SecretaryComponent component = findComponent(componentTitle);
            component.addComponent(new NoteComponent(title, description));
        }catch(ComponentNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeComponent(String title) throws ComponentNotTopLevelException, ComponentNotFoundException{
        boolean componentRemoved;

        try{
            componentRemoved = secretaryComponents.remove(findComponent(title));
        }catch(ComponentNotFoundException e){
            throw e;
        }

        if (!componentRemoved){
            throw new ComponentNotTopLevelException();
        }

    }

    public void printInfo(String title) throws ComponentNotFoundException{
        try{
            SecretaryComponent temp = findComponent(title);
            System.out.println(temp.compose());
        }catch(ComponentNotFoundException e){
            throw e;
        }
    }

    public void printAllInfo(){
        /*
         Sort elements by date, then print until date using compose()
         */
        for(int i = 0; i < secretaryComponents.size(); i++){
            System.out.println("--------------------");
            System.out.println(secretaryComponents.get(i).compose());
        }
    }
}
