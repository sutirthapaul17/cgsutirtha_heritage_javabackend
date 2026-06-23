package Serialization;
import java.io.*;

public class EmployeeSerializer {
    public static void saveEmployee(Employee emp, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            oos.writeObject(emp);  // Convert object to bytes and write to file
            System.out.println("Employee saved to: " + filename);
        } catch (IOException e) {
            System.out.println("Serialization failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee(101, "Ananya Sharma", "Engineering", 85000, "secret123");
        System.out.println("Before save: " + emp);
        saveEmployee(emp, "employee.ser");
    }
}


