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
        String[] parts = str.split(" ", 2); // Split at first space
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new InvalidFormatException("Task must have a description. Nothing added, doot doot.");
        }

        String type = parts[0];
        String details = parts[1].trim();

        return switch (type) {
            case "todo" -> new TodoTask(details);
            case "deadline" -> Parser.parseDeadline(details);
            case "event" -> Parser.parseEvent(details);
            default -> throw new InvalidFormatException("Invalid task type, dumbass.");
        };
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
