package booking_system.rm;

import java.util.logging.Level;

public class ValidateCustomer extends RegexApp {

    public static boolean flagVariable = true;

    private static String validateCustomerID;
    private static String validateTitle;
    private static String validateFirstName;
    private static String validateLastName;
    private static String validateGender;
    private static String validateEmail;
    private static String validateDoB;
    private static String validateMembershipTier;

    public static String isValidCustomer(String line){

        flagVariable = true;
        var splitString = line.split(",");

        validateCustomerID = checkCustomerID(splitString[0].trim());
        validateTitle = checkTitle(splitString[1].trim());
        validateFirstName = checkFirstName(splitString[2].trim());
        validateLastName = checkLastName(splitString[3].trim());
        validateGender = checkGender(splitString[4].trim());
        validateEmail = checkEmail(splitString[5].trim());
        validateDoB = checkDoB(splitString[6].trim());
        validateMembershipTier = checkMembershipTier(splitString[7].trim());

        if(flagVariable){
            return String.join(",", validateCustomerID, validateTitle, validateFirstName, validateLastName, validateGender, validateEmail, validateDoB, validateMembershipTier);
        } else {
            return "Error";
        }
    }

    public static String checkCustomerID(String customerID){
        if(isValidCustomerID(customerID)){
            return customerID;
        } else {
            flagVariable = false;
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid Customer ID: " + customerID);
        }
        return "Error";
    }

    public static String checkTitle(String title){
        if(isValidTitle(title)){
            return title;
        } else {
            flagVariable = false;
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid Title: " + title);
        }
        return "Error";
    }

    public static String checkFirstName(String firstName){
        if(isValidFirstName(firstName)){
            return firstName;
        } else {
            flagVariable = false;
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid First Name: " + firstName);
        }
        return "Error";
    }

    public static String checkLastName(String lastName){
        if(isValidLastName(lastName)){
            return lastName;
        } else {
            flagVariable = false;
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid Last Name: " + lastName);
        }
        return "Error";
    }

    public static String checkGender(String gender){
        if(isValidGender(gender)){
            return gender;
        } else {
            flagVariable = false;
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid Gender: " + gender);
        }
        return "Error";
    }

    public static String checkEmail(String email){
        if(isValidEmail(email)){
            return email;
        } else {
            flagVariable = false;
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid email: " + email);
        }
        return "Error";
    }

    public static String checkDoB(String DoB){
        if(isValidDate(DoB)){
            return DoB;
        } else {
            flagVariable = false;
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid Date of Birth: " + DoB);
        }
        return "Error";
    }

    public static String checkMembershipTier(String memberShipTier){
        if(isValidMembershipTierPattern(memberShipTier)){
            return memberShipTier;
        } else {
            flagVariable = false;
            LoggerUtility.LOGGER.log(Level.INFO, "Invalid Membership Tier: " + memberShipTier);
        }
        return "Error";
    }
}
