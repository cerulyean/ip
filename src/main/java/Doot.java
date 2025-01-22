import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Doot {

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
        ListMaster list = new ListMaster();


        while (!userInput.equals("bye")) {
            userInput = scanner.nextLine();
            if (userInput.isEmpty()) {
                Helper.makeLines("say someting im giving up on you");
            } else if (userInput.equals("thank mr skeltal")) {
                Helper.makeLines("good bones and calcium will come to you");
            } else if (userInput.equals("doot doot")) {
                Helper.makeLines("doot doot");
            } else if (userInput.equals("list")) {
                Helper.makeLines(list.returnList());
            } else if (Helper.isMark(userInput) && list.size() >= Integer.parseInt(userInput.split(" ")[1]) && Integer.parseInt(userInput.split(" ")[1]) >= 1) {
                list.mark(Integer.parseInt(userInput.split(" ")[1]) - 1);
                Helper.makeLines("doot doot\n\n" + list.returnList());
            } else if (Helper.isUnMark(userInput) && list.size() >= Integer.parseInt(userInput.split(" ")[1]) && Integer.parseInt(userInput.split(" ")[1]) >= 1) {
                list.unMark(Integer.parseInt(userInput.split(" ")[1]) - 1);
                Helper.makeLines("noot noot\n\n" + list.returnList());
            } else if (!userInput.equals("bye")) {
                try {
                    list.addString(userInput);
                } catch(InvalidFormatException e) {
                    Helper.makeLines(String.valueOf(e));
                }
            }
        }

        System.out.println("________________________________________________________________________________________________________________________\n" +
                //"May your bones be many and your fractures few, with doots that are plentiful and true.\n" +
                "thank mr skeltal\n" +
                "________________________________________________________________________________________________________________________\n");

    }

    public static class ListMaster {
        private List<Task> arr;
        public ListMaster() {
            arr = new ArrayList<>();
        }

        public void addString(String str) throws InvalidFormatException {
            Task task = Helper.makeTask(str);
            arr.add(task);
            Helper.makeLines("task added\n   " + task.getDetails() + "\nyou now have " + arr.size() + " tasks in the list");
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

        public int size() {
            return arr.size();
        }

        public void mark(int num) {
            arr.get(num).setDone();
        }

        public void unMark(int num) {
            arr.get(num).setUndone();
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

        public abstract String getType();

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
    }

    public static class DeadlineTask extends Task {

        protected String deadline;
        public DeadlineTask(String description, String deadline) {
            super(description);
            this.type = Type.D;
            this.deadline = deadline;
        }

        @Override
        public String getType() {
            return "[" +type.name() +"]";
        }

        @Override
        public String getDetails() {
            return this.getType() + this.getStatusIcon() + " " + this.getDescription() + " (by: " + deadline + ")";
        }
    }
    public static class EventTask extends Task {
        protected String start;
        protected String end;

        public EventTask(String description, String start, String end) {
            super(description);
            this.type = Type.E;
            this.start = start;
            this.end = end;
        }

        @Override
        public String getType() {
            return "[" +type.name() +"]";
        }

        @Override
        public String getDetails() {
            return this.getType() + this.getStatusIcon() + " " + this.getDescription() + " (from: " + start + " to: " + end + ")";
        }
    }

    public static class Helper {
        //this and the next method are used to check if a string starts with mark/unmark, then followed by an integer
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

        public static void makeLines(String str) {
            System.out.println("________________________________________________________________________________________________________________________\n" +
                    str +
                    "\n________________________________________________________________________________________________________________________\n");
        }

        public static boolean isTask(String str) {
            str = str.split(" ")[0];
            return str.equals("deadline") || str.equals("todo") || str.equals("event");
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
    }
}
