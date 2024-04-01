package booking_system.rm;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MainApp {

    public static void main(String[] args) {

        String myPath = "src/main/resources/airline_booking.csv";

        CustomerCSVReader.readCustomer(myPath);
        var employeeList = CustomerCSVReader.getCustomerList();

        String jsonEmployeeList;
        try {
            jsonEmployeeList = Serialisation.serialiseToJson(employeeList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        String xmlEmployeeList;
        try {
            xmlEmployeeList = Serialisation.serialiseToXml(employeeList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Customer[] customerObjects;
        try {
            customerObjects = Serialisation.deserialiseFromJson(jsonEmployeeList, Customer[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(customerObjects.length);

        Customer[] customerObjectsFromXml;
        try {
            customerObjectsFromXml = Serialisation.deserialiseFromXml(xmlEmployeeList, Customer[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(customerObjectsFromXml.length);

    }

}
