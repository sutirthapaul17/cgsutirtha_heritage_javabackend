public class TernaryOp {

    public static void main(String[] args) {

        int salary = 85000;
        String grade = (salary >= 80000) ? "Senior" : "Junior";
        System.out.println(grade);

        String grade2;
        if (salary >= 80000) {
            grade2 = "Senior";
        } else {
            grade2 = "Junior";
        }

        boolean isActive = true;
        String status = isActive ? "Active" : "Inactive";
        System.out.println("Status: " + status);

    }
}
