/**
 *
 *  CITY MANAGER 1.0 June 26, 2017.
 *  Pratical Project by Paradigms and Programming Languages
 *  GCC198 - Federal University of Lavras (UFLA)
 *
 *  @author Lucas Fonseca dos Santos
 *  @author Leticia Ferreira
 */
package app;

import gui.Gui;
import util.Data;
import util.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class describes the core of city manager
 * system. He is responsible for all the executation
 * about the system operations.
 */
public class SystemManager {

    /**
     * GUI - Graphical user interface class attribute;
     */
    private Gui gui;

    /**
     * Data class attribute;
     */
    private Data data;

    /**
     * Logger class attribute;
     */
    private Logger logger;

    /**
     * Scanner class attribute;
     */
    private Scanner scanner;


    /**
     * SystemManager core object constructor.
     * He instances the gui, data, logger and scanner classes.
     */
    public SystemManager() {
        gui = new Gui();
        data = new Data();
        logger = new Logger();
        scanner = new Scanner(System.in);
    }

    /**
     * This method is responsible for the initial system executation.
     * He calls other system methods that user wants.
     */
    public void execute() {
        logger.generateActionLog("SYSTEM STARTED!");
        String option = "";
        List<String> dataCitiesName = data.loadDisponibleCities();
        while(!option.equals("-99")) {
            option = gui.callMenu();
            switch(option) {
                case "1":
                    createNewCity();
                    logger.generateActionLog("The user chosen create a new city operation.");
                    break;
                case "3":
                    loadAllCities();
                    logger.generateActionLog("The user chosen load all cities stored.");
                    break;
                case "5":
                    cityManager(gui.captureCity());
                    logger.generateActionLog("The user chosen manager a city operation.");
                    break;
                case "6":
                    searchCity();
                    logger.generateActionLog("The user chosen search a city operation.");
                    break;
                case "7":
                    searchNeighborhood();
                    logger.generateActionLog("The user chosen search a neighborhood operation.");
                    break;
                case "9":
                    deleteDataFiles();
                    logger.generateActionLog("The user chosen delete all data files operation.");
                    break;
                case "4":
                    editCity();
                    logger.generateActionLog("The user chosen edit a city data operation.");
                    break;
                default:
                    break;
            }
        }
        
    }

    /**
     * This method is responsible to store a new city in
     * database files. He captures all object information states
     * and after that, creates a new city object to be store at
     * binary files database.
     */
    public void createNewCity() {
        List<City> cities = gui.createCityInformations();
        System.out.println(data.storeCityData(cities));
        logger.generateActionLog("The new cities entered by the user has been stored.");
        int count = 0;
        for(City city : cities) {
            count++;
            logger.generateMessageLog(count+". City: " + city.hashCode());
        }
    }

    /**
     * This method is responsible for reading all cities objects in
     * binary database files. He loads and shows all object states
     * at screen for the user.
     */
    public void loadAllCities() {
        List<City> cities = data.loadCities();
        logger.generateActionLog("All cities loaded of binary database files.");
        gui.showCitiesData(cities);
    }

    /**
     * This method is responsible for calls the city manager module.
     * This module, manages all cities objects and his informations.
     * For add, remove or edit neighborhoods, the user needs to be access
     * here!
     * 
     * @param cityName City name string.
     */
    public void cityManager(String cityName) {
        List<City> cities = data.loadCities();
        logger.generateActionLog("All cities loaded of binary database files.");
        City city = null;
        for(City c : cities) {
            if(c.getName().equals(cityName)) {
                city = c;
                break;
            }
        }
        String option = "0";
        while(!option.equals("-99")) {
            option = gui.callCityManager(city);
            switch(option) {
                case "1":
                    gui.showCitiesData(city);
                    break;
                case "2":
                    addNewNeighborhood(city);
                    break;
                case "3":
                    removeNeighborhood(city);
                    break;
                case "4":
                    editNeighborhood(city);
                    break;
                case "5":
                    generateStatisticsReport(city);
                    break;
                case "-99":
                    return;
                default:
                    break;
            }
        }
    }

    /**
     * This method is responsible for adding a new neighborhoods at
     * any city. He captures all neighborhood states informations and
     * after that, update city rates.
     * 
     * @param c City object.
     */
    public void addNewNeighborhood(City c) {
        List<String> informations = gui.addNewNeighborhoodInformations();
        List<Neighborhood> neighborhoods = new ArrayList<Neighborhood>();
        String name = "";
        int demographicRate = 0;
        double perCaptaIncome = 0;
        int crimeRate = 0;
        int count = 0;
        for(String s : informations) {
            count++;
            if(count == 5) {
                count = 1;
            }
            if(count == 1) {
                name = s;
            }else if(count == 2) {
                demographicRate = Integer.parseInt(s);
            }else if(count == 3) {
                perCaptaIncome = Double.parseDouble(s);
            }else if(count == 4) {
                crimeRate = Integer.parseInt(s);
                neighborhoods.add(new Neighborhood(name, demographicRate, perCaptaIncome, crimeRate));
            }
        }
        for(Neighborhood n : neighborhoods) {
            c.addNeighborhood(n);
        }
        data.storeCityData(c);
        logger.generateActionLog("All cities stored at binary database files.");
    }

    /**
     * This method is responsible for removing a city newighborhood chosen
     * by user. He captures the name attribute state and compares with all
     * neighborhoods of city object. After that, it removes this neighborhood
     * and store the changes.
     * 
     * @param c City object.
     */
    public void removeNeighborhood(City c) {
        List<String> names = gui.removeNeighborhoodInformations();
        List<Neighborhood> neighborhoods = c.getNeighborhoods();
        for(Neighborhood n : neighborhoods) {
            for(String s : names) {
                if(n.getName().equals(s)) {
                    neighborhoods.remove(n);
                }
            }
        }
        System.out.println(data.storeCityData(c));
        logger.generateActionLog("All cities stored at binary database files.");
        gui.pressToContinue();
        return;
        
    }

    /**
     * This method is responsible for editing a neighborhood chosen
     * by the user. He captures a new states attribute informations
     * that the user wants and store the changes at binary database files.
     * 
     * @param c City object.
     */
    public void editNeighborhood(City c) {
        String name = gui.editNeighborhoodInformations(c.getNeighborhoods());
        List<Neighborhood> neighborhoods = c.getNeighborhoods();
        for(Neighborhood n : neighborhoods) {
            if(n.getName().equals(name)) {
                switch(gui.editNeighborhoodInformations(n)) {
                    case 1:
                        gui.clear();
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("+ NEIGHBORHOOD NAME                                +");
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("[!] CURRENT NEIGHBORHOOD NAME: "+n.getName());
                        boolean control = true;
                        List<Neighborhood> names = c.getNeighborhoods();
                        String newName;
                        do {
                            System.out.print("[#] ENTER A NEW NEIGHBORHOOD NAME: ");
                            newName = scanner.nextLine().toLowerCase();
                            control = true;
                            for(Neighborhood n2 : names) {
                                if(newName.equals(n2.getName())) {
                                    control = false;
                                }
                            }
                            if(control) {
                                break;
                            }
                        }while(!control);
                        n.setName(newName);
                        System.out.println(data.storeCityData(c));
                        logger.generateActionLog("All cities stored at binary database files.");
                        break;
                    case 2:
                        gui.clear();
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("+ DEMOGRAPHIC RATE VALUE                           +");
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("[!] CURRENT DEMOGRAPHIC RATE: "+n.getDemographicRate());
                        System.out.print("[#] ENTER A NEW DEMOGRAPHIC RATE VALUE [Enter a integer value]: ");
                        try {
                            n.setDemographicRate(Integer.parseInt(scanner.nextLine()));
                            c.updateRates();
                            System.out.println(data.storeCityData(c));
                            logger.generateActionLog("All cities stored at binary database files.");
                        }catch (NumberFormatException nfe) {
                            nfe.printStackTrace();
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        gui.clear();
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("+ PER CAPTA INCOME RATE VALUE                      +");
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("[!] CURRENT PER CAPTA INCOME RATE: "+n.getPerCaptaIncome());
                        System.out.print("[#] ENTER A NEW DEMOGRAPHIC RATE VALUE [Enter a integer or double value]: ");
                        try {
                            n.setPerCaptaIncome(Double.parseDouble(scanner.nextLine()));
                            c.updateRates();
                            System.out.println(data.storeCityData(c));
                            logger.generateActionLog("All cities stored at binary database files.");
                        }catch (NumberFormatException nfe) {
                            nfe.printStackTrace();
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        gui.clear();
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("+ CRIME RATE VALUE                                 +");
                        System.out.println("+--------------------------------------------------+");
                        System.out.println("[!] CURRENT CRIME RATE VALUE: "+n.getCrimeRate());
                        System.out.print("[#] ENTER A NEW CRIME RATE VALUE [Enter a integer value]: ");
                        try {
                            n.setCrimeRate(Integer.parseInt(scanner.nextLine()));
                            c.updateRates();
                            System.out.println(data.storeCityData(c));
                            logger.generateActionLog("All cities stored at binary database files.");
                        }catch (NumberFormatException nfe) {
                            nfe.printStackTrace();
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }
        gui.pressToContinue();
        return;
    }

    public void generateStatisticsReport(City c) {

    }
    
    /**
     * This method when is called delete all binary database files.
     * He does cleaning the cities directory.
     */
    public void deleteDataFiles() {
        String option = gui.deleteDataFilesInformations();
        gui.clear();
        if(option.equals("y")) {
            System.out.println("[...] DELETING ALL YOUR DATA...");
            data.deleteAllFiles();
            System.out.println("[!] YOUR DATA WAS BEEN DELETED!");
            gui.pressToContinue();
            return;
        }else {
            return;
        }
    }

    /**
     * This method is responsible for editing a city attribute states object.
     * He captures the attribute that user chosen to change and apply the changes
     * into city.
     */
    public void editCity() {
        List<City> cities = data.loadCities();
        logger.generateActionLog("All cities loaded of binary database files.");
        boolean control_1 = true;
        String nameCity;
        do {
            nameCity = gui.editCityInformations(data.loadDisponibleCities());
            for(City c : cities) {
                if(c.getName().equals(nameCity)) {
                    switch(gui.editCityInformations(c)) {
                        /*case 1:
                            gui.clear();
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("+ CITY NAME                                        +");
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("[!] CURRENT CITY NAME: "+c.getName());
                            boolean control = true;
                            List<String> names = data.loadDisponibleCities();
                            String newName;;
                            do {
                                System.out.print("[#] ENTER A NEW CITY NAME: ");
                                newName = scanner.nextLine().toLowerCase();
                                control = true;
                                for(String s : names) {
                                    s = s.replace(".bin", "");
                                    if(newName.equals(s)) {
                                        control = false;
                                    }
                                }
                                if(control) {
                                    break;
                                }
                            }while(!control);
                            System.out.println(newName);
                            System.out.println(oldName);
                            c.setName(newName);
                            System.out.println(data.storeCityData(c));
                            break;*/
                        case 2:
                            gui.clear();
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("+ CITY STATE/DISTRICT/PROVINCE                     +");
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("[!] CURRENT INFORMATION: "+c.getDistrict());
                            System.out.print("[#] ENTER A NEW STATE NAME: ");
                            c.setDistrict(scanner.nextLine().toLowerCase());
                            System.out.println(data.storeCityData(c));
                            logger.generateActionLog("All cities stored at binary database files.");
                            gui.pressToContinue();
                            control_1 = false;
                            break;
                        case 3:
                            gui.clear();
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("+ CITY COUNTRY                                     +");
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("[!] CURRENT COUNTRY: "+c.getCountry());
                            System.out.print("[#] ENTER A NEW COUNTRY NAME: ");
                            c.setCountry(scanner.nextLine().toLowerCase());
                            System.out.println(data.storeCityData(c));
                            logger.generateActionLog("All cities stored at binary database files.");
                            gui.pressToContinue();
                            control_1 = false;
                            break;
                        case 4:
                            gui.clear();
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("+ CURRENT CITY MAYOR                               +");
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("[!] CURRENT MAYOR: "+c.getMayor());
                            System.out.print("[#] ENTER A NEW MAYOR NAME: ");
                            c.setMayor(scanner.nextLine().toLowerCase());
                            System.out.println(data.storeCityData(c));
                            logger.generateActionLog("All cities stored at binary database files.");
                            gui.pressToContinue();
                            control_1 = false;
                            break;
                        case 5:
                            gui.clear();
                            control_1 = false;
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("+ CITY DEMOGRAPHIC RATE                            +");
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("[!] CURRENT CITY DEMOGRAPHIC RATE: "+c.getDemographicRate());
                            System.out.print("[#] ENTER A NEW DEMOGRAPHIC RATE: ");
                            c.setDemographicRate(Integer.parseInt(scanner.nextLine()));
                            System.out.println(data.storeCityData(c));
                            logger.generateActionLog("All cities stored at binary database files.");
                            gui.pressToContinue();
                            control_1 = false;
                            break;
                        case 6:
                            gui.clear();
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("+ CITY PER CAPTA INCOME RATE                       +");
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("[!] CURRENT PER CAPTA INCOME RATE: "+c.getPerCaptaIncome());
                            System.out.print("[#] ENTER A NEW PER CAPTA INCOME RATE: ");
                            c.setPerCaptaIncome(Double.parseDouble(scanner.nextLine()));
                            System.out.println(data.storeCityData(c));
                            logger.generateActionLog("All cities stored at binary database files.");
                            gui.pressToContinue();
                            control_1 = false;
                            break;
                        case 7:
                            gui.clear();
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("+ CITY CRIME RATE                                  +");
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("[!] CURRENT CRIME RATE: "+c.getCrimeRate());
                            System.out.print("[#] ENTER A NEW CRIME RATE: ");
                            c.setCrimeRate(Integer.parseInt(scanner.nextLine()));
                            System.out.println(data.storeCityData(c));
                            logger.generateActionLog("All cities stored at binary database files.");
                            gui.pressToContinue();
                            control_1 = false;
                            break;
                        case 8:
                            gui.clear();
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("+ CITY NEIGHBORHOODS                               +");
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("[!] CURRENT NEIGHBORHOODS: ");
                            List<Neighborhood> neighborhoods = c.getNeighborhoods();
                            for(Neighborhood n : neighborhoods) {
                                System.out.println(n.toString());
                            }
                            System.out.print("[#] DO YOU WANT TO REMOVE ANY NEIGHBORHOOD? [Y/n]: ");
                            System.out.println("WILL BE DEVELOPED!");
                            gui.pressToContinue();
                            control_1 = false;
                            break;
                    }
                }
            }
        }while(control_1);
    }

    /**
     * This method function is capture by the user, informations to search a city
     * registered into the database binary files. If the search returns a valid 
     * element found, it shows to him the object attribute states, in this case,
     * informations about the city.
     */
    public void searchCity() {
        List<City> cities = data.loadCities();
        logger.generateActionLog("All cities loaded of binary database files.");
        String key = gui.searchCityInformations();
        for(City c : cities) {
            if(key.equals(c.getName())) {
                gui.showCitiesData(c);
            }
        }
        gui.pressToContinue();
        return;
    }

    /**
     * This method is responsible for searching a neighborhood in b
     */
    public void searchNeighborhood() {
        String key = gui.searchNeighborhoodInformations();
        List<City> cities = data.loadCities();
        logger.generateActionLog("All cities loaded of binary database files.");
        List<Neighborhood> neighborhoods;
        for(City c : cities) {
            neighborhoods = c.getNeighborhoods();
            if(neighborhoods != null) {
                for(Neighborhood n : neighborhoods) {
                    if(n.getName().equals(key)) {
                        System.out.println(n.toString());
                        break;
                    }
                }
            }else {
                continue;
            }
        }
        gui.pressToContinue();
        return;
    }
}