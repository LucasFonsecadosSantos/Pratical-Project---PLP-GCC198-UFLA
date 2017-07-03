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
import app.Neighborhood;
import app.City;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is reponsible to dialog between the system and 
 * the final user. He prints and loads screen information for
 * the system processing this.
 */
public class Gui {

    /**
     * Scanner java object attribute;
     */
    private Scanner scanner;

    /**
     * Reset terminal font color code attribute;
     */
    private static final String ANSI_RESET = "\u001B[0m";

    /**
     * Black terminal font color code attribute;
     */
    private static final String ANSI_BLACK = "\u001B[30m";
    
    /**
     * Red terminal font color code attribute;
     */
    private static final String ANSI_RED = "\u001B[31m";
    
    /**
     * Green terminal font color code attribute;
     */
    private static final String ANSI_GREEN = "\u001B[32m";
    
    /**
     * Yellow terminal font color code attribute;
     */
    private static final String ANSI_YELLOW = "\u001B[33m";
    
    /**
     * Blue terminal font color code attribute;
     */
    private static final String ANSI_BLUE = "\u001B[34m";
    
    /**
     * Purple terminal font color code attribute;
     */
    private static final String ANSI_PURPLE = "\u001B[35m";
    
    /**
     * Cyan terminal font color code attribute;
     */
    private static final String ANSI_CYAN = "\u001B[36m";
    
    /**
     * White terminal font color code attribute;
     */
    private static final String ANSI_WHITE = "\u001B[37m";
    
    /**
     * Background terminal black color code attribute;
     */
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    
    /**
     * Background terminal red color code attribute;
     */
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    
    /**
     * Background terminal green color code attribute;
     */
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    
    /**
     * Background terminal yellow color code attribute;
     */
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    
    /**
     * Background terminal blue color code attribute;
     */
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    
    /**
     * Background terminal purple color code attribute;
     */
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    
    /**
     * Background terminal cyan color code attribute;
     */
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    
    /**
     * Background terminal white color code attribute;
     */
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    /**
     * GUI object constructor. He instaces java scanner object
     * to capture the user inputs.
     */
    public Gui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Static method to clear the terminal console.
     */
    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
     }

     /**
     * Static method, responsible for says to the user
     * press any key to continue;
     */
    public static void pressToContinue() {
        System.out.println("[#] Press any key to continue...");
        try { 
            System.in.read();
        }catch(IOException ex) {
            //The famous try-catch shut up, rs.
        }
    }

    /**
     * This method shows and captures all informations to execute
     * the system. He is called when the system is started.
     * 
     * @return String Option chosen by the user.
     */
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
        System.out.println("+ [6] Search a City;                               +");
        System.out.println("+ [7] Search a Neighborhood;                       +");
        System.out.println("+ [8] Generate statistics;                         +");
        System.out.println("+ [9] Delete Data Files;                           +");
        System.out.println("+                                                  +");
        System.out.println("+ [-99] EXIT                                       +");
        System.out.println("+                                                  +");
        System.out.println("+==================================================+");
        System.out.print("[#] ENTER YOUR OPTION: ");
        try {
            return scanner.nextLine();
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return "-99";
        }catch (Exception e) {
            e.printStackTrace();
            return "-99";
        }
    }

    public String callCityManager(City city) {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println(city.getName());
        System.out.println("+--------------------------------------------------+");
        System.out.println("+                                                  +");
        System.out.println("+ What do you want with this city?                 +");
        System.out.println("+ [1] Show city informations;                      +");
        System.out.println("+ [2] Add a new neighborhood;                      +");
        System.out.println("+ [3] Remove a neighborhood;                       +");
        System.out.println("+ [4] Edit a neighborhood;                         +");
        System.out.println("+ [5] Generate statistcs report file               +");
        System.out.println("+                                                  +");
        System.out.println("+ [-99] Back to main menu                          +");
        System.out.println("+                                                  +");
        System.out.println("+--------------------------------------------------+");
        System.out.print("[#] ENTER YOUR OPTION: ");
        try {
            return scanner.nextLine();
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return "-99";
        }catch (Exception e) {
            e.printStackTrace();
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
            System.out.print(ANSI_WHITE+"[#] CITY NAME: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] STATE/PROVINCE/DISTRICT: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] COUNTRY: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] CURRENT MAYOR: "+ANSI_RESET);
            informations.add(scanner.nextLine());
            System.out.print(ANSI_WHITE+"[#] DO YOU WANT TO REGISTER A NEW CITY? [Y/n]?"+ANSI_RESET);
            option = scanner.nextLine().toLowerCase();
        }while(option.equals("y"));
        pressToContinue();
        return informations;
    }

    public void showCitiesData(List<City> cities) {
        clear();
        List<Neighborhood> neighborhoodList;
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ REGISTERED CITIES INFORMATIONS                   +");
        System.out.println("+--------------------------------------------------+");
        for(City c : cities) {
            System.out.println("\n+ CITY NAME: " +c.getName());
            System.out.println("+ STATE/DISTRICT: " +c.getDistrict());
            System.out.println("+ COUNTRY: " +c.getCountry());
            System.out.println("+ CURRENT MAYOR: " +c.getMayor());
            System.out.println("+ NEIGHBORHOODS: ");
            neighborhoodList = c.getNeighborhoods();
            if(neighborhoodList != null) {
                for(Neighborhood n : neighborhoodList) {
                    System.out.println(n.toString());
                }
            }
        }
        pressToContinue();
    }

    public void showCitiesData(City c) {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ REGISTERED CITY INFORMATIONS                     +");
        System.out.println("+--------------------------------------------------+");
        System.out.println("\n+ CITY NAME: " +c.getName());
        System.out.println("+ STATE/DISTRICT: " +c.getDistrict());
        System.out.println("+ COUNTRY: " +c.getCountry());
        System.out.println("+ CURRENT MAYOR: " +c.getMayor());
        System.out.println("+ DEMOGRAPHIC RATE: " + c.getDemographicRate());
        System.out.println("+ PER CAPTA INCOME RATE: " + c.getPerCaptaIncome());
        System.out.println("+ CRIME RATE: " + c.getCrimeRate());
        System.out.println("+ NEIGHBORHOODS: ");
        List<Neighborhood> neighborhoodList = c.getNeighborhoods();
        if(neighborhoodList != null) {
            for(Neighborhood n : neighborhoodList) {
                System.out.println(n.toString());
            }
        }
        pressToContinue();
    }
    public String captureCity() {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ WELCOME TO THE CITY MANAGER!                     +");
        System.out.println("+--------------------------------------------------+");
        System.out.print("[#] WHAT IS THE CITY NAME: ");
        return scanner.nextLine();
    }

    public List<String> addNewNeighborhoodInformations() {
        String option = "y";
        List<String> informations = new ArrayList<String>();
        do {
            clear();
            System.out.println("+--------------------------------------------------+");
            System.out.println("+ REGISTER A NEW NEIGHBORHOOD                      +");
            System.out.println("+--------------------------------------------------+");
            System.out.println(ANSI_YELLOW+"[!] After that, the statistcs rates will be updated;"+ANSI_RESET);
            System.out.print("[#] NEIGHBORHOOD NAME: ");
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print("[#] DEMOGRAPHIC RATE: ");
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print("[#] PER CAPTA INCOME RATE: ");
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print("[#] CRIME RATE: ");
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print(ANSI_WHITE+"[#] DO YOU WANT TO REGISTER A NEW NEIGHBORHOOD? [Y/n]?"+ANSI_RESET);
            option = scanner.nextLine().toLowerCase();
        } while(option.equals("y"));
        pressToContinue();
        return informations;
    }

    public String deleteDataFilesInformations() {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ DELETE ALL RECORDS                               +");
        System.out.println("+--------------------------------------------------+");
        System.out.println(ANSI_YELLOW+"[!] All your saved data in the system will be erased;"+ANSI_RESET);
        System.out.print("[#] DO YOU WANT TO CONTINUE [Y/n]: ");
        return scanner.nextLine().toLowerCase();
    }

    public List<String> removeNeighborhoodInformations() {
        String option = "y";
        List<String> names = new ArrayList<String>();
        do {
            clear();
            System.out.println("+--------------------------------------------------+");
            System.out.println("+ REMOVE A NEIGHBORHOODS                           +");
            System.out.println("+--------------------------------------------------+");
            System.out.println(ANSI_YELLOW+"[!] Your saved data in the system will be erased;"+ANSI_RESET);
            System.out.print("[#] WHICH NEIGHBORHOOD DO YOU WANT TO REMOVE? TYPE THE  NEIGHBORHOOD NAME: ");
            names.add(scanner.nextLine());
            System.out.println("[#] DO YOU WANT TO REMOVE MORE NEIGHBORHOODS? [Y/n]: ");
            option = scanner.nextLine().toLowerCase();
        }while (option.equals("y"));
        return names;
    }

    public String editCityInformations(List<String> citiesName) {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ EDIT A CITY RECORD                               +");
        System.out.println("+--------------------------------------------------+");
        System.out.println("[!] DISPONIBLE CITIES TO EDIT: ");
        int count = 0;
        for(String c : citiesName) {
            count++;
            System.out.println("["+count+"]: "+c.replace(".bin", "").toUpperCase()+ ";");
        }
        System.out.print("[#] WHICH CITY DO YOU WANT TO EDIT? [Type city name]: ");
        return scanner.nextLine().toLowerCase();
    }

    public int editCityInformations(City c) {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ EDIT A CITY RECORD                               +");
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ [!] INFORMATIONS ABOUT THE CITY:                 +");
        System.out.println("\n[1] CITY NAME: " +c.getName());
        System.out.println("[2] STATE/DISTRICT: " +c.getDistrict());
        System.out.println("[3] COUNTRY: " +c.getCountry());
        System.out.println("[4] CURRENT MAYOR: " +c.getMayor());
        System.out.println("[5] DEMOGRAPHIC RATE: " + c.getDemographicRate());
        System.out.println("[6] PER CAPTA INCOME RATE: " + c.getPerCaptaIncome());
        System.out.println("[7] CRIME RATE: " + c.getCrimeRate());
        System.out.println("[8] NEIGHBORHOODS: ");
        List<Neighborhood> neighborhoodList = c.getNeighborhoods();
        if(neighborhoodList != null) {
            for(Neighborhood n : neighborhoodList) {
                System.out.println(n.toString());
            }
        }
        System.out.println("[#] WHICH INFORMATION ABOUT THE "+c.getName()+" CITY?");
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String editNeighborhoodInformations(List<Neighborhood> neighborhoods) {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ EDIT A NEIGHBORHOOD                              +");
        System.out.println("+--------------------------------------------------+");
        System.out.println("[!] DISPONIBLE NEIGHBORHOODS TO EDIT: ");
        int count = 0;
        for(Neighborhood n : neighborhoods) {
            count++;
            System.out.println("["+count+"]: "+n.getName().toUpperCase()+ ";");
        }
        System.out.print("[#] WHICH NEIGHBORHOOD DO YOU WANT TO EDIT? [Type neighborhood name]: ");
        return scanner.nextLine().toLowerCase();
    }

    public int editNeighborhoodInformations(Neighborhood n) {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ EDIT A CITY NEIGHBORHOOD                         +");
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ [!] INFORMATIONS ABOUT THE NEIGHBORHOOD:         +");
        System.out.println("[1] NEIGHBORHOOD NAME: "+n.getName());
        System.out.println("[3] DEMOGRAPHIC RATE: "+n.getDemographicRate());
        System.out.println("[4] PER CAPTA INCOME RATE: "+n.getPerCaptaIncome());
        System.out.println("[5] CRIME RATE: "+n.getCrimeRate());
        System.out.println("[#] WHICH INFORMATION ABOUT THE "+n.getName()+" CITY?");
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String searchCityInformations() {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ SEARCH A CITY ON DATABASE                        +");
        System.out.println("+--------------------------------------------------+");
        System.out.print("[#] WHICH IS THE CITY NAME: ");
        try {
            return scanner.nextLine().toLowerCase().trim();
        }catch(NumberFormatException fe) {
            fe.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "[!] CITY NOT FOUND!";
    }

    public String searchNeighborhoodInformations() {
        clear();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ SEARCH A NEIGHBORHOOD                            +");
        System.out.println("+--------------------------------------------------+");
        System.out.print("[#] WHICH NEIGHBORHOOD DO YOU WANT TO SEARCH? [Type neighborhood name]: ");
        try {
            return scanner.nextLine().toLowerCase();
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "[!] NEIGHBORHOOD NOT FOUND!";
    }
}