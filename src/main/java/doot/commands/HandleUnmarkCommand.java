package doot.commands;

import doot.Parser;
import doot.Storage;
import doot.TaskList;
import doot.Ui;

import java.io.IOException;

public class HandleUnmarkCommand implements Command {
    public String userInput;
    public TaskList list;

    public HandleUnmarkCommand(String userInput, TaskList list) {
        this.userInput = userInput;
        this.list = list;
    }


    public String execute() {
        int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
        if (Parser.isValidIndex(index, list)) {
            list.unMark(index);
            Ui.showMessage("noot noot\n\n" + list.returnList());
            try {
                Storage.saveList(list);
                return "doot doot\n\n" + list.returnList();
            } catch (IOException e) {
                return "file cant be saved\n" + e;
            }
        } else {
            Ui.showMessage("too big/too small number");
            return "too big/too small number";
        }
    }
}
