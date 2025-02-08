package doot;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EventTask extends Task {
    protected String start;
    protected String end;

    protected LocalDate datestart;

    protected LocalDate dateend;

    public EventTask(String description, String start, String end) {
        super(description);
        this.type = Type.E;
        this.start = start;
        this.end = end;



        for (String format : Doot.formats) {
            try {
                this.datestart = LocalDate.from(LocalDate.parse(start, DateTimeFormatter.ofPattern(format)).atStartOfDay());
            } catch (DateTimeParseException ignored) {
            }
        }
        for (String format : Doot.formats) {
            try {
                this.dateend = LocalDate.from(LocalDate.parse(end, DateTimeFormatter.ofPattern(format)).atStartOfDay());
            } catch (DateTimeParseException ignored) {
            }
        }
    }

    @Override
    public String getType() {
        return "[" +type.name() +"]";
    }

    @Override
    public String getDetails() {
        return this.getType() + this.getStatusIcon() + " " + this.getDescription() + " (from: " + getStart() + " to: " + getEnd() + ")";
    }

    public String getStart() {
        return !(datestart == null) ? datestart.format(DateTimeFormatter.ofPattern("dd MMM, yyyy")) : start;
    }

    public String getEnd() {
        return !(dateend == null) ? dateend.format(DateTimeFormatter.ofPattern("dd MMM, yyyy")) : end;
    }

    @Override
    public String creationString() {
        StringBuilder list = new StringBuilder();
        if (this.isDone) {
            list.append("d ");
        }
        list.append("event ").append(this.getDescription()).append(" /from ").append(start).append(" /to ").append(end);

        return list.toString();
    }
}

