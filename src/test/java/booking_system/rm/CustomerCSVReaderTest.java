package booking_system.rm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CustomerCSVReaderTest {

    String myPath = "src/main/resources/airline_booking.csv";

    @Test
    @DisplayName("Check if the size of the array list is the length of the csv file")
    public void correctLengthTest() {
        Assertions.assertEquals(14,CustomerCSVReader.readFileLines(myPath).size());
    }

    @Test
    @DisplayName("Check accuracy of the csv file")
    public void correctInformationTest(){
        String header = "Customer ID,Title,First Name,Last Name,Gender,Email,Date of Birth,Membership Tier";
        Assertions.assertEquals(header, CustomerCSVReader.readFileLines(myPath).get(0));
    }

    @Test
    @DisplayName("Array contains Data")
    public void correctDataTest(){
        String data = "10010,Miss,Isabella,Montez,F,izziemontez@gmail.com,4/10/1998,Silver";
        Assertions.assertEquals(data, CustomerCSVReader.readFileLines(myPath).get(10));
    }

    @Test
    @DisplayName("Check data pulls correctly")
    public void correctDataPulling() {
        var expected = CustomerCSVReader.createCustomer("10005,Mr,Liam,Nguyen,M,liam_nguyen_01@icloud.com,12/14/1997,Gold");
        Assertions.assertEquals("Nguyen", expected.getLastName());
    }

    @Test
    @DisplayName("Check date of Birth pulls correctly")
    public void correctDoBPulling(){
        var result = CustomerCSVReader.createCustomer("10003,Dr,Oliver,Wilson,M,oliver.w@example.com,11/7/1970,Silver");
        LocalDate expected = LocalDate.of(1970, 11, 07);
        Assertions.assertEquals(expected, result.getDoB());
    }

    @Test
    @DisplayName("Array with the correct length")
    public void correctLengthArray(){
        CustomerCSVReader.readCustomer(myPath);
        var myList = CustomerCSVReader.getCustomerList();
        Assertions.assertEquals(13, myList.size());
    }

    @Test
    @DisplayName("1st contains correct information")
    public void firstCorrectInformationTest(){
        CustomerCSVReader.readCustomer(myPath);
        var myList = CustomerCSVReader.getCustomerList();
        var result = myList.get(0);
        Assertions.assertEquals("Thompson", result.getLastName());
    }

    @Test
    @DisplayName("customer object in the list contains correct information")
    public void customerDOBTest(){
        CustomerCSVReader.readCustomer(myPath);
        var myList = CustomerCSVReader.getCustomerList();
        var result = myList.get(9);
        LocalDate date = LocalDate.of(1998, 04, 10);
        Assertions.assertEquals(date, result.getDoB());
    }
}
