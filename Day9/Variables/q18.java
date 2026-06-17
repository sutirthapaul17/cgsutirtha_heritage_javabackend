package Variables;


class Employee {
    static int count = 0;

    Employee() {
        count++;
    }

    static void displayCount() {
        System.out.println("Total Employees: " + count);
    }
}

public class q18 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();

        Employee.displayCount();
    }
}