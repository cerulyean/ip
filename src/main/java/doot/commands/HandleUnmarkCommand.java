package doot.commands;

import doot.*;

import java.io.IOException;

/**
 * Unmarks the task in the index of the given tasklist
 */
public class HandleUnmarkCommand implements Command {
    public String userInput;
    public TaskList list;

    /**
     * creates the command to unmark a task at an index
     * @param userInput the entire input from the user
     * @param list the list in which the task is to be unmarked
     */
    public HandleUnmarkCommand(String userInput, TaskList list) {
        this.userInput = userInput;
        this.list = list;
    }


    /**
     * Executes the unmarking
     * @return the response of the bot. It may be acknowledgement of task success, or an error message informing on
     * what went wrong
     */
    public String execute() throws IOException, InvalidFormatException {
        int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
        if (Parser.isValidIndex(index, list)) {
            list.unMark(index);
            Ui.showMessage("noot noot\n\n" + list.returnList());
//            try {
                Storage.saveList(list);
                return "doot doot\n\n" + list.returnList();
//            } catch (IOException e) {
//                return "file cant be saved\n" + e;
//            }
        } else {
            throw new InvalidFormatException("That number is invalid.\nFix it");
        }
    }
}
