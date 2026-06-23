package Serialization;

import java.io.*;
import java.util.*;

public class EmployeeDatabase {
    private static final String DB_FILE = "employees.ser";

    // Save all employees
    public static void saveAll(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DB_FILE))) {
            oos.writeObject(employees);
            System.out.println("Saved " + employees.size() + " employees.");
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    // Load all employees
    @SuppressWarnings("unchecked")
    public static List<Employee> loadAll() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(DB_FILE))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load failed: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee(101, "Rahul", "HR", 60000, "pass1"));
        staff.add(new Employee(102, "Sneha", "Finance", 75000, "pass2"));
        staff.add(new Employee(103, "Arjun", "Tech", 90000, "pass3"));

        saveAll(staff);

        List<Employee> loaded = loadAll();
        System.out.println("Loaded " + loaded.size() + " employees:");
        loaded.forEach(System.out::println);
    }
}

