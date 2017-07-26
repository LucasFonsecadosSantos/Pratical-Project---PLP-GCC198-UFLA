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

/**
 * This class describes a logger files generator.
 * It receives and produces a lot of messages about
 * the system operation status, defined in each of the
 * classes.
 */
public class Logger {

    /**
     * Successfully message string attribute.
     * That is returned when a operation status is successfully.
     */
    private final String successfullyMessage;

    /**
     * Logs directory attribute.
     */
    private File logsFolder;

    /**
     * BufferedReader java object attribute.
     * Used to read a log files.
     */
    private BufferedReader br;

    /**
     * BufferedWriter java object attribute.
     * Used to write a log files.
     */
    private BufferedWriter bw;

    /**
     * Logger object constructor.
     * It instances a log directory with file object and directory path
     * and the successfullymessage state attribute.
     */
    public Logger() {
        logsFolder = new File("../logs");
        successfullyMessage = "[!] SUCCESSFULLY MESSAGE!";
    }

    /**
     * This is a main logger method. It starts the log file
     * produces and verifys somethings.
     */
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

    /**
     * This method is responsible for generating action log messages.
     * It is called in any class to write a log status at the 
     * current log file.
     * 
     * @param action A action system status to be write into text log file.
     * @return String Operation status.
     */
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
     * @param action Colocar
     * @return String colocar
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