import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApplicationLogger {
    private static final String LOG_FILE = "app.log";
    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public enum Level { INFO, WARN, ERROR }

    public static void log(Level level, String message) {
        String timestamp = LocalDateTime.now().format(FMT);
        String entry = String.format("[%s] [%s] %s", timestamp, level, message);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            bw.write(entry);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        log(Level.INFO,  "Server started on port 8080");
        log(Level.INFO,  "User 'admin' logged in");
        log(Level.WARN,  "High memory usage detected: 85%");
        log(Level.ERROR, "Database connection pool exhausted");
    }
}

