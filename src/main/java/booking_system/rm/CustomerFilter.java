package booking_system.rm;

import java.util.ArrayList;
import java.util.Comparator;

public class CustomerFilter {

    public static ArrayList<Customer> filterByGender(ArrayList<Customer> customers, String gender) {
        ArrayList<Customer> filteredCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getGender().equalsIgnoreCase(gender)) {
                filteredCustomers.add(customer);
            }
        }
        return filteredCustomers;
    }

    public static void sortByMembershipTier(ArrayList<Customer> customers) {
        customers.sort(Comparator.comparing(Customer::getMembershipTier));
    }

}
