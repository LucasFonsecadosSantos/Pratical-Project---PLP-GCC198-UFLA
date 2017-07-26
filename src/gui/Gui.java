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
     * Console divider string line attribute;
     */
    private static final String divider = ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET;

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
        System.out.println(ANSI_YELLOW+"[#] Press any key to continue..."+ANSI_RESET);
        try { 
            System.in.read();
        }catch(IOException ex) {
            //The famous try-catch shut up, rs.
        }
    }

    /**
     * ANSI_RESET attribute accessor method.
     * 
     * @return String A string constant
     */
    public static String divider() {
        return divider;
    }

    /**
     * ANSI_GREEN attribute accessor method.
     * 
     * @return String A string constant
     */
    public static String getGreen() {
        return ANSI_GREEN;
    }

    /**
     * ANSI_GREEN attribute accessor method.
     * 
     * @return String A string constant
     */
    public static String getRed() {
        return ANSI_RED;
    }

    /**
     * ANSI_RESET attribute accessor method.
     * 
     * @return String A string constant
     */
    public static String getReset() {
        return ANSI_RESET;
    }
    /**
     * This method shows and captures all informations to execute
     * the system. He is called when the system is started.
     * 
     * @return String Option chosen by the user.
     */
    public String callMenu(){
        clear();
        System.out.println(ANSI_WHITE+"+==================================================+"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+                                                  +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+           "+ANSI_CYAN+"CITY MANAGER SYSTEM v1.0"+ANSI_WHITE+"               +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+                                                  +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+==================================================+"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+                                                  +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ "+ANSI_YELLOW+"What do you want here?"+ANSI_WHITE+"                           +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [1] "+ANSI_GREEN+"Add a new city;"+ANSI_WHITE+"                              +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [2] "+ANSI_GREEN+"Remove a city;"+ANSI_WHITE+"                               +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [3] "+ANSI_GREEN+"Load all registereds citys;"+ANSI_WHITE+"                  +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [4] "+ANSI_GREEN+"Edit a city;"+ANSI_WHITE+"                                 +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [5] "+ANSI_GREEN+"Enter a city to manager it;"+ANSI_WHITE+"                  +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [6] "+ANSI_GREEN+"Search a City;"+ANSI_WHITE+"                               +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [7] "+ANSI_GREEN+"Search a Neighborhood;"+ANSI_WHITE+"                       +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [8] "+ANSI_GREEN+"Generate statistics;"+ANSI_WHITE+"                         +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [9] "+ANSI_GREEN+"Delete Data Files;"+ANSI_WHITE+"                           +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+                                                  +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+ [-99] "+ANSI_RED+"EXIT"+ANSI_WHITE+"                                       +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+                                                  +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+==================================================+"+ANSI_RESET);
        System.out.print(formattedAsk("[#] ENTER YOUR OPTION: "));
        try {
            return scanner.nextLine();
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return "530";
        }catch (Exception e) {
            e.printStackTrace();
            return "530";
        }
    }

    /**
     * This method shows to the user, informations for the navigation at the city
     * manager module system and after this, captures the user operation choosen.
     * 
     * @return String The option choosen by the user.
     * @param city A city object to edit.
     */
    public String callCityManager(City city) {
        clear();
        System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
        System.out.println(city.getName().toUpperCase());
        System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+                                                  +"+ANSI_RESET);
        System.out.println("+ What do you want with this city?                 +");
        System.out.println("+ [1] Show city informations;                      +");
        System.out.println("+ [2] Add a new neighborhood;                      +");
        System.out.println("+ [3] Remove a neighborhood;                       +");
        System.out.println("+ [4] Edit a neighborhood;                         +");
        System.out.println("+ [5] Generate statistcs report file               +");
        System.out.println(ANSI_WHITE+"+                                                  +"+ANSI_RESET);
        System.out.println("+ [-99] Back to main menu                          +");
        System.out.println(ANSI_WHITE+"+                                                  +"+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
        System.out.print(formattedAsk("[#] ENTER YOUR OPTION: "));
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
     * @return List New citys registered.
     */
    public List<City> createCityInformations() {
        List<City> newCities = new ArrayList<City>();
        String option = "y";
        String[] informations = new String[4];
        do {
            header("registered a new city", formattedInformation("[!] the neighborhoods will be add after this process;"));
            System.out.print(formattedAsk("[#] CITY NAME: "));
            informations[0] = scanner.nextLine();
            System.out.print(formattedAsk("[#] STATE/PROVINCE/DISTRICT: "));
            informations[1] = scanner.nextLine();
            System.out.print(formattedAsk("[#] COUNTRY: "));
            informations[2] = scanner.nextLine();
            System.out.print(formattedAsk("[#] CURRENT MAYOR: "));
            informations[3] = scanner.nextLine();
            newCities.add(new City(informations[0], informations[1], informations[2], informations[3]));
            System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
            System.out.print(formattedAsk("[#] DO YOU WANT TO REGISTER A NEW CITY? [Y/n]? "));
            option = scanner.nextLine().toLowerCase();
        }while(option.equals("y"));
        pressToContinue();
        return newCities;
    }

    /**
     * This method receives a java list data structure city objects and
     * runs her, printing out the whole informations about the cities content
     * of this list.
     * 
     * @param cities A java city data strucuture list object.
     */
    public void showCitiesData(List<City> cities) {
        List<Neighborhood> neighborhoodList;
        header("registered cities informations", null);
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
            System.out.println();
        }
        pressToContinue();
    }

    /**
     * This method show all informations or attributes states of a city object,
     * received by the parameter.
     * 
     * @param c A city object.
     */
    public void showCitiesData(City c) {
        header("registered city informations", null);
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
        System.out.println(ANSI_WHITE+"\n++++++++++++++++++++++++++++++++++++++++++++++++++++\n"+ANSI_RESET);
        pressToContinue();
    }

    /**
     * This method is responsible for the data capture about the
     * city manager module operations.
     * 
     * @return String A string data city name.
     */
    public String captureCity() {
        header("welcome to the city manager", formattedAsk("[#] what is the city name: "));
        return scanner.nextLine();
    }

    /**
     * This method is responsible for the add neighborhood operation
     * for a city object. It shows and captures all neighborhoods attribute
     * states.
     * 
     * @return List A java string list data structure.
     */
    public List<String> addNewNeighborhoodInformations() {
        String option = "y";
        List<String> informations = new ArrayList<String>();
        do {
            header("register a new neighborhood", formattedInformation("[!] After that, the statistcs rates will be updated;"));
            System.out.print(formattedAsk("[#] NEIGHBORHOOD NAME: "));
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print(formattedAsk("[#] DEMOGRAPHIC RATE: "));
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print(formattedAsk("PER CAPTA INCOME RATE: "));
            informations.add(scanner.nextLine().toLowerCase());
            System.out.print(formattedAsk("[#] CRIME RATE: "));
            informations.add(scanner.nextLine().toLowerCase());
            System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
            System.out.print(formattedAsk("DO YOU WANT TO REGISTER A NEW NEIGHBORHOOD? [Y/n]? "));
            option = scanner.nextLine().toLowerCase();
        } while(option.equals("y"));
        pressToContinue();
        return informations;
    }

    /**
     * This method is responsible for shows informatios to the user delets
     * all database binary files. It is a simple message to confirm the action.
     * 
     * @return String Confirmation user response.
     */
    public String deleteDataFilesInformations() {
        header("delete all records", formattedInformation("[!] All your saved data in the system will be erased;"));
        System.out.println(formattedAsk("[#] do you want to continue [Y/n]: "));
        return scanner.nextLine().toLowerCase();
    }

    /**
     * This method captures the user entries to remove neighboorhod operation.
     * It asks the user if he is shure about this.
     * 
     * @return List A String java list data structure with all neighborhoods name.
     */
    public List<String> removeNeighborhoodInformations() {
        String option = "y";
        List<String> names = new ArrayList<String>();
        do {
            header("remove a neighborhoods", formattedInformation("Your saved data in the system will be erased;"));
            System.out.println(formattedAsk("[#] WHICH NEIGHBORHOOD DO YOU WANT TO REMOVE? TYPE THE  NEIGHBORHOOD NAME: "));
            names.add(scanner.nextLine());
            System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
            System.out.print(formattedAsk("[#] DO YOU WANT TO REMOVE MORE NEIGHBORHOODS? [Y/n]: "));
            option = scanner.nextLine().toLowerCase();
        }while (option.equals("y"));
        return names;
    }

    /**
     * This method captures informations to city settings change. It prints out 
     * all cities storage at the database system and captures the city name that user
     * wants to be edit.
     * 
     * @param citiesName A city java list data strucutre with all cities loaded.
     * @return String The city name wnats to remove.
     */
    public String editCityInformations(List<String> citiesName) {
        header("edit a city record", formattedInformation("[!] disponible cities to edit:"));
        int count = 0;
        for(String c : citiesName) {
            count++;
            System.out.println("["+count+"]: "+c.replace(".bin", "").toUpperCase()+ ";");
        }
        System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
        System.out.print(formattedAsk("WHICH CITY DO YOU WANT TO EDIT? [Type city name]: "));
        return scanner.nextLine().toLowerCase();
    }

    /**
     * This is an overloaded method. It shows informations or attribute states about a
     * city received by parameter and capture the user choosen about the city settings 
     * operation.
     * 
     * @param c A city object.
     * @return int The user choosen option.
     */
    public int editCityInformations(City c) {
        header("edit a city record", formattedInformation("informations about the city:"));
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
        System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
        System.out.println(formattedAsk("WHICH INFORMATION ABOUT THE "+c.getName()+" CITY?"));
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * This is an overloaded method. It receives a neighborhood list by parameter and 
     * prints out all names. After this, it asks the user about the neighborhood
     * name that him wants to be edit.
     * 
     * @return String A neighborhood name.
     * @param neighborhoods A neighborhoods java list data structure with all neighborhoods loaded.
     */
    public String editNeighborhoodInformations(List<Neighborhood> neighborhoods) {
        header("edit a neighborhood", formattedInformation("[!] disponible neighborhoods to edit:"));
        int count = 0;
        for(Neighborhood n : neighborhoods) {
            count++;
            System.out.println("["+count+"]: "+n.getName().toUpperCase()+ ";");
        }
        System.out.print(formattedAsk("WHICH NEIGHBORHOOD DO YOU WANT TO EDIT? [Type neighborhood name]: "));
        return scanner.nextLine().toLowerCase();
    }

    /**
     * This is an overloaded method. It receives a neighborhood by parameter
     * and prints out all informations or object city attributes states. After this,
     * it captures from the user, your choice.
     * 
     * @param n A neighborhood object.
     * @return int A integer user choice option.
     */
    public int editNeighborhoodInformations(Neighborhood n) {
        header("edit a city neighborhood", formattedInformation("[!] informations about the neighborhood"));
        System.out.println("[1] NEIGHBORHOOD NAME: "+n.getName());
        System.out.println("[3] DEMOGRAPHIC RATE: "+n.getDemographicRate());
        System.out.println("[4] PER CAPTA INCOME RATE: "+n.getPerCaptaIncome());
        System.out.println("[5] CRIME RATE: "+n.getCrimeRate());
        System.out.println(formattedAsk("WHICH INFORMATION ABOUT THE "+n.getName()+" CITY?"));
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    /**
     * This method prints out and captures informations to city search operation.
     * 
     * @return String City name that user wants to be search at the binary database files system.
     */
    public String searchCityInformations() {
        header("search a city at database", formattedAsk("which is the city name: "));
        try {
            return scanner.nextLine().toLowerCase().trim();
        }catch(NumberFormatException fe) {
            fe.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return ANSI_RED + "[!] CITY NOT FOUND!" + ANSI_RESET;
    }

    /**
     * This method is responsible for the captures all informations to search
     * a specific neighborhood at the system.
     * 
     * @return String A string neighborhood name.
     */
    public String searchNeighborhoodInformations() {
        header("search a neighborhood", formattedAsk("WHICH NEIGHBORHOOD DO YOU WANT TO SEARCH? [Type neighborhood name]: "));
        try {
            return scanner.nextLine().toLowerCase();
        }catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ANSI_RED + "[!] NEIGHBORHOOD NOT FOUND!" + ANSI_RESET;
    }

    public void header(String headerMsg, String subHeaderMsg) {
        clear();
        System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
        System.out.println(" "+ANSI_GREEN+headerMsg.toUpperCase()+ANSI_RESET);
        System.out.println(ANSI_WHITE+"+--------------------------------------------------+"+ANSI_RESET);
        if(subHeaderMsg != null) {
            System.out.print(subHeaderMsg.toUpperCase());
        }else {
            System.out.println("");
        }
    }

    public String formattedAsk(String message) {
        if(message.contains("[#]") || message.contains("[!]") || message.contains("\n")) {
            message = message.replace("[#]", "");
            message = message.replace("[!]", "");
            message = message.replace("\n", "");
        }
        return ANSI_YELLOW + "[#] "+message.toUpperCase() + ANSI_RESET;
    }

    public String formattedInformation(String message) {
        if(message.contains("[#]") || message.contains("[!]") || message.contains("\n")) {
            message = message.replace("[#]", "");
            message = message.replace("[!]", "");
            message = message.replace("\n", "");
        }
        return ANSI_BLUE + "[!] "+message.toUpperCase()+"\n" + ANSI_RESET;
    }
}