import java.io.*;
import java.sql.*;

public class DataExporter {
    // Method can throw two different checked exceptions
    public static void exportToFile(String query) throws IOException, SQLException {
        // Connect to DB — may throw SQLException
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Write to file — may throw IOException
        FileWriter fw = new FileWriter("export.csv");
        while (rs.next()) {
            fw.write(rs.getString(1) + "\n");
        }
        fw.close();
        conn.close();
        System.out.println("Export complete!");
    }
}

