package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler {

    private static Date currentDate;

    public static String getCurrentDate(){
        currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(currentDate);
    }
}
