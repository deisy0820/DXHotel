package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvertDate {

    public ConvertDate() {
    }

    private static final Logger LOGGER = Logger.getLogger("");

    private static Date ParseDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
        Date dateOut = null;
        try {
            dateOut = format.parse(date);
        } catch (ParseException ex) {
            LOGGER.log(Level.INFO, ex.toString());
        }
        return dateOut;
    }

    public static float returnTotalDays(String checkIn, String checkOut) {

        float daysBetween = 0;

        try {
            Date dateBefore = ConvertDate.ParseDate(checkIn);
            Date dateAfter = ConvertDate.ParseDate(checkOut);
            long difference = dateAfter.getTime() - dateBefore.getTime();
            daysBetween = (difference / (1000 * 60 * 60 * 24))+1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return daysBetween;
    }

}

