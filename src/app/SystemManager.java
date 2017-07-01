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
import java.util.List;
import java.util.ArrayList;

public class SystemManager {

    private Gui gui;
    private Data data;

    public SystemManager() {
        gui = new Gui();
        data = new Data();
    }

    public void execute() {

        String option = "";
        List<String> dataCitysName = data.loadDisponibleCitys();
        while(!option.equals("-99")) {
            option = gui.callMenu();
            switch(option) {
                case "1":
                    createNewCity();
                    break;
                default:
                    break;
            }
        }
        
    }

    public void createNewCity() {
        List<String> contents = gui.createCityInformations();
        List<City> citys = new ArrayList<City>();
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
            citys.add(new City(name, district, country, currentMayor));
        }
        System.out.println(citys);

    }
    
}