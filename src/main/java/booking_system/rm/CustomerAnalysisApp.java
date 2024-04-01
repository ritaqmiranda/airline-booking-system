package booking_system.rm;

import java.util.ArrayList;
import java.util.Map;

import static booking_system.rm.CustomerAnalysis.calculateAverageAgeByTier;

public class CustomerAnalysisApp {

    public static void main(String[] args) {

        CustomerCSVReader.readCustomer("src/main/resources/airline_booking.csv");

        ArrayList<Customer> customers = CustomerCSVReader.getCustomerList();

        Map<String, Double> averageAgeByTier = calculateAverageAgeByTier(customers);

        for (Map.Entry<String, Double> entry : averageAgeByTier.entrySet()) {
            System.out.println("Average age of customers in " + entry.getKey() + " tier: " + entry.getValue());
        }
    }

}
