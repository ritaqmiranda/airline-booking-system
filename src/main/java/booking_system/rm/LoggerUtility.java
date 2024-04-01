package booking_system.rm;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtility {

    public static final Logger LOGGER = Logger.getLogger(LoggerUtility.class.getName());

    static {
        LOGGER.setLevel(Level.INFO);
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/logFile.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IllegalArgumentException | SecurityException | IOException z) {
            var stackTrace = z.getStackTrace();
        }
    }
}
