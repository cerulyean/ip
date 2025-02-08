package doot;

import java.util.Scanner;

import static doot.Logo.LOGO;


public class Doot {
    static String[] formats = {
            "yyyy-MM-dd",          // Example: 2019-10-15
            "d/M/yyyy",            // Example: 2/12/2019
    };

    //Exception for when the format is invalid
    public static class InvalidFormatException extends Exception {
        public InvalidFormatException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("________________________________________________________________________________________________________________________\n" +
                "hello im \n" +
                LOGO + "\n________________________________________________________________________________________________________________________\n" );
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
