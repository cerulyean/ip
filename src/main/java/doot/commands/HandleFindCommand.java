package doot.commands;

import doot.InvalidFormatException;
import doot.TaskList;
import doot.Ui;

public class HandleFindCommand implements Command {
    public String userInput;
    public TaskList list;

    public HandleFindCommand(TaskList list, String userInput) {
        this.userInput = userInput;
        this.list = list;
    }

    public String execute() throws InvalidFormatException {
        String text = this.userInput.substring(5).strip();
        if (text.isEmpty()) {
            throw new InvalidFormatException("Put something after the command.\nI'll wait.");
        } else {
            String found = list.searchWord(text);
            if (found.isEmpty()) {
                Ui.showMessage("Cirno found nothing!");
                return "Cirno found nothing!";
            } else {
                Ui.showMessage(found);
                return found;
            }
        }
    }
}
