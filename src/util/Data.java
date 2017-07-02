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
    public List<String> loadDisponibleCities() {
            File[] citiesData = new File("./data/cities").listFiles();
            if(citiesData != null) {
                List<String> citiesNames = new ArrayList<String>();
                for(File f : citiesData) {
                    if(f.isFile()) {
                        citiesNames.add(f.getName());
                    }
                }
                return citiesNames;
            }else {
                return null;
            }
    }

    public String storeCityData(List<City> citysList) {
        for(City c : citysList) {
            try {
                File file = new File("./data/cities/"+c.getName()+".bin");
                if(!new File("./data/cities").exists()) {
                    new File("./data/cities").mkdirs();
                }
                if(!file.exists()) {
                    file.createNewFile();
                }   
                ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream("./data/cities/" + c.getName() + ".bin", true));
                object.writeObject(c);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return successfullyMessage;    
    }

    public List<City> loadCities() {
        try {
            File directory = new File("./data/cities");
            if(!directory.exists()) {
                System.out.println("caiu aqui");
                return null;
            }else {
                File[] cities = directory.listFiles();
                List<City> loadedCities = new ArrayList<City>();
                for(File f : cities) {
                    ObjectInputStream objectS = new ObjectInputStream(new FileInputStream(f));
                    City c = (City) objectS.readObject();
                    loadedCities.add(c);
                    objectS.close();
                }
                return loadedCities;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
} 