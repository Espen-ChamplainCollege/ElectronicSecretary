/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import components.*;

public class ElectronicSecretary {
    List<SecretaryComponent> secretaryElements;

    public void addReminder(String title, String description, LocalDate date, LocalTime time){
        /*
         addReminder function for basic reminders and tasks
         */
        SecretaryComponent secretaryComponent = new ReminderComponent(title, description, date, time);
        secretaryElements.add(secretaryComponent);
    }

    public void addReminder(String title, String description, List<String> people, LocalDate date, LocalTime time){
        /*
         addReminder function for meetings
         */
        SecretaryComponent secretaryComponent = new MeetingComponent(title, description, people, date, time);
        secretaryElements.add(secretaryComponent);
    }

    public void addNote(String title, String description){
        SecretaryComponent secretaryComponent = new NoteComponent(title, description);
        secretaryElements.add(secretaryComponent);
    }

    /*
    public void removeReminder(???){

    }

    public void removeNote(???){

    }
     */

    public void printInfo(String untilDate){
        /*
         Sort elements by date, then print until date using compose()
         */
    }

}
