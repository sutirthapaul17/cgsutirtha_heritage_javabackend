package HW;

public class q4 {
    public static void main(String[] args) {

        double salary = 75000.99;
        int salaryInt = (int) salary;

        System.out.println("Original Salary (double): " + salary);
        System.out.println("Salary after casting to int: " + salaryInt);

        float rating = 4.8f;
        int ratingInt = (int) rating;

        System.out.println("\nOriginal Rating (float): " + rating);
        System.out.println("Rating after casting to int: " + ratingInt);
    }
}
