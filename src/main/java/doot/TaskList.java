package doot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    private List<Task> arr;
    public TaskList() {
        arr = new ArrayList<>();
    }

    //creates a new task from the userinput str, adds it to the list, and creates a message
    public void addTask(String str) throws InvalidFormatException {
        Task task = Task.makeTask(str);
        arr.add(task);
        Ui.showMessage("task added\n   " + task.getDetails() + "\nyou now have " + arr.size() + " tasks in the list");
    }

    //loads tasks by running the strings needed from the file.
    //@param File f is the file which contains the past commands used to make the list
    public void loadTask(File f) throws FileNotFoundException, InvalidFormatException {
        Scanner s = new Scanner(f);
        int count = 0;
        while (s.hasNext()) {
            String line = s.nextLine();
            if (line.startsWith("d ")) {
                line = line.substring(2);
                Task task = Task.makeTask(line);
                arr.add(task);
                this.mark(count);
            } else {
                Task task = Task.makeTask(line);
                arr.add(task);
            }
            count += 1;
        }
    }

    //returns the entire list, in the format used for printing as a list when called by the user
    public String returnList() {
        int count = 1;
        StringBuilder list = new StringBuilder();
        for (Task task : arr) {
            list.append(count).append(". ").append(task.getDetails()).append("\n");
            count ++;
        }
        return list.toString().trim();
    }

    //used for saving. This assembles the creationString() of all tasks and seperates them in their own lines
    public String listData() {
        StringBuilder list = new StringBuilder();
        for (Task task : arr) {
            list.append(task.creationString()).append("\n");
        }
        return list.toString().trim();
    }

    //gets the size of the list
    public int size() {
        return arr.size();
    }

    //marks the task in the list
    public void mark(int num) {
        arr.get(num).setDone();
    }

    //unmarks the task in the list
    public void unMark(int num) {
        arr.get(num).setUndone();
    }

    //returns the corresponding task
    public Task getTask(int num) {
        return arr.get(num);
    }

    //deletes the task
    public void removeTask(int num) {
        arr.remove(num);
    }

    //returns the details of all tasks that has the str within their description
    public String searchWord(String str) {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            if (this.getTask(i).isSubstring(str)) {
                list.append(this.getTask(i).getDetails()).append("\n");
            }
        }
        return list.toString().strip();
    }
}
