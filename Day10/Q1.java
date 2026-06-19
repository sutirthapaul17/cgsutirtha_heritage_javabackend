//1. Employee Management System
//Create an Employee class with:
//private fields
//constructor overloading
//getters/setters
//overridden toString()
//Implement Full-Time and Part-Time employees using inheritance.

class Employee {
    private int empId;
    private String name;

    Employee() {
        empId = 0;
        name = "Null";
    }

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId +
                "\nName: " + name;
    }
}

class FullTimeEmployee extends Employee {
    private double salary;

    FullTimeEmployee(int empId, String name, double salary) {
        super(empId, name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEmployee Type: Full-Time" +
                "\nMonthly Salary: " + salary;
    }

}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    PartTimeEmployee(int empId, String name, double hourlyRate, int hoursWorked) {
        super(empId, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEmployee Type: Part-Time" +
                "\nHourly Rate: " + hourlyRate +
                "\nHours Worked: " + hoursWorked +
                "\nTotal Salary: " + (hourlyRate * hoursWorked);
    }

}

public class Q1 {
    public static void main(String[] args) {

        Employee emp1 = new FullTimeEmployee(101, "Rahul", 50000);
        Employee emp2 = new PartTimeEmployee(102, "Diya", 500, 40);

        System.out.println("----- Full-Time Employee -----");
        System.out.println(emp1);

        System.out.println("\n----- Part-Time Employee -----");
        System.out.println(emp2);
    }
}