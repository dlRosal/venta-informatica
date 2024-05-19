package logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class ClaseLogger {
    public static Logger getLogger(String clase) {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("src/logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Logger.getLogger(clase);
    }
}