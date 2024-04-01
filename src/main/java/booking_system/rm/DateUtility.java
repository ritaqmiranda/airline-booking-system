package booking_system.rm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtility extends RegexApp {

    public static LocalDate formatDate(String date){
        LocalDate newDate = LocalDate.of(1000, 1, 1);

        DateTimeFormatter completeDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter singleValueDay = DateTimeFormatter.ofPattern("MM/d/yyyy");
        DateTimeFormatter singleValueMonth = DateTimeFormatter.ofPattern("M/dd/yyyy");

        Pattern dateP = Pattern.compile("^(\\d{1,2})/(\\d{1,2})/(\\d{4})$");
        Matcher matcher = dateP.matcher(date);

        int month = 0;
        int day = 0;
        int year = 0;

        if (matcher.find()) {
            month = Integer.parseInt(matcher.group(1));
            day = Integer.parseInt(matcher.group(2));
            year = Integer.parseInt(matcher.group(3));
        }

        if (isValidDate(date)){
            try {
                if (day < 10){newDate = LocalDate.parse(date, singleValueDay);}
                else if (month < 10){ newDate = LocalDate.parse(date, singleValueMonth);}
                else {newDate = LocalDate.parse(date, completeDate);}
            } catch (Exception e) {
                LoggerUtility.LOGGER.log(Level.WARNING, date + " " + e);
            }
        } else {
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid Date: " + date);
        }

        return newDate;
    }

}
