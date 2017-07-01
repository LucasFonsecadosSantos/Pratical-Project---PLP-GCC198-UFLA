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

    public Logger() {
        logsFolder = new File("../logs");
        successfullyMessage = "[!] SUCCESSFULLY MESSAGE!";
    }

    public String generateActionLog(String action) {
        return successfullyMessage;
    }

    public String genereterRecordLog() {
        return successfullyMessage;
    }

}