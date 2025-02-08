package doot;

//the class for storing information on individual tasks.
//contains state, description, type. This is an abstract class so that the more specific task classes can inherit
public abstract class Task {
    protected String description;
    protected boolean isDone;

    protected Type type;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    //static class used to make a new class, then returns said class
    public static Task makeTask(String str) throws InvalidFormatException {
        String taskDescription = str.substring(str.indexOf(" ") + 1).trim();
        if (taskDescription.isEmpty()) {
            throw new InvalidFormatException("tasj must have description at back nothing added doot doot");
        }

        if (str.startsWith("todo ")) {
            return new TodoTask(str.substring(str.indexOf(" ") + 1));
        } else if (str.startsWith("deadline ")) {
            if (!str.contains("/by")) {
                throw new InvalidFormatException("deadline needs /by weak bone man");
            }
            String deadline = str.substring(str.indexOf("/by") + 4);
            if (deadline.equals("-1") || !str.contains("/by")) {
                throw new InvalidFormatException("pls /by correctly");
            }
            if (str.indexOf("/by") - 2 - str.indexOf(" ") < 1) {
                throw new InvalidFormatException("u need sumting between deadline and /by");
            }
            return new DeadlineTask(str.substring(str.indexOf(" ") + 1, str.indexOf("/by") - 1), deadline);
        } else if (str.startsWith("event ")) {
            if (!str.contains("/from") || !str.contains("/to")) {
                throw new InvalidFormatException("need /from and /to keyword for event doot doot");
            }

            if (str.indexOf("/from") - 2 - str.indexOf(" ") < 1) {
                throw new InvalidFormatException("u need sumting between event and /from");
            }

            if (str.indexOf("/from") > str.indexOf("/to")) {
                throw new InvalidFormatException("/from before /to u dum");
            }

            if (str.indexOf("/from") + 6 > str.indexOf("/to") - 1) {
                throw new InvalidFormatException("oop you fuked up go put something between /from and /to");
            }

            if (str.length() <= str.indexOf("/to") + 3) {
                throw new InvalidFormatException("doot doot go put something behind /to space works also ");
            }

            String start = str.substring(str.indexOf("/from") + 6, str.indexOf("/to") - 1);
            String end = str.substring(str.indexOf("/to") + 4);
            if (start.equals("-1") || end.equals("-1")) {
                throw new InvalidFormatException("/from /to formatting wrong bet you have osteoporosis");
            }
            return new EventTask(str.substring(str.indexOf(" ") + 1, str.indexOf("/from") - 1),
                    start,
                    end);
        } else {
            throw new InvalidFormatException("dumbass");
        }
    }

    //checks if the str is a substring of the description
    public boolean isSubstring(String str) {
        return this.description.contains(str);
    }

    public abstract String getType();

    //contains the line needed to create a copy of this task
    public abstract String creationString();

    //returns a string in the format to be passed to the UI to be printed for the user to see
    public String getDetails() {
        return this.getStatusIcon() + " " + this.getDescription();
    }

    //returns the status of the task in a visually nicer manner
    public String getStatusIcon() {
        return "[" + (isDone ? "X" : " ") + "]"; // mark done task with X
    }

    //gets description
    public String getDescription() {
        return description;
    }

    //set task as complete
    public void setDone() {
        this.isDone = true;
    }

    //set task as no complete
    public void setUndone() {
        this.isDone = false;
    }

    //returns if the task is complete
    public boolean isDone() {
        return isDone;
    }
}
