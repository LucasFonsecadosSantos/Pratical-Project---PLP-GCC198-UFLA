/**
 *
 *  CITY MANAGER 1.0 June 26, 2017.
 *  Pratical Project by Paradigms and Programming Languages
 *  GCC198 - Federal University of Lavras (UFLA)
 *
 *  @author Lucas Fonseca dos Santos
 *  @author Leticia Ferreira
 */
import app.SystemManager;

/**
 * The main method. This method calls the system core
 * and executes it.
 */
public class Main {

    /**
     * The java virtual machine (JVM) method executation.
     * It only calls the system core and this is responsible
     * for the others algorithm executation.
     */
    public static void main(String[] args) {
        SystemManager system = new SystemManager();
        system.execute();
    }
    
}