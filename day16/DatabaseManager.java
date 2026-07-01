public class DatabaseManager {
    // volatile ensures visibility across threads
    private static volatile DatabaseManager instance;
    private String connectionUrl;
    private int poolSize;

    // Private constructor — prevents external instantiation
    private DatabaseManager() {
        this.connectionUrl = "jdbc:mysql://localhost:3306/mydb";
        this.poolSize = 10;
        System.out.println("DatabaseManager initialized");
    }

    // Double-checked locking — thread safe + performant
    public static DatabaseManager getInstance() {
        if (instance == null) {                         // 1st check (no lock)
            synchronized (DatabaseManager.class) {
                if (instance == null) {                 // 2nd check (with lock)
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }

    public void executeQuery(String sql) {
        System.out.println("Executing on " + connectionUrl + ": " + sql);
    }

    public static void main(String[] args) {
        DatabaseManager db1 = DatabaseManager.getInstance();
        DatabaseManager db2 = DatabaseManager.getInstance();

        System.out.println(db1 == db2); // true — same instance!
        db1.executeQuery("SELECT * FROM users");
    }
}
