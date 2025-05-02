package PractiseProject.Utilities;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampUtilities {
    public static String GetTimeStamp() {
        // this is valid also-> return String.valueOf(System.currentTimeMillis());
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return formatter.format(date);
    }
}