package main;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import components.*;
import commands.*;


public class SecretaryTest {
    
    static ElectronicSecretary e;
    static CommandCenter c;
    static AddMeeting addMeeting;
    static AddNote addNote;
    static AddReminder addReminder;
    static AddTask addTask;
    static RemoveComponent removeComponent;

    @BeforeAll
    static void startup(){
        e = new ElectronicSecretary();
        c = new CommandCenter();
        addMeeting = new AddMeeting(e);
        addNote = new AddNote(e);
        addReminder = new AddReminder(e);
        addTask = new AddTask(e);
        removeComponent = new RemoveComponent(e);
    }

    @Test
    @DisplayName("Add Reminder Test")
    void reminderTest(){
        String testInput = "Test Reminder\nTest Description\n3\n10\n10\n30\nno";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        c.performCommand(addReminder);
        
        SecretaryComponent temp = e.secretaryComponents.get(0);
        String output = temp.compose();
        String expected = "Title: Test Reminder\nDescription: Test Description\nDate: 3-10-2025\nTime: 10:30\n";
        assertEquals(expected, output);
    }
}
