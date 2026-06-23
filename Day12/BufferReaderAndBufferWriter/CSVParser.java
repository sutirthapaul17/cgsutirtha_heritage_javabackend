package BufferReaderAndBufferWriter;

import java.io.*;

public class CSVParser {
    public static void parseCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int rowNum = 0;
            while ((line = br.readLine()) != null) {
                rowNum++;
                String[] cols = line.split(",");
                if (rowNum == 1) {
                    System.out.println("Headers: " + java.util.Arrays.toString(cols));
                } else {
                    System.out.printf("Row %d: Region=%-8s Product=%-8s Revenue=%s%n",
                            rowNum - 1, cols[0], cols[1], cols[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        parseCSV("BufferReaderAndBufferWriter/sales_report.txt");
    }
}

