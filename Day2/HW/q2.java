package HW;

public class q2 {
    public static void main(String[] args) {

        String employeeName = "Sutirtha";
        String department = "Engineering";
        String email = "sutirtha@example.com";

        System.out.println("Employee Name: " + employeeName);
        System.out.println("Department: " + department);
        System.out.println("Email: " + email);

        String name1 = new String("John");
        String name2 = new String("John");

        System.out.println("\nUsing == : " + (name1 == name2));
        System.out.println("Using .equals() : " + name1.equals(name2));
    }
}
