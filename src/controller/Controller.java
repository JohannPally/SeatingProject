package controller;

import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    //not really a controller right now but will do the job
    //did you mean 'autocorrect' and then y/n and then repeat prompt if no, act if y

    //use Scanner and also demand that the first argument be a valid command, and then can take more commands in the
    //proper sequence but reject in the right moment if the argument guessed was the wrong type and autocorrect/retry
    //the fail

    //also split and trim at the same time when using Scanner.nextLine()

    public static void helpMessage(Scanner in, String [] comms){
        System.out.println("What argument would you like help with? Type \'exit\' when done.");
        System.out.println("------ \n quit \n help\n------");
        boolean flag = true;
        while (flag) {
            String s = in.nextLine();
            switch (s){
                case "quit":
                    System.out.println("*****\nThe \'quit\' command stops the overall program. Enter \'quit\' while the Assistant \nis in it's base state of \"Please enter a valid command:\" to quit the program.\n*****");
                    break;
                case "exit":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid argument \'"+s+"\'.");
            }
            System.out.println();
            System.out.println("Enter a listed valid command for help or type \'exit\' when done.");
        }
    }

    public static void main(String [] args){
        System.out.println("Seating Assistant ready...");
        Scanner in = new Scanner(System.in);
        boolean stop = true;
        while(stop){
            System.out.println("Please enter a valid command (press help to see valid command):");
            String s = in.nextLine();
            String [] commands = s.trim().split("\\s+");
            //TODO need to implement how inputting multiple command arguments would work
            //idea, iterate through the commands list, if new input after an invalid, then rest the commands list and index
            //keep going through the commands list and if out of bounds, do scanner.in so don't have to change much code
            //other than an if else statement for the s string for the switch case
            System.out.println(Arrays.toString(commands));
            switch (commands[0]){
                case "quit":
                    System.out.println("Shutting Down...");
                    stop = false;
                    break;
                case "help":
                    helpMessage(in, commands);
                    break;
                case "add":

                default:
                    System.out.println("Invalid argument: \'"+s+"\'");
            }
            System.out.println("====================================");
            System.out.println();
        }
    }
}
