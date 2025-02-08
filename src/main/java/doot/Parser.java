package doot;

import java.io.IOException;

//This class is for interpreting what the user means. It contains a Tasklist so it can edit it
public class Parser {
    private TaskList list;

    public Parser(TaskList list) {
        this.list = list;
    }

    //the main method, takes in the user input and converts it to commands
    //@userInput the input by the user
    public void handleCommand(String userInput) {
        if (userInput.isEmpty()) {
            Ui.showMessage("say something I'm giving up on you");
        } else if (userInput.equals("thank mr skeltal")) {
            Ui.showMessage("good bones and calcium will come to you");
        } else if (userInput.equals("doot doot")) {
            Ui.showMessage("doot doot");
        } else if (userInput.equals("list")) {
            Ui.showMessage(list.returnList());
        } else if (Parser.isMark(userInput)) {
            handleMark(userInput);
        } else if (Parser.isUnMark(userInput)) {
            handleUnMark(userInput);
        } else if (userInput.startsWith("delete ")) {
            handleDelete(userInput);
        } else if (userInput.equals("listData")) {
            Ui.showMessage(list.listData());
        } else if (userInput.equals("savedata")) {
            saveList();
        } else if (userInput.startsWith("find ")) {
            handleFind(userInput);
        } else {
            addTask(userInput);
        }
    }

    //called by the parser when the user enters something starting with mark. It sets the task in TaskList to be marked
    //@param userInput the entire userinput is fed back in
    private void handleMark(String userInput) {
        int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
        if (isValidIndex(index)) {
            list.mark(index);
            Ui.showMessage("doot doot\n\n" + list.returnList());
            saveList();
        } else {
            Ui.showMessage("too big/too small number");
        }
    }

    //sets the corresponding task as not completed
    //@param userInput the user Input
    private void handleUnMark(String userInput) {
        int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
        if (isValidIndex(index)) {
            list.unMark(index);
            Ui.showMessage("noot noot\n\n" + list.returnList());
            saveList();
        } else {
            Ui.showMessage("too big/too small number");
        }
    }

    //It handles deletes
    private void handleDelete(String userInput) {
        int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
        if (isValidIndex(index)) {
            Task removed = list.getTask(index);
            list.removeTask(index);
            Ui.showMessage("calcium for you\n   removed " + removed.getDetails() + "\n" + list.size() + " more to do\n");
            saveList();
        } else {
            Ui.showMessage("too big/too small number");
        }
    }

    //it adds tasks to the tasklist as according to the userinput
    private void addTask(String userInput) {
        try {
            list.addTask(userInput);
            saveList();
        } catch (Doot.InvalidFormatException e) {
            Ui.showMessage(e.toString());
        }
    }

    //called after every command that edits the list, it saves the list using the Storage class
    private void saveList() {
        try {
            Storage.saveList(list);
        } catch (IOException e) {
            Ui.showMessage(e.toString());
        }
    }

    //determines if the index is valid for commands like delete or mark, like if there are only 3 tasks the command
    //unmark 4 will return a false
    private boolean isValidIndex(int index) {
        return index >= 0 && index < list.size();
    }

    //determines if the command is a mark command, and if it is valid
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

    //determines if this is an unmark command, and checks if it is valid
    public static boolean isUnMark(String str) {
        if (str.startsWith("unmark ") || str.startsWith("Unmark ")) {
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

    //just runs the searchWord() method for TaskList
    public void handleFind(String str) {
        String text = str.substring(5).strip();
        if (text.equals("")) {
            Ui.showMessage("put something after the find");
        } else {
            String found = list.searchWord(text);
            if (found.equals("")) {
                Ui.showMessage("nothing found");
            } else {
                Ui.showMessage(found);
            }
        }
    }
}