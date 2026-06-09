package HW;

public class q5 {
    public static void main(String[] args) {

        String ageStr = "24";
        String salaryStr = "75000.50";

        int age = Integer.parseInt(ageStr);
        double salary = Double.parseDouble(salaryStr);

        int ageAfterOneYear = age + 1;
        double salaryAfterBonus = salary + 5000.0;

        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);

        System.out.println("\nAfter Arithmetic Operations:");
        System.out.println("Age after 1 year: " + ageAfterOneYear);
        System.out.println("Salary after bonus: " + salaryAfterBonus);
    }
}
