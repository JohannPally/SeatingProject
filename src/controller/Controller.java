package controller;

import java.lang.reflect.Array;
import java.util.*;

public class Controller {
    //not really a controller right now but will do the job
    //did you mean 'autocorrect' and then y/n and then repeat prompt if no, act if y

    //use Scanner and also demand that the first argument be a valid command, and then can take more commands in the
    //proper sequence but reject in the right moment if the argument guessed was the wrong type and autocorrect/retry
    //the fail

    //TODO idea, colors for sections, also output tallies for table count

    //also split and trim at the same time when using Scanner.nextLine()
    private static String equalLine = "==================================================================================";
    private static String periodLine = "..................................................................................";

    public static ArrayList<String> trimToArrList(String s){
        String [] arr = s.trim().split("\\s+");
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i].toLowerCase(Locale.ROOT);
        }
        ArrayList<String> out = new ArrayList<String>();
        Collections.addAll(out, arr);
        return out;
    }

    public static void helpMessage(Scanner in, ArrayList<String> comms){
        String listComms = "------ \n quit \n------";
        System.out.println("The following are valid commands:");
        System.out.println(listComms);
        System.out.println();

        boolean flag = true;
        while (flag) {
            System.out.println("For help, enter a listed valid command or type \'cancel\' when finished. Type \'help\' to \nview list of valid commands again.");
            System.out.println();
            String arg;
            if(comms.size() == 0){
                String s = in.nextLine();
                ArrayList<String> temp  = trimToArrList(s);
                temp.addAll(comms);
                comms = temp;
                arg = comms.remove(0);
            }
            else {
                arg = comms.remove(0);
                System.out.println("* input * "+arg);
            }

            if(arg.equals("cancel")){
                flag = false;
            }
            else {
                System.out.println();
                switch (arg) {
                    case "quit":
                        System.out.println("*****\nThe \'quit\' command stops the overall program. Enter \'quit\' while the Assistant \nis in it's base state of \"Please enter a valid command:\" to quit the program.\n*****");
                        break;
                    case "help":
                        System.out.println(listComms);
                        break;
                    default:
                        System.out.println("Invalid command \'" + arg + "\'.");
                }
                System.out.println();
            }
        }
    }

/*
    public static void addMessage(Scanner in, ArrayList<String> comms){
        System.out.println("Add Section or Table? (section/table)");
        boolean flag = true;
        while(flag){
            if(comms != null) {
                //TODO change the helper functions from expecting an int and also add a String s for commands.remove(0);
                switch (comms.remove(0)){
                    case "section":
                        flag = false;
                        System.out.println("\n* input: \'section\' *\n");
                        addSectionMessage(in, comms);
                        break;
                    case "table":
                        flag = false;
                        System.out.println("\n* input: \'table\' *\n");
                        addTableMessage(in, comms);
                        break;
                    case "cancel":
                        flag = false;
                        System.out.println("Cancelling...");
                        break;
                    default:
                        System.out.println("Invalid argument \'"+ comms +"\'.");
                        comms = null;
                        i = -1;
                        break;
                }
            }
            else {
                String s = in.nextLine();
                switch (s){
                    case "section":
                        flag = false;
                        addSectionMessage(in, comms);
                        break;
                    case "table":
                        flag = false;
                        addTableMessage(in, comms);
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

    public static void addSectionMessage(Scanner in, ArrayList<String> comms){
        System.out.println("sect message");
    }

    public static void addTableMessage(Scanner in, ArrayList<String> comms){
        System.out.println("tab message");
    }
*/
    public static void main(String [] args){
        System.out.println("Seating Assistant initializing...");
        System.out.println();
        System.out.println(equalLine);
        Scanner in = new Scanner(System.in);
        boolean stop = true;

        ArrayList<String> comms = new ArrayList<String>();
        while(stop){
            System.out.println("Enter a valid command (type 'help' to list):");

            System.out.println();
            String arg;
            if(comms.size() == 0){
                String s = in.nextLine();
                ArrayList<String> temp  = trimToArrList(s);
                temp.addAll(comms);
                comms = temp;
                arg = comms.remove(0);
            }
            else {
                arg = comms.remove(0);
                System.out.println("* input * "+arg);
            }

            //System.out.println(Arrays.toString(commands));
            switch (arg){
                case "quit":
                    System.out.println("Shutting Down...");
                    stop = false;
                    break;
                case "help":
                    System.out.println(periodLine);
                    helpMessage(in, comms);
                    System.out.println(periodLine);
                    break;
                case "add": {
                    System.out.println(periodLine);
                    //addMessage(in, comms);
                    System.out.println(periodLine);
                    break;
                }
                case "test":
                    break;
                default:
                    System.out.println("Invalid command: \'" + arg + "\'");
                    //try the error argument helper?
                    comms = new ArrayList<>();
            }
            System.out.println();
        }
        System.out.println(equalLine);
    }

}
