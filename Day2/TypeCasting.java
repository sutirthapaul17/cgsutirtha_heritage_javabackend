public class TypeCasting {
    public static void main(String[] args) {

        int    empId   = 1042;
        long   empLong = empId;
        float  empFloat = empId;
        double empDouble = empId;

        System.out.println(empId);
        System.out.println(empLong);
        System.out.println(empFloat);
        System.out.println(empDouble);


        int baseSalary = 50000;
        double withBonus = baseSalary + 5000.50;
        System.out.println(withBonus);



        double preciseRating = 4.87;
        int    roundedRating = (int) preciseRating;
        System.out.println(roundedRating);

        double salary = 85000.99;
        int    salaryCasted = (int) salary;

        long bigNumber = 9876543210L;
        int  smallNumber = (int) bigNumber;


        double value = 250.75;
        if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
            int safe = (int) value;
            System.out.println("Safe cast: " + safe);
        }

        String ageInput = "25";
        int age = Integer.parseInt(ageInput);
        double sal = Double.parseDouble("85000.50");

    }
}
