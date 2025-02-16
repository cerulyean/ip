package doot.commands;

import doot.InvalidFormatException;
import doot.Storage;
import doot.TaskList;
import doot.Ui;

import java.io.IOException;

public class AddTaskCommand implements Command{
    public TaskList list;
    public String userInput;

    public AddTaskCommand(TaskList list, String userInput) {
        this.list = list;
        this.userInput = userInput;
    }

    public String execute() {
        try {
            String temp = list.addTask(userInput);
            Storage.saveList(list);
            return temp;
        } catch (InvalidFormatException e) {
            Ui.showMessage(e.toString());
            return e.toString();
        } catch (IOException e) {
            return "ioexception, save went wrong" + e;
        }
    }

}
