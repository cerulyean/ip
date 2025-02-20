package doot;

//the class for storing information on individual tasks.
//contains state, description, type. This is an abstract class so that the more specific task classes can inherit
public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected String tag;

    protected Type type;

    public Task(String description) {
        this.description = description.strip();
        this.isDone = false;
    }

    //static class used to make a new class, then returns said class
    public static Task makeTask(String str) throws InvalidFormatException {
        String[] parts = str.split(" ", 2); // Split at first space
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new InvalidFormatException("Tasks must have a description.\n Fix it.");
        }

        String type = parts[0];
        String details = parts[1].trim();


        String[] keywords = {"/tag", "/end", "/start", "/by"};

        for (String keyword : keywords) {
            if (Parser.keywordChecker(str, keyword)) {
                throw new InvalidFormatException("There cannot be multiple " + keyword + " in the input.");
            }
        }

        return switch (type) {
            case "todo" -> Parser.parseTodo(details);
            case "deadline" -> Parser.parseDeadline(details);
            case "event" -> Parser.parseEvent(details);
            default -> throw new InvalidFormatException("I do not understand this!");
        };
    }

    //checks if the str is a substring of the description
    public boolean isSubstring(String str) {
        return this.description.contains(str);
    }

    public String getType() {
        return "[" + type.name() + "]";
    }

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

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return this.tag;
    }
}
