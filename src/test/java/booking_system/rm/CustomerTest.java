package booking_system.rm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    @DisplayName("Test Valid Input Customer ID")
    public void testValidInput(){
        var test = CustomerCSVReader.createCustomer("10006,Miss,Ava,Brown,F,ava.brown@example.com,8/30/1989,Silver");
        Assertions.assertEquals(10006, test.getCustomerID());

    }

}
