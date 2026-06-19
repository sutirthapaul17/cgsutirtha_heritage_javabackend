// Create an Employee class and calculate yearly salary using a method

package ClassesAndObjects;

class Employee {
    int empId;
    String name;
    double monthlySalary;

    Employee(int empId, String name, double monthlySalary) {
        this.empId = empId;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    double calculateYearlySalary() {
        return monthlySalary * 12;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: ₹" + monthlySalary);
        System.out.println("Yearly Salary: ₹" + calculateYearlySalary());
    }
}

public class q5 {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "Sutirtha", 50000);
        emp.displayDetails();
    }
}