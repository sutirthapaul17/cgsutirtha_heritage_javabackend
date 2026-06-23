import java.io.*;

public class DocumentAnalyzer {
    public static void analyze(String filename) {
        int lines = 0, words = 0, chars = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length();
                if (!line.trim().isEmpty()) {
                    words += line.trim().split("\\s+").length;
                }
            }
            System.out.printf("File: %s%n", filename);
            System.out.printf("Lines: %,d%n", lines);
            System.out.printf("Words: %,d%n", words);
            System.out.printf("Characters: %,d%n", chars);
        } catch (IOException e) {
            System.out.println("Analysis failed: " + e.getMessage());
        }
    }
}

