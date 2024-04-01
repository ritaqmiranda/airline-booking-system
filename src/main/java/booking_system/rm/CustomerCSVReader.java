package booking_system.rm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static booking_system.rm.ValidateCustomer.isValidCustomer;

public class CustomerCSVReader {

    private static ArrayList<Customer> listOfCustomers = new ArrayList<>();

    public static Customer createCustomer(String line) {

        var splitString = line.split(",");

        var customerID = TypeConverter.convertID(splitString[0].trim());
        var title = splitString[1].trim();
        var firstName = splitString[2].trim();
        var lastName = splitString[3].trim();
        var gender = splitString[4].trim();
        var email = splitString[5].trim();
        var doB = DateUtility.formatDate(splitString[6].trim());
        var tier = splitString[7].trim();

        Customer customer = new Customer(customerID, title, firstName, lastName, gender, email, doB, tier);

        listOfCustomers.add(customer);

        return customer;
    }

    public static ArrayList<String> readFileLines(String fileName){
        ArrayList<String> lines = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            while((line = br.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void readCustomer(String fileName) {
        ArrayList<String> temp = readFileLines(fileName);
        for (int i = 1; i < temp.size(); i++) {
            decideToCreateCustomer(temp.get(i));
        }
    }

    public static void decideToCreateCustomer(String line) {
        var validatedCustomerData = ValidateCustomer.isValidCustomer(line);

        if (validatedCustomerData.contains("Error")){
            CSVCreator.addDataToCSV(line);
        } else {
            createCustomer(line);
        }
    }

    public static ArrayList<Customer> getCustomerList() {
        return new ArrayList<>(listOfCustomers);
    }
}