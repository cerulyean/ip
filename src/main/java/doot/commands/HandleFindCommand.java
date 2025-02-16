package doot.commands;

import doot.TaskList;
import doot.Ui;

public class HandleFindCommand implements Command {
    public String userInput;
    public TaskList list;

    public HandleFindCommand(TaskList list, String userInput) {
        this.userInput = userInput;
        this.list = list;
    }

    public String execute() {
        String text = this.userInput.substring(5).strip();
        if (text.isEmpty()) {
            Ui.showMessage("put something after the find");
            return "put something after the find";
        } else {
            String found = list.searchWord(text);
            if (found.isEmpty()) {
                Ui.showMessage("nothing found");
                return "nothing found";
            } else {
                Ui.showMessage(found);
                return found;
            }
        }
    }
}
