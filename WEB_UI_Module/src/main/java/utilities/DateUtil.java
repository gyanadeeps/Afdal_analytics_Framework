package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String currentDateExtentReport() {
        //getting current date and time using Date class
       // DateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println(dateobj);
        return  dateobj.toString().format(String.valueOf(dateobj)).replaceAll("[^A-Za-z0-9]", "_");

    }

    public static String currentDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);

    }
}
