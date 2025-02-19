package doot.commands;

import doot.Parser;
import doot.InvalidFormatException;
import doot.TaskList;
import doot.Ui;
import doot.Storage;

import java.io.IOException;

import static doot.Storage.saveList;

public class HandleMarkCommand implements Command{
    public String userInput;
    public TaskList list;

    public HandleMarkCommand(String userInput, TaskList list) {
        this.userInput = userInput;
        this.list = list;
    }




    public String execute() throws IOException, InvalidFormatException {
        int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
        if (Parser.isValidIndex(index, list)) {
            list.mark(index);
            Ui.showMessage("Eye'm the strongest!\n\n" + list.returnList());
//            try {
                Storage.saveList(list);
                return "Eye'm the strongest!\n\n" + list.returnList();
//            } catch (IOException e) {
//                return "file cant be saved\n" + e;
//            }
        } else {
            throw new InvalidFormatException("That number is invalid.\nFix it");
        }
    }
}
