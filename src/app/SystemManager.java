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

        int option = 0;
        List<String> dataCitysName = data.loadDisponibleCitys();
        while(option != -99) {
            option = gui.callMenu(dataCitysName);
            switch(option) {
                case 1:
                    createNewCity();
                    break;
                default:
                    break;
            }
        }
        
    }

    public void createNewCity() {
        gui.createCityInformations();
    }
    
}