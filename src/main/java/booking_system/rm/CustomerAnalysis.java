package booking_system.rm;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerAnalysis {

    public static int calculateAge(LocalDate dob) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dob, currentDate).getYears();
    }

    public static Map<String, Double> calculateAverageAgeByTier(ArrayList<Customer> customers) {
        Map<String, Double> averageAgeByTier = new HashMap<>();
        Map<String, Integer> totalAgeByTier = new HashMap<>();
        Map<String, Integer> customerCountByTier = new HashMap<>();

        for (Customer customer : customers) {
            String tier = customer.getMembershipTier();
            totalAgeByTier.put(tier, 0);
            customerCountByTier.put(tier, 0);
        }


        for (Customer customer : customers) {
            String tier = customer.getMembershipTier();
            int age = calculateAge(customer.getDoB());
            totalAgeByTier.put(tier, totalAgeByTier.get(tier) + age);
            customerCountByTier.put(tier, customerCountByTier.get(tier) + 1);
        }


        for (String tier : totalAgeByTier.keySet()) {
            int totalAge = totalAgeByTier.get(tier);
            int customerCount = customerCountByTier.get(tier);
            double averageAge = (double) totalAge / customerCount;
            averageAgeByTier.put(tier, averageAge);
        }

        return averageAgeByTier;
    }


}
