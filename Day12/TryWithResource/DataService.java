package TryWithResource;

// Custom class that implements AutoCloseable
class DatabaseConnection implements AutoCloseable {
    private String connectionString;
    private boolean open = false;

    public DatabaseConnection(String connStr) {
        this.connectionString = connStr;
        this.open = true;
        System.out.println("DB Connected: " + connStr);
    }

    public void executeQuery(String sql) {
        if (!open) throw new IllegalStateException("Connection is closed!");
        System.out.println("Executing: " + sql);
    }

    @Override
    public void close() {
        // This is called automatically by try-with-resources
        open = false;
        System.out.println("DB Connection closed: " + connectionString);
    }
}



public class DataService {
    public static void main(String[] args) {
        // DatabaseConnection.close() called AUTOMATICALLY after this block
        try (DatabaseConnection db = new DatabaseConnection("mysql://localhost/shop")) {
            db.executeQuery("SELECT * FROM orders WHERE status='PENDING'");
            db.executeQuery("UPDATE orders SET status='PROCESSING' WHERE id=101");
        }  // close() called here automatically
        System.out.println("Done — connection safely closed.");
    }
}


