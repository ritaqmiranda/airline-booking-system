package booking_system.rm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateUtilityTests {

    @Test
    @DisplayName("Date Formatter parses a valid date")
    public void parseValidDate(){
        LocalDate expected = LocalDate.of(1995, 12, 9);
        LocalDate result = DateUtility.formatDate("12/09/1995");
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Date Formatter does not parse an invalid date")
    public void doesNotParseInvalidDate(){
        LocalDate expected = LocalDate.of(1000, 1, 1);
        LocalDate result = DateUtility.formatDate("not a date");
        Assertions.assertEquals(expected, result);
    }

}
