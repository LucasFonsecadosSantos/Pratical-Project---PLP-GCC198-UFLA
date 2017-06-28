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

public class System {

    private Gui gui;

    public System() {
        gui = new Gui();
    }

    public void execute() {

        int option = 0;
        while(option != -99) {
            option = gui.callMenu();
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