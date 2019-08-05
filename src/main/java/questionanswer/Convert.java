package questionanswer;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert {
    public static Date convertToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date convertToTimeStamp(Date date) {
        Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        System.out.println("Timestamp " + timestamp.getTime());//в конце удалить
        return timestamp;
    }
}