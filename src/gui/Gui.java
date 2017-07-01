/**
 *
 *  CITY MANAGER 1.0 June 26, 2017.
 *  Pratical Project by Paradigms and Programming Languages
 *  GCC198 - Federal University of Lavras (UFLA)
 *
 *  @author Lucas Fonseca dos Santos
 *  @author Leticia Ferreira
 */
package gui;

import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class Gui {

    private Scanner scanner;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public Gui() {
        scanner = new Scanner(System.in);
    }

    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
     } 

    public static void pressToContinue() {
        System.out.println("[#] Press any key to continue...");
        try { 
            System.in.read();
        }catch(IOException ex) {
            //The famous try-catch shut up, rs.
        }
    }

    public String callMenu(){
        clear();
        System.out.println("+==================================================+");
        System.out.println("+                                                  +");
        System.out.println("+           CITY MANAGER SYSTEM v1.0               +");
        System.out.println("+                                                  +");
        System.out.println("+==================================================+");
        System.out.println("+                                                  +");
        System.out.println("+ What do you want here?                           +");
        System.out.println("+ [1] Add a new city;                              +");
        System.out.println("+ [2] Remove a city;                               +");
        System.out.println("+ [3] Load all registereds citys;                  +");
        System.out.println("+ [4] Edit a city;                                 +");
        System.out.println("+ [5] Enter a city to manager it;                  +");
        System.out.println("+ [6] Print out;                                   +");
        System.out.println("+                                                  +");
        System.out.println("+ [-99] EXIT                                       +");
        System.out.println("+                                                  +");
        System.out.println("+==================================================+");
        System.out.print("[#] ENTER YOUR OPTION: ");
        try {
            return scanner.nextLine();
        }catch(NumberFormatException nfe) {
            nfe.printStackTrace();
            return "-99";
        }
    }

    /**
     * This method is reponsible for shows informations 
     * to the user to registering a new city 
     * on system data. He can add how many citys the user
     * wants.
     * 
     * @return List<String> New citys registered.
     */
    public List<String> createCityInformations() {
        List<String> informations = new ArrayList<String>();
        String option = "y";
        do {
            clear();
            System.out.println(ANSI_GREEN+"+--------------------------------------------------+"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"+ REGISTER A NEW CITY                              +"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"+--------------------------------------------------+"+ANSI_RESET);
            System.out.println(ANSI_YELLOW+"[!] The neighborhoods will be add after this process;"+ANSI_RESET);
            System.out.print(ANSI_WHITE+"[#] City Name: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] State/District: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] Country: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] Current Mayor: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] Do you want to register a new city [Y/n]?"+ANSI_RESET);
            option = scanner.nextLine().toLowerCase();
        }while(option.equals("y"));
        pressToContinue();
        return informations;
    }

}