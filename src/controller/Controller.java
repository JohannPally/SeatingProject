package controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    //not really a controller right now but will do the job
    //did you mean 'autocorrect' and then y/n and then repeat prompt if no, act if y

    //use Scanner and also demand that the first argument be a valid command, and then can take more commands in the
    //proper sequence but reject in the right moment if the argument guessed was the wrong type and autocorrect/retry
    //the fail

    //also split and trim at the same time when using Scanner.nextLine()
    private static String equalLine = "==================================================================================";
    private static String periodLine = "..................................................................................";

    public static String [] trimSplitAndLower(String s){
        String [] arr = s.trim().split("\\s+");
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i].toLowerCase(Locale.ROOT);
        }
        return arr;
    }

    public static void helpMessage(Scanner in, String [] comms){
        String listComms = "------ \n quit \n------";
        System.out.println("The following are valid commands:");
        System.out.println(listComms);
        System.out.println();
        boolean flag = true;
        while (flag) {
            System.out.println("For help, enter a listed valid command or type \'cancel\' when finished. Type \'help\' to \nview list of valid commands again.");
            //TODO: think about how inner helper functions can utilize multiple argument inputs, need to make helper function for this
            String [] ins = trimSplitAndLower(in.nextLine());
            String s = ins[0];
            if(s.equals("cancel")){
                flag = false;
            }
            else {
                System.out.println();
                switch (s) {
                    case "quit":
                        System.out.println("*****\nThe \'quit\' command stops the overall program. Enter \'quit\' while the Assistant \nis in it's base state of \"Please enter a valid command:\" to quit the program.\n*****");
                        break;
                    case "help":
                        System.out.println(listComms);
                        break;
                    default:
                        System.out.println("Invalid command \'" + s + "\'.");
                }
                System.out.println();
            }
        }
    }

    public static void addMessage(Scanner in, String [] comms){
        int i = 1;
        System.out.println("Add Section or Table? (section/table)");
        boolean flag = true;
        while(flag){
            if(i < comms.length) {
                switch (comms[i]){
                    case "section":
                        flag = false;
                        System.out.println("\n* input: \'section\' *\n");
                        addSectionMessage(in, comms, i);
                        break;
                    case "table":
                        flag = false;
                        System.out.println("\n* input: \'table\' *\n");
                        addTableMessage(in, comms, i);
                        break;
                    case "cancel":
                        flag = false;
                        System.out.println("Cancelling...");
                        break;
                    default:
                        System.out.println("Invalid argument \'"+ comms[i] +"\'.");
                        comms = new String[0];
                        i = -1;
                        break;
                }
            }
            else {
                String s = in.nextLine();
                switch (s){
                    case "section":
                        flag = false;
                        addSectionMessage(in, comms, i);
                        break;
                    case "table":
                        flag = false;
                        addTableMessage(in, comms, i);
                        break;
                    case "cancel":
                        flag = false;
                        System.out.println("Cancelling...");
                        break;
                    default:
                        System.out.println("Invalid argument \'"+ comms[i] +"\'.");
                        break;
                }
            }
        }
    }

    public static void addSectionMessage(Scanner in, String [] comms, int i){
        System.out.println("sect message");
    }

    public static void addTableMessage(Scanner in, String [] comms, int i){
        System.out.println("tab message");
    }

    public static void main(String [] args){
        System.out.println("Seating Assistant initializing...");
        System.out.println();
        System.out.println(equalLine);
        Scanner in = new Scanner(System.in);
        boolean stop = true;
        while(stop){
            System.out.println("Enter a valid command (type 'help' to list):");
            String s = in.nextLine();
            System.out.println();
            String [] commands = trimSplitAndLower(s);

            //TODO need to implement how inputting multiple command arguments would work
            //idea, iterate through the commands list, if new input after an invalid, then rest the commands list and index
            //keep going through the commands list and if out of bounds, do scanner.in so don't have to change much code
            //other than an if else statement for the s string for the switch case

            //System.out.println(Arrays.toString(commands));
            switch (commands[0]){
                case "quit":
                    System.out.println("Shutting Down...");
                    stop = false;
                    break;
                case "help":
                    System.out.println(periodLine);
                    helpMessage(in, commands);
                    System.out.println(periodLine);
                    break;
                case "add": {
                    System.out.println(periodLine);
                    addMessage(in, commands);
                    System.out.println(periodLine);
                    break;
                }
                default:
                    System.out.println("Invalid command: \'" + s + "\'");
            }
            System.out.println();
        }
        System.out.println(equalLine);
    }
}
