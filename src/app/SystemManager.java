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


public class SystemManager {

    private Gui gui;
    private Data data;
    private Logger logger;

    public SystemManager() {
        gui = new Gui();
        data = new Data();
        logger = new Logger();
    }

    public void execute() {
        logger.generateActionLog("SYSTEM STARTED!");
        String option = "";
        List<String> dataCitiesName = data.loadDisponibleCities();
        while(!option.equals("-99")) {
            option = gui.callMenu();
            switch(option) {
                case "1":
                    createNewCity();
                    break;
                case "3":
                    loadAllCities();
                    break;
                case "5":
                    cityManager(gui.captureCity());
                    break;
                default:
                    break;
            }
        }
        
    }

    public void createNewCity() {
        List<String> contents = gui.createCityInformations();
        List<City> cities = new ArrayList<City>();
        int count = 0;

        String name = "";
        String district = "";
        String country = "";
        String currentMayor = "";

        for(int i=0; i < contents.size(); i++) {
            if(i % 4 == 0) {
                name = contents.get(i);
            }else if(i %4 == 1) {
                district = contents.get(i);
            }else if(i % 4 == 2) {
                country = contents.get(i);
            }else if(i % 4 == 3) {
                currentMayor = contents.get(i);
            }
            cities.add(new City(name, district, country, currentMayor));
        }
        data.storeCityData(cities);
    }

    public void loadAllCities() {
        List<City> cities = data.loadCities();
        gui.showCitiesData(cities);
    }

    public void cityManager(String cityName) {
        List<City> cities = data.loadCities();
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

    public void addNewNeighborhood(City c) {
        List<String> informations = gui.addNewNeighborhoodInformations();
        List<Neighborhood> neighborhoods = new ArrayList<Neighborhood>();
        String name = "";
        int demographicRate = 0;
        double perCaptaIncome = 0;
        int crimeRate = 0;

        for(int i=0; i < informations.size(); i++) {
            if(i % 4 == 0) {
                name = informations.get(i);
            }else if(i % 4 == 1) {
                demographicRate = Integer.parseInt(informations.get(i));
            }else if(i % 4 == 2) {
                perCaptaIncome = Double.parseDouble(informations.get(i));
            }else if(i % 4 == 3) {
                crimeRate = Integer.parseInt(informations.get(i));
            }
            neighborhoods.add(new Neighborhood(name, demographicRate, perCaptaIncome, crimeRate));
        }

        for(Neighborhood n : neighborhoods) {
            c.addNeighborhood(n);
        }
    }

    public void removeNeighborhood(City c) {

    }

    public void editNeighborhood(City c) {

    }

    public void generateStatisticsReport(City c) {

    }
}