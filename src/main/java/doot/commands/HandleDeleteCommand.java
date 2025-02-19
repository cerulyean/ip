package doot.commands;

import doot.InvalidFormatException;
import doot.Task;
import doot.TaskList;
import doot.Ui;

import java.io.IOException;

import static doot.Parser.isValidIndex;
import static doot.Storage.saveList;

public class HandleDeleteCommand implements Command {
    public TaskList list;
    public String userInput;

    public HandleDeleteCommand(TaskList list, String userInput) {
        this.list = list;
        this.userInput = userInput;

    }


    public String execute() throws IOException {
        int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
        if (isValidIndex(index, list)) {
            Task removed = list.getTask(index);
            list.removeTask(index);
            Ui.showMessage("calcium for you\n   removed " + removed.getDetails() + "\n" + list.size()
                    + " more to do\n");
//            try {
                saveList(list);
                return "calcium for you\n   removed " + removed.getDetails() + "\n" + list.size()
                        + " more to do\n";
//            } catch (IOException e) {
//                return "file cant be saved\n" + e;
//            }
        } else {
            Ui.showMessage("too big/too small number");
            return "too big/too small number";
        }
    }
}
