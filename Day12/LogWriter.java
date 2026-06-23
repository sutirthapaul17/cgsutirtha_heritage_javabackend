import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    public static void writeLog(String message) {
        // 'true' enables APPEND mode — does not overwrite existing content
        try (FileWriter fw = new FileWriter("application.log", true)) {
            fw.write("[INFO] " + message + "\n");
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeLog("Application started");
        writeLog("User Priya logged in");
        writeLog("Order #1042 placed");
        System.out.println("Log entries written to application.log");
    }
}

