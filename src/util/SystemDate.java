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

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * This class describes a SystemData object. It is used to generate
 * date strings formatted.
 */
public class SystemDate {

    /**
     * DateFormat java class attribute.
     */
    private DateFormat dateFormat;

    /**
     * Date java class attribute.
     */
	private Date date;

    /**
     * SystemDate object constructor. He instaces the Date and
     * dateFormat java classes.
     */
    public SystemDate() {
        date = new Date();
        dateFormat = new SimpleDateFormat("dd-MM-yyyy(HH:mm:ss)");
    }

    /**
     * This method returns a complete date of system (date and hour).
     * 
     * @return String Date formatted with hour.
     */
    public String returnCompleteDate() {
        return dateFormat.format(date);
    }

    /**
     * This method returns only Date formatted, without
     * system hour.
     * 
     * @return String String date formatted without hour.
     */
    public String returnOnlyDate() {
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    
}