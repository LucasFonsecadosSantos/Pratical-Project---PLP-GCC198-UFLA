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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import app.City;
import app.Neighborhood;
import java.io.Serializable;

public class Data implements Serializable {
    
    private final String successfullyMessage;

    public Data() {
        successfullyMessage = "[!] SUCCESSFULLY OPERATION!";
    }
    public List<String> loadDisponibleCitys() {
            File[] citysData = new File("./data/citys").listFiles();
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
   /* public void loadData(String cityName) {
        cityName = cityName.toLowerCase();
        File dataCity = new File("../data/"+cityName+".bin");
        if(dataCity.isFile()) {

        }else {

        }
    }*/

    public String storeCityData(List<City> citysList) {
        for(City c : citysList) {
            try {
                File file = new File("./data/citys/"+c.getName()+".bin");
                if(!new File("./data/citys").exists()) {
                    new File("./data/citys").mkdirs();
                }
                if(!file.exists()) {
                    file.createNewFile();
                }   
                ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream("./data/citys/" + c.getName() + ".bin", true));
                object.writeObject(c);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return successfullyMessage;    
    }

}