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

public class Logger {

    private final String successfullyMessage;
    private File logsFolder;
    private BufferedReader br;
    private BufferedWriter bw;
    public Logger() {
        logsFolder = new File("../logs");
        successfullyMessage = "[!] SUCCESSFULLY MESSAGE!";
    }

    private void startLog() {
        SystemDate sd = new SystemDate();
        try {
            String currentDate = sd.returnOnlyDate(); //Problem 00:00 SOLVED RS
            File file = new File("./logs/"+currentDate+".txt");
            if(!file.exists()) {
                new File("./logs").mkdirs();
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader("./logs/"+currentDate+".txt"));
            bw = new BufferedWriter(new FileWriter("./logs/"+currentDate+".txt", true));
            if(br.readLine() == null) {
                bw.newLine();
                bw.write("+==========================================+\n");
                bw.write("+           CITY MANAGER LOG FILE          +\n");
                bw.write("+==========================================+\n");
                bw.write("+ Developed by Lucas Fonseca dos Santos.   +\n");
                bw.write("+ Version: 1.0 2017                        +\n");
                bw.write("+==========================================+\n");
                bw.write("["+sd.returnCompleteDate()+"]: LOG FILE CREATED! Welcome to my software!\n");
                bw.close();
                br.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    public String generateActionLog(String action) {
        startLog();
        SystemDate sd = new SystemDate();
        try {
            bw = new BufferedWriter(new FileWriter("./logs/"+sd.returnOnlyDate()+".txt", true));
            bw.write("["+sd.returnCompleteDate()+"/ACTION]: "+action+" ;\n");
            bw.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return successfullyMessage;
    }

    /**
     * This method is responsible for generating new system logs
     * It receives a message by parameter.
     * 
     * 
     */
    public String generateMessageLog(String action) {
        startLog();
        SystemDate sd = new SystemDate();
        try {
            bw = new BufferedWriter(new FileWriter("./logs/"+sd.returnOnlyDate()+".txt", true));
            bw.write("[RECORD > OBJECT HASH CODE]: "+action+" ;\n");
            bw.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return successfullyMessage;
    }

}