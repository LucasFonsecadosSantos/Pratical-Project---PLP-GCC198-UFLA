/**
 *
 *  CITY MANAGER 1.0 June 26, 2017.
 *  Pratical Project by Paradigms and Programming Languages
 *  GCC198 - Federal University of Lavras (UFLA)
 *
 *  @author Lucas Fonseca dos Santos
 *  @author Leticia Ferreira
 */
package util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Data {
    
    public List<String> loadDisponibleCitys() {
            File[] citysData = new File("./data").listFiles();
            if(citysData != null) {
                List<String> citysNames = new ArrayList<String>();
                for(File f : citysData) {
                    if(f.isFile()) {
                        citysNames.add(f.getName());
                    }
                }
                return citysNames;
            }else {
                return null;
            }
    }
    public void loadData(String cityName) {
        cityName = cityName.toLowerCase();
        File dataCity = new File("../data/"+cityName+".bin");
        if(dataCity.isFile()) {

        }else {

        }
    }

}