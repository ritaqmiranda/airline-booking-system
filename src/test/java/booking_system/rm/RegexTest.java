package booking_system.rm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegexTest {

    @Test
    @DisplayName("Test Date Validator - valid date")
    public void validDateTest(){
        Assertions.assertTrue(RegexApp.isValidDate("02/29/1976"));
    }

    @Test
    @DisplayName("Test Date Validator - valid short date")
    public void validShortDateTest(){
        Assertions.assertTrue(RegexApp.isValidDate("2/29/1976"));
    }

    @Test
    @DisplayName("Test Date Validator - invalid day")
    public void invalidDayTest(){
        Assertions.assertFalse(RegexApp.isValidDate("02/35/1977"));
    }

    @Test
    @DisplayName("Test Date Validator - invalid month")
    public void invalidMonthTest(){
        Assertions.assertFalse(RegexApp.isValidDate("26/15/1977"));
    }

    @Test
    @DisplayName("Test Date Validator - year too early")
    public void invalidYearTest(){
        Assertions.assertFalse(RegexApp.isValidDate("02/15/1581"));
    }

    @Test
    @DisplayName("Test Date Validator - year not yet happened")
    public void yearTooEarlyTest(){
        Assertions.assertFalse(RegexApp.isValidDate("02/15/2088"));
    }

    @Test
    @DisplayName("Test Date Validator - current year")
    public void currentYearTest(){
        Assertions.assertTrue(RegexApp.isValidDate("02/15/2024"));
    }

    @Test
    @DisplayName("Test not a Date")
    public void notADateTest(){
        Assertions.assertFalse(RegexApp.isValidDate("not a date"));
    }

}
