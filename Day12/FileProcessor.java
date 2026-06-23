import java.io.*;

public class FileProcessor {
    public static void main(String[] args) {
        // IOException is a checked exception — MUST handle it
        try {
            FileReader fr = new FileReader("report.txt");  // File might not exist!
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            System.out.println("First line: " + line);
            br.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}

