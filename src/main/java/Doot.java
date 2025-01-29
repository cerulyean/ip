import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class Doot {
    static String[] formats = {
            "yyyy-MM-dd",          // Example: 2019-10-15
            "d/M/yyyy",            // Example: 2/12/2019
    };
    public static class InvalidFormatException extends Exception {
        public InvalidFormatException(String message) {
            super(message);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logo = """
                                                                                                                                                 \s
                                                                                                                                                 \s
                                                                                                                                                 \s
                                         .:::::..                                                                                                \s
                                      .-*########*+-..                                                                                           \s
                                   .-#####%%%%%%%######+:.                                                                                       \s
                                .:+####%%%%%%%%%%%%%####**+=-..                                                                                  \s
                             ..=*####%%%%%%%%%%%%%%%%%###**++=-.                                                                                 \s
                           .:+**####%%%%%%%%%%@@%%%%%%%###**++==:                                                                                \s
                          .=++****###%%%%%%%%%@@@%%%%%%%%##**++==-.                                                                              \s
                          :=+++****###%%%%%%@%%%%@%%%%%%%%##*+++==-.                                                                             \s
                         .-++++++****###%%%%%%%%%%%%%%%%%%%##*+++==-:                                                                            \s
                         .==++++++++***##%%%%%%%%%%%%%%%%%%##**++==--:.                                                                          \s
                         :========++++**##%%%%%%%%%%%%%%%%###**++==---:.                                                                         \s
                         :===--======++**###%%%%%%%%%%%%%###***+===----.                                                                         \s
                         .---------===+++**##%%%%%%%%%%###*****+===-----.                                                                        \s
                         .:---::::---==+++**##%%%%%%%###****+++++==------.                                                                       \s
                         .:-::::::::---==++**#%%%%@%%%#***+++++++=------:..                                                                      \s
                          .:::::...:::--===+**#%%%%%%%##*++++++++=---::::..                                                                      \s
                          .:::.......::---===+*#%%%###***++++=====-:.......                                                                      \s
                          .-==-:......:::----==+*#*++======---=----....::.                                                                       \s
                           .:-=+=-......:::----+##+==----:::.:==--:... .+.                                                                       \s
                            ..:-++-:.....:::---+##+=-::....:::+=:::. ...+                                                                        \s
                             ...:=*=:.......::-=#*=:..     .:-*+...-=.-+..                                                                       \s
                                ...-=++=:......=*+-:.      ..-*+...:+*+:..                                                                       \s
                                  .==.:-=**+=--===--.     .-=+*=.:::....  .                                                                      \s
                                    .  ..:-=-+#*=-=*+:..:*%=*#*:...=.                                                                            \s
                                       .:::..-**+=--+*#%%%++=+=.  .-:                                                                            \s
                                       .:::-+=-::::.. ....:-==-...+*.                                                                            \s
                                        .::-=+++-:-::....:-==--##+*-.                                                                            \s
                                        .::---==:.:=+*#***++++**#*=-:.                                                                           \s
                                         .:::----..:--==++++++++==-::                                                                            \s
                                          ....::-=:===++--===+==--:...                          .:                                               \s
                                             ...:-+=--==-:.......:-=-..                        .-=.                                              \s
                                               ...:----:::------:....::...                .:. ..-...                                             \s
                                                   ..:--==========-:  ..--:.........   ...:=. .:=.     :=..                                      \s
                                                      ..:-=======:..    ..:=+=-:.::--:.:-.--  .-=.    :+...                                      \s
                                                                            .--**:...---:.=-..:=:   .:*.                                         \s
                                                                           .-=...-++-..:::+=:::=.   .+:     .:.                                  \s
                                                                           .=*.    .:=+=:.=--:==-...--.    .*-.                                  \s
                                                                           .:%-.      :--+#-.-%=+***#:    .*.                                    \s
                                                                           . -=--:....:..+#-+=%..:=*#*#+:.*:                                     \s
                                                                           ..:*=------+=--*-:.*:-::==-=+==+=:..                                  \s
                                                                           ....:---==-+=-:--=:*:..---:.:+==***+=:.                               \s
                                                                                 .:*#:+----=-%#..=.--:---::-==+****=..                           \s
                                                                                 .:=--=+--#*--#--:*#-...:-*-:::==+****+-:.           ......      \s
                                                                                 ....:-==-+#-#*::-%+:.-:-...-++-.:-=++****+-..  ...:::...::.     \s
                                                                                    .:+*+-=#=#*--=@-:-##:  .:.=#*...:-==++***++=-:-....:::::     \s
                                                                                       :*+-*=**:-*#--+%---:....-*=.....:-===++====------=--:.    \s
                                                                                        :#====+ .+--=#=-:.:-+:..==..   ...:----=++=======--.     \s
                                                                                         :#==-= :=..++-----:=+:.=-...     ..-:-#@%#*+++===-.     \s
                                                                                          -+---.::.:=...-+-:::.-=:...       ..=**@%**#*+==.      \s
                                                                                          .:---:-..-:    ..-+=--:.. .        :=++****++*=.       \s
                                                                                          .:=*#%%%+:.       .....           .:-=++**+++-.        \s
                                                                                          .:-----+*@=.        ..             :-+++*+==:.         \s
                                                                                           .-=****+-.                        .:-====:. .         \s
                                                                                             ..::..                           ......             \s
                                                                                                .                                                \s
                                                                                                                                                 \s
                                                                                                                                                 \s
                ==========+*+====*#####+#%%%%@%@@@@%#*-::+%@@@@@@@@@@@%@%#++=+*#@%@@@@@@@@@@@@#+=#%%#%##@@@@@@@@@@@%@@@@@@@@@@@##%#%%#+=========--
                =========+**+======#@@@@@@@@@@@@@@@@@@@*@@@@@@@@@@@@@@@@@%%*=#%#@@@@@@@@@@@@@@@@+==#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#+=========----
                ========++++=======+@@@@@@@@@@@@@@@@@@@#@@@@@@@@@@@@@@@@@@@@*@@@@@@@@@@@@@@@@@@@+====+@@@@@@@@@@@@@@@@@@@@@@@@@@@*========--------
                ========++=========+@@@@@@@@%@@@@@@@@@@#@@@@@@@@@@@@@@@@@@@@*@@@@@@@@@@@@@@@@@@@*=======#@@%%@@@@@@@@@@@@@%#@@%+======+=-=--==----
                ===================+@@@@@@%#**#%@@@@@@@#@@@@@@@@***#%@@@@@@@#@@@@@@@#*##%@@@@@@@*=======+++**##%@@@@@@@%****+====:::-=--:---=-----
                ===================*@@@@@@@-:-=+@@@@@@@#@@@@@@@@:::+*@@@@@@@#@@@@@@%+===*@@@@@@@*====+++++==+*+*@@@@@@@*=======-::::::::::::-::--=
                ===================#@@@@@@@-:-=+@@@@@@@#@@@@@@@%:::-#@@@@@@@#@@@@@@%++++*%@@@@@@*+==++++++=++=+*@@@@@@@*=====+-::::--:::::::------
                ===================%@@@@@@@-:=++@@@@@@@#@@@@@@@@::::*@@@@@@@#@@@@@@%+===*@@@@@@@*==+***+++**=--+@@@@@@@+------:::---:::::---------
                ==================+%@@@@@@@-=+++@@@@@@@%@@@@@@@@::::=@@@@@@@#@@@@@@%+=++*@@@@@@@*++###****#+=--=@@@@@@@+::::--:::--::-:-----------
                ==================+%@@@@@@@-*+=+@@@@@@@#@@@@@@@@::::=@@@@@@@#@@@@@@@++++*@@@@@@@#*####*+*#*===:=@@@@@@@+:::::::::-::-:------------
                ==================+#@@@@@@@+*==+@@@@@@@#@@@@@@@%::::=@@@@@@@#@@@@@@@*+++*@@@@@@@*++###*#+++=-=-=@@@@@@@+:::::::::-::--------------
                ===================*@@@@@@@*++==@@@@@@@%@@@@@@@@::::=@@@@@@@%@@@@@@@**++*@@@@@@@*-+***+=+==--=:=@@@@@@@*:::::--::-:::---:::::---=-
                ===================#@@@@@@@*++=+@@@@@@@%@@@@@@@%:-::=@@@@@@@#@@@@@@@#***#@@@@@@@#*===---==-----=@@@@@@@+:::::.:::-::::--::::::----
                ==================+#@@@@@@@*+==+@@@@@@@%@@@@@@@@-:::-%@@@@@@#@@@@@%%***+#@@@@@@@*=--===-=------*@@@@@@@*:::::::::::::::::-:::::--:
                ==================**@@@@@@@*=*@@@@@@@@@%@@@@@@@@@%=:-@@@@@@@#@@@@@@@#*%@@@@@@@@@*===-======----*@@@@@@@*::::::::::---:::::::::::::
                ++=======++======*=+@@@@@@@%@@@@@@@@@@@%@@@@@@@@@@@@%@@@@@@@#@@@@@@@@@@@@@@@@@@@*--=+======::::+@@@@@@@*:::::::-----=----:::::::::
                =+======+++++++**+=+@@@@@@@@@@@@@@@@@@@#+#%@@%@@@@@@@@@@@@@@#@@@@@@@@@@@@@%@@@%==---+=---==::::+@@@@@@@*:::::..::::-::-::-::::----
                ========+++***+===-=@@@@@@@@@@@@@@@@@**+-::=#@@@@@@@@@@@@@@@#@@@@@@@@@@@@@@@*------=++-===-::::+@@@@@@@+:..::::::::::::::--:----==
                ++++++=+++**+====-:-@@@@@@@@@@@@@@@#=-:::::::-*@@@@@@@@@@@@%#@@@@@@@@@@@@%+----=--=+++=-===::::=@@@#@@@+::::::::::::::::--==----=+
                +*+++++++#+=-==-:::-%@@@@@@@@@@@#-:::::::::::-+*#@@@@@@@@####++%@@@@@@@%+==---====++++==--==:::=*-::::*+:::::::----::::::==+---==+
                ********#+==+=:::::=#@@@@@%@@@+--:::-+*##**********#%#*######+=++++##++=====+=+++=+==========-::::::::::::::::--::--:::::-++=----=                                                                                                                                 \s""";
        System.out.println("________________________________________________________________________________________________________________________\n" +
                "hello im \n" +
                logo + "\n________________________________________________________________________________________________________________________\n" );
        String userInput = "hi";
        TaskList list = new TaskList();
        list = Storage.loadList("data/list.txt");

        Parser parser = new Parser(list);


        while (!(userInput = scanner.nextLine()).equals("bye")) {
            parser.handleCommand(userInput);
        }

        System.out.println("________________________________________________________________________________________________________________________\n" +
                "thank mr skeltal\n" +
                "________________________________________________________________________________________________________________________\n");

    }

    public static class  UI {
        public static void showMessage(String message) {
            System.out.println("________________________________________________________________________________________________________________________\n" +
                    message +
                    "\n________________________________________________________________________________________________________________________\n");        }
    }

    public static class Parser {
        private TaskList list;

        public Parser(TaskList list) {
            this.list = list;
        }

        public void handleCommand(String userInput) {
            if (userInput.isEmpty()) {
                UI.showMessage("say something I'm giving up on you");
            } else if (userInput.equals("thank mr skeltal")) {
                UI.showMessage("good bones and calcium will come to you");
            } else if (userInput.equals("doot doot")) {
                UI.showMessage("doot doot");
            } else if (userInput.equals("list")) {
                UI.showMessage(list.returnList());
            } else if (Parser.isMark(userInput)) {
                handleMark(userInput);
            } else if (Parser.isUnMark(userInput)) {
                handleUnMark(userInput);
            } else if (userInput.startsWith("delete ")) {
                handleDelete(userInput);
            } else if (userInput.equals("listData")) {
                UI.showMessage(list.listData());
            } else if (userInput.equals("savedata")) {
                saveList();
            } else {
                addTask(userInput);
            }
        }

        private void handleMark(String userInput) {
            int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
            if (isValidIndex(index)) {
                list.mark(index);
                UI.showMessage("doot doot\n\n" + list.returnList());
                saveList();
            }
        }

        private void handleUnMark(String userInput) {
            int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
            if (isValidIndex(index)) {
                list.unMark(index);
                UI.showMessage("noot noot\n\n" + list.returnList());
                saveList();
            }
        }

        private void handleDelete(String userInput) {
            int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
            if (isValidIndex(index)) {
                Task removed = list.getTask(index);
                list.removeTask(index);
                UI.showMessage("calcium for you\n   removed " + removed.getDetails() + "\n" + list.size() + " more to do\n");
                saveList();
            }
        }

        private void addTask(String userInput) {
            try {
                list.addTask(userInput);
                saveList();
            } catch (InvalidFormatException e) {
                UI.showMessage(e.toString());
            }
        }

        private void saveList() {
            try {
                Storage.saveList(list);
            } catch (IOException e) {
                UI.showMessage(e.toString());
            }
        }

        private boolean isValidIndex(int index) {
            return index >= 0 && index < list.size();
        }

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
    }

    public static class TaskList {
        private List<Task> arr;
        public TaskList() {
            arr = new ArrayList<>();
        }

        public void addTask(String str) throws InvalidFormatException {
            Task task = Task.makeTask(str);
            arr.add(task);
            UI.showMessage("task added\n   " + task.getDetails() + "\nyou now have " + arr.size() + " tasks in the list");
        }

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

        public String returnList() {
            int count = 1;
            StringBuilder list = new StringBuilder();
            for (Task task : arr) {
                list.append(count).append(". ").append(task.getDetails()).append("\n");
                count ++;
            }
            return list.toString().trim();
        }

        public String listData() {
            StringBuilder list = new StringBuilder();
            for (Task task : arr) {
                list.append(task.creationString()).append("\n");
            }
            return list.toString().trim();
        }

        public int size() {
            return arr.size();
        }

        public void mark(int num) {
            arr.get(num).setDone();
        }

        public void unMark(int num) {
            arr.get(num).setUndone();
        }

        public Task getTask(int num) {
            return arr.get(num);
        }

        public void removeTask(int num) {
            arr.remove(num);
        }

        public void loadTasks(Scanner s) throws FileNotFoundException {
            while (s.hasNext()) {

            }
        }

    }

    public enum Type {T, D, E}

    public abstract static class Task {
        protected String description;
        protected boolean isDone;

        protected Type type;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public static Task makeTask(String str) throws InvalidFormatException{
            String taskDescription = str.substring(str.indexOf(" ") + 1).trim();
            if (taskDescription.isEmpty()) {
                throw new InvalidFormatException("tasj must have description at back nothing added doot doot");
            }

            if (str.startsWith("todo ")) {
                return new todoTask(str.substring(str.indexOf(" ") + 1));
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

        public abstract String getType();

        public abstract String creationString();

        public String getDetails() {
            return this.getStatusIcon() + " " + this.getDescription();
        }

        public String getStatusIcon() {
            return "[" + (isDone ? "X" : " ") + "]"; // mark done task with X
        }

        public String getDescription() {
            return description;
        }

        public void setDone() {
            this.isDone = true;
        }

        public void setUndone() {
            this.isDone = false;
        }
    }

    public static class todoTask extends Task {
        public todoTask(String description) {
            super(description);
            type = Type.T;
        }
        @Override
        public String getType() {
            return "[" +type.name() +"]";
        }

        @Override
        public String getDetails() {
            return this.getType() + this.getStatusIcon() + " " + this.getDescription();
        }

        @Override
        public String creationString() {
            StringBuilder list = new StringBuilder();
            if (this.isDone) {
                list.append("d ");
            }
            list.append("todo ").append(this.getDescription());

            return list.toString();
        }
    }

    public static class DeadlineTask extends Task {
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
    public static class EventTask extends Task {
        protected String start;
        protected String end;

        protected LocalDate datestart;

        protected LocalDate dateend;

        public EventTask(String description, String start, String end) {
            super(description);
            this.type = Type.E;
            this.start = start;
            this.end = end;



            for (String format : formats) {
                try {
                    this.datestart = LocalDate.from(LocalDate.parse(start, DateTimeFormatter.ofPattern(format)).atStartOfDay());
                } catch (DateTimeParseException ignored) {
                }
            }
            for (String format : formats) {
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

    public static class Storage {
        public static void saveList(TaskList list) throws IOException {
            File folder = new File("data");
            if (!folder.exists()) {
                if (!folder.mkdirs()) {
                    throw new IOException("folder creation broke");
                }
            }
            File f = new File("data/list.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter("data/list.txt");
            fw.write(list.listData());
            fw.close();
        }
        
        public static TaskList loadList(String path) {
            File f = new File(path);
            TaskList list = new TaskList();
            if (f.exists()) {
                try {
                    list.loadTask(f);
                    UI.showMessage(list.returnList());
                } catch (FileNotFoundException e) {
                    UI.showMessage("this should never be seen");
                } catch (InvalidFormatException e) {
                    UI.showMessage("file corrupted, go see if theres anything salvagable because upon next list mod its all going to be overwritten");
                }
            }
            return list;
        }
    }
}
