package doot;
import static doot.Logo.LOGO;

import java.util.Scanner;


/**
 * Main Class for the Doot program
 */
public class Doot {
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
}
