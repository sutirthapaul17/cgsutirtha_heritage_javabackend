import java.io.File;

public class FileExplorer {
    public static void main(String[] args) {
        File file = new File("report.txt");

        // Check if file exists
        System.out.println("Exists: " + file.exists());
        System.out.println("Name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());

        // Create a new file
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (java.io.IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }

        // List files in a directory
        File dir = new File("./logs");
        if (dir.exists() && dir.isDirectory()) {
            for (String name : dir.list()) {
                System.out.println(" - " + name);
            }
        }
    }
}

