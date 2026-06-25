abstract class Employee {
    protected int empId;
    protected String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + calculateSalary());
    }
}

class PermanentEmployee extends Employee {
    private double basicSalary;
    private double hra;
    private double bonus;

    public PermanentEmployee(int empId, String name,
                             double basicSalary,
                             double hra,
                             double bonus) {
        super(empId, name);
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + hra + bonus;
    }
}

class ContractEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public ContractEmployee(int empId, String name,
                            int hoursWorked,
                            double hourlyRate) {
        super(empId, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {

        Employee emp1 = new PermanentEmployee(
                101,
                "Rahul",
                50000,
                10000,
                5000
        );

        Employee emp2 = new ContractEmployee(
                102,
                "Priya",
                160,
                500
        );

        System.out.println("=== Permanent Employee ===");
        emp1.displayDetails();

        System.out.println("\n=== Contract Employee ===");
        emp2.displayDetails();
    }
}