package booking_system.rm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CSVCreator {

    public static String addDataToCSV(String line) {

        String csvPath = "src/main/resources/invalidData.log";
        String invalidData = line + "\n";

        try {
            Files.write(Paths.get(csvPath), invalidData.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Invalid Data has been added to CSV file successfully.";
    }

}
