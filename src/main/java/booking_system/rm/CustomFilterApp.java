package booking_system.rm;

import java.util.ArrayList;
import java.util.Scanner;

import static booking_system.rm.CustomerFilter.filterByGender;
import static booking_system.rm.CustomerFilter.sortByMembershipTier;

public class CustomFilterApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomerCSVReader.readCustomer("src/main/resources/airline_booking.csv");
        ArrayList<Customer> customers = CustomerCSVReader.getCustomerList();

        boolean exit = false;
        while (!exit) {
            System.out.println("Customer Operations Menu:");
            System.out.println("1. Filter customers by gender");
            System.out.println("2. Sort customers by membership tier");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter gender to filter (M/F): ");
                    String gender = scanner.next();
                    ArrayList<Customer> filteredCustomers = filterByGender(customers, gender);
                    System.out.println("Filtered Customers:");
                    for (Customer customer : filteredCustomers) {
                        System.out.println(customer);
                    }
                    break;
                case 2:
                    sortByMembershipTier(customers);
                    System.out.println("Sorted Customers by Membership Tier:");
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
        scanner.close();
    }

}
