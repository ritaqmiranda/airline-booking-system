package booking_system.rm;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexApp {

    private static final String CUSTOMER_ID_PATTERN = "[0-9]{5}";
    private static final String TITLE_PATTERN = "Mr|Ms|Dr|Mrs|Miss";
    private static final String FIRST_NAME_PATTERN = "[A-Z]{1}[a-z]+";
    private static final String LAST_NAME_PATTERN = "[A-Z]{1}[a-z]+";
    private static final String GENDER_PATTERN = "M|F";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String DATE_PATTERN = "^(\\d{1,2})/(\\d{1,2})/(\\d{4})$";
    private static final String MEMBERSHIP_TIER_PATTERN = "^(NA|Silver|Gold|Platinum)$";

    public static boolean isValidCustomerID(String input){
        return matchesPattern(input, CUSTOMER_ID_PATTERN);
    }

    public static boolean isValidTitle(String input){
        return matchesPattern(input, TITLE_PATTERN);
    }

    public static boolean isValidFirstName(String input){
        return matchesPattern(input, FIRST_NAME_PATTERN);
    }

    public static boolean isValidLastName(String input){
        return matchesPattern(input, LAST_NAME_PATTERN);
    }

    public static boolean isValidGender(String input){
        return matchesPattern(input, GENDER_PATTERN);
    }

    public static boolean isValidEmail(String input){
        return matchesPattern(input, EMAIL_PATTERN);
    }

    public static boolean isValidDate(String input){
        Pattern dobPattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = dobPattern.matcher(input);

        int month = 0;
        int day = 0;
        int year = 0;

        if (matcher.find()) {
            month = Integer.parseInt(matcher.group(1));
            day = Integer.parseInt(matcher.group(2));
            year = Integer.parseInt(matcher.group(3));
        } else {
            return false;
        }

        LocalDate now = LocalDate.now();
        int thisYear = now.getYear();

        if (!(month >0 && month <13)){
            return false;
        } else if (!(day >0 && day<32)){
            return false;
        } else if (!(year > 1900 && year <= thisYear)){
            return false;
        }

        return true;
    }

    public static boolean isValidMembershipTierPattern(String input){
        return matchesPattern(input, MEMBERSHIP_TIER_PATTERN);
    }

    private static boolean matchesPattern(String input, String pattern){
        return input.matches(pattern);
    }
}
