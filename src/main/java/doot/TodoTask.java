package doot;

//the subclass of task, specifically for the todo tasks
public class TodoTask extends Task {
    public TodoTask(String description) {
        super(description);
        type = Type.T;
    }

    //determines type of task, like T for todo
    @Override
    public String getType() {
        return "[" +type.name() +"]";
    }

    //returns details for todo objects
    @Override
    public String getDetails() {
        return this.getType() + this.getStatusIcon() + " " + this.getDescription() +
                (this.getTag() != null ? " #" + getTag() : "");
    }

    //the string necessary to make this object again
    @Override
    public String creationString() {
        StringBuilder list = new StringBuilder();
        if (this.isDone) {
            list.append("d ");
        }
        list.append("todo ").append(this.getDescription());
        if (getTag() != null) {
            list.append(" /tag ").append(getTag());
        }

        return list.toString();
    }
}
