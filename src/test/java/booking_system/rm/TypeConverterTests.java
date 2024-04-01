package booking_system.rm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TypeConverterTests {

    @Test
    @DisplayName("Check if the ID number converts from String to int")
    public void convertsStringToIntTest() {
        String testData = "10001";
        Assertions.assertEquals(10001, TypeConverter.convertID(testData));
    }

    @Test
    @DisplayName("Check type int")
    public void checkTypeint() {
        String testData = "10001";
        var result = TypeConverter.convertID(testData);
        Assertions.assertEquals("java.lang.Integer", ((Object) result).getClass().getName());
    }

    @Test
    @DisplayName("Check for exception in id convertor")
    public void checksForExceptionInID() {
        String testData = "word";
        Assertions.assertEquals(-1, TypeConverter.convertID(testData));
    }

}
