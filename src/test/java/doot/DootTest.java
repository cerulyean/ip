package doot;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.lang.Thread;

import static org.junit.jupiter.api.Assertions.*;

public class DootTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream)); // Redirect System.out
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut); // Restore System.out
    }

    @Test
    void testPrintMethod() {
        Ui.showMessage("test"); // Call the method that prints output
        assertEquals("""
                ________________________________________________________________________________________________________________________
                test\
                
                ________________________________________________________________________________________________________________________
                
                """, outputStream.toString().replace("\r", ""));
    }

    @Test
    void clearLists() throws InterruptedException {
        int maxAttempts = 5;
        String expectedOutput = "too big/too small number";

        for (int i = 0; i < maxAttempts; i++) {
            Ui.showMessage("test " + i);  // Call the method that prints output
            Thread.sleep(100);  // Optional: Delay to let the output appear

            // Print the current output to the console so you can see it
            System.out.println("Current output: " + outputStream);

            // Check if the expected output appears
            if (outputStream.toString().contains(expectedOutput)) {
                break;
            }

            outputStream.reset();  // Clear the previous output before the next iteration
        }
    }

    @Test
    void testAddTask() throws InvalidFormatException, IOException{
        TaskList taskList = new TaskList();
        Parser parser = new Parser(taskList);

        // Test adding a task (for example, a todo task)
        parser.handleCommand("todo Task 1");

        assertEquals(1, taskList.size(), "Task count should be 1");
        assertInstanceOf(TodoTask.class, taskList.getTask(0), "The first task should be a todo task");
    }

    @Test
    void testMarkTask() throws IOException, InvalidFormatException {
        TaskList taskList = new TaskList();
        Parser parser = new Parser(taskList);

        Storage.clearSave();
        parser.handleCommand("todo Task 1"); // Add task
        parser.handleCommand("todo piss 3");

        parser.handleCommand("mark 2"); // Mark task 1

        assertTrue(taskList.getTask(1).isDone(), "The task should be marked as done");
    }

    @Test
    void testUnMarkTask() throws IOException, InvalidFormatException {
        TaskList taskList = new TaskList();
        Parser parser = new Parser(taskList);
        Storage.clearSave();

        parser.handleCommand("todo Task 1"); // Add task
        parser.handleCommand("mark 1"); // Mark task 1
        parser.handleCommand("unmark 1"); // Unmark task 1

        assertFalse(taskList.getTask(0).isDone(), "The task should be marked as not done");
    }

    @Test
    void testDeleteTask() throws IOException, InvalidFormatException {
        TaskList taskList = new TaskList();
        Parser parser = new Parser(taskList);
        Storage.clearSave();

        parser.handleCommand("todo Task 1"); // Add task
        parser.handleCommand("delete 1"); // Delete task 1

        assertEquals(0, taskList.size(), "Task list should be empty after deletion");
    }

}
