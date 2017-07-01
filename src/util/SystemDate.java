package util;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SystemDate {

    private DateFormat dateFormat;
	private Date date;

    public SystemDate() {
        date = new Date();
        dateFormat = new SimpleDateFormat("dd-MM-yyyy(HH:mm:ss)");
    }

    public String returnCompleteDate() {
        return dateFormat.format(date);
    }

    public String returnOnlyDate() {
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    
}