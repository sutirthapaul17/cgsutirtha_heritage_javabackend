package Variables;


class Student5 {
    static int objectCount = 0;

    Student5() {
        objectCount++;
    }

    static void displayCount() {
        System.out.println("Total Objects Created: " + objectCount);
    }
}

public class q20 {
    public static void main(String[] args) {
        Student5 s1 = new Student5();
        Student5 s2 = new Student5();
        Student5 s3 = new Student5();
        Student5 s4 = new Student5();

        Student5.displayCount();
    }
}