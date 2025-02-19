package doot;
import static doot.Logo.LOGO;

import java.io.IOException;
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
        System.out.println(javafx.scene.text.Font.getFamilies());
        Scanner scanner = new Scanner(System.in);
        System.out.println("________________________________________________________________________________________________________________________\n"
                + "hello im \n"
                + LOGO + "\n________________________________________________________________________________________________________________________\n");
        String userInput;
        TaskList list;
        list = Storage.loadList("data/list.txt");

        Parser parser = new Parser(list);


        while (!(userInput = scanner.nextLine()).equals("bye")) {
            try {
                parser.handleCommand(userInput);
            } catch (IOException | InvalidFormatException e) {
                System.out.println(e);
            }
        }

        System.out.println("""
                ________________________________________________________________________________________________________________________
                thank mr skeltal
                ________________________________________________________________________________________________________________________
                """);

    }

    public String getResponse(String input) throws IOException, InvalidFormatException {
        return parser.handleCommand(input);
    }

    public String getIntro() {
        return "Take it easy!";
    }
}
