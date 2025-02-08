package doot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static doot.Doot.formats;

//subclass of task, deadlinetask is the class for deadline tasks(wow)
public class DeadlineTask extends Task {
    protected String deadline;
    protected LocalDate datedeadline;
    public DeadlineTask(String description, String deadline) {
        super(description);
        this.type = Type.D;
        this.deadline = deadline;
        for (String format : formats) {
            try {
                this.datedeadline = LocalDate.from(LocalDate.parse(deadline, DateTimeFormatter.ofPattern(format)).atStartOfDay());
            } catch (DateTimeParseException ignored) {
            }
        }
    }

    @Override
    public String getType() {
        return "[" +type.name() +"]";
    }

    //deadline tasks include information on the actual deadline. This method converts the localtime to a string format
    //if there isnt a localtime, it just returns the string instead
    public String getDeadline() {
        return !(datedeadline == null) ? datedeadline.format(DateTimeFormatter.ofPattern("dd MMM, yyyy")) : deadline;
    }

    @Override
    public String getDetails() {
        return this.getType() + this.getStatusIcon() + " " + this.getDescription() + " (by: " + getDeadline() + ")";
    }

    @Override
    public String creationString() {
        StringBuilder list = new StringBuilder();
        if (this.isDone) {
            list.append("d ");
        }
        list.append("deadline ").append(this.getDescription()).append(" /by ").append(deadline);

        return list.toString();
    }
}
