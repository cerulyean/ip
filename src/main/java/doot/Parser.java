package doot;

import doot.commands.*;

/**
 * This class is for interpreting what the user means. It contains a Tasklist so it can edit it
 */
public class Parser {
    private TaskList list;

    public Parser(TaskList list) {
        assert list != null: "primary tasklist shouldnt be null. Under Parser constructor";
        this.list = list;
    }

    /**
     * Interprets the input in the parameter as a user command, and delegates the task
     * @param userInput comes from what user enters into the terminal
     */
    public String handleCommand(String userInput) {
        assert userInput != null: "userinput under Parser.handleCommand is null, something went wrong";
        String message;
        if (userInput.isEmpty()) {
            return respond("say something I'm giving up on you");
        }

        return switch (userInput) {
            case "thank mr skeltal" -> respond("good bones and calcium will come to you");
            case "doot doot" -> respond("doot doot");
            case "list" -> respond(list.returnList());
            case "listData" -> respond(list.listData());
            default -> handleDynamicCommands(userInput);
        };
    }

    private String handleDynamicCommands(String userInput) {
        if (Parser.isMark(userInput)) {
            return new HandleMarkCommand(userInput, list).execute();
        }
        if (Parser.isUnMark(userInput)) {
            return new HandleUnmarkCommand(userInput, list).execute();
        }
        if (userInput.startsWith("delete ")) {
            return new HandleDeleteCommand(list, userInput).execute();
        }
        if (userInput.startsWith("find ")) {
            return new HandleFindCommand(list, userInput).execute();
        }
        return new AddTaskCommand(list, userInput).execute();
    }

    private String respond(String message) {
        Ui.showMessage(message);
        return message;
    }



    /**
     * determines if the index is valid for commands like delete or mark, like if there are only 3 tasks the command
     * unmark 4 will return a false
     * @param index is the task the user wants unmarked
     * @return whether that index is valid
     */
    public static boolean isValidIndex(int index, TaskList list) {
        return index >= 0 && index < list.size();
    }

    /**
     * determines if the command is a mark command, and if it is valid
     * @param str it takes in the entire userInput
     * @return whether it is a mark command
     */
    public static boolean isMark(String str) {
        if (str.startsWith("mark ") || str.startsWith("Mark ")) {
            String[] arr = str.split(" ");
            if (arr.length == 2) {
                try {
                    Integer.parseInt(arr[1]);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * determines if this is an unmark command, and checks if it is valid
     * @param str entire userinput
     * @return whether it is a valid unmark command
     */
    public static boolean isUnMark(String str) {
        if (str.startsWith("unmark ") || str.startsWith("Unmark ")) {
            String[] arr = str.split(" ");
            if (arr.length != 2) {
                return false;
            }
            try {
                Integer.parseInt(arr[1]);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    public static DeadlineTask parseDeadline(String details) throws InvalidFormatException {
        String[] parts = details.split("/by", 2);
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new InvalidFormatException("Deadline needs '/by'. Weak bone man.");
        }

        String task = parts[0].trim();
        String deadline = parts[1].trim();

        if (task.isEmpty()) {
            throw new InvalidFormatException("You need something before '/by'.");
        }

        return new DeadlineTask(task, deadline);
    }

    public static EventTask parseEvent(String details) throws InvalidFormatException {
        String[] parts = details.split("/from|/to", 3);
        if (parts.length < 3) {
            throw new InvalidFormatException("Need both '/from' and '/to' keywords for event. Doot doot.");
        }

        String task = parts[0].trim();
        String start = parts[1].trim();
        String end = parts[2].trim();

        if (task.isEmpty() || start.isEmpty() || end.isEmpty()) {
            throw new InvalidFormatException("Make sure there's text between 'event', '/from', and '/to'.");
        }

        return new EventTask(task, start, end);
    }
}
