package doot;
import static doot.Logo.LOGO;

import java.util.Scanner;


/**
 * Main Class for the Doot program
 */
public class Doot {
    public TaskList list;
    Parser parser;
    Scanner scanner;


    public Doot() {
        scanner = new Scanner(System.in);
        TaskList list;
        list = Storage.loadList("data/list.txt");
        parser = new Parser(list);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("________________________________________________________________________________________________________________________\n"
                + "hello im \n"
                + LOGO + "\n________________________________________________________________________________________________________________________\n");
        String userInput;
        TaskList list;
        list = Storage.loadList("data/list.txt");

        Parser parser = new Parser(list);


        while (!(userInput = scanner.nextLine()).equals("bye")) {
            parser.handleCommand(userInput);
        }

        System.out.println("""
                ________________________________________________________________________________________________________________________
                thank mr skeltal
                ________________________________________________________________________________________________________________________
                """);

    }

    public String getResponse(String input) {
        return parser.handleCommand(input);
    }

    public String getIntro() {
        return "hello im mr skeltal";
    }
}
