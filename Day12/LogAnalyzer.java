import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogAnalyzer {
    // Read all lines containing a keyword from a log file
    public static List<String> filterLines(String filename, String keyword) {
        List<String> matches = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                lineNum++;
                if (line.toLowerCase().contains(keyword.toLowerCase())) {
                    matches.add("Line " + lineNum + ": " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return matches;
    }

    public static void main(String[] args) {
        List<String> errors = filterLines("app.log", "ERROR");
        System.out.println("Found " + errors.size() + " error(s):");
        errors.forEach(System.out::println);
    }
}

