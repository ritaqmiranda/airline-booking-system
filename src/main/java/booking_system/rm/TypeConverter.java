package booking_system.rm;

import java.util.logging.Level;

public class TypeConverter extends RegexApp {

    public static int convertID(String number){
        int customer_id =-1;
        if(isValidCustomerID(number)){
            try {
                customer_id = Integer.parseInt(number);
            } catch (NumberFormatException e){
                LoggerUtility.LOGGER.log(Level.WARNING, number + " " + e);
            }
        } else {
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid Employee ID: " + number);
        }
        return customer_id;
            }
}

