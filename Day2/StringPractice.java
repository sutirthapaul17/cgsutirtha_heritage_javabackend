public class StringPractice {
    public static void main(String[] args) {
        String name1 = "Alice";
        String name2 = "Alice";
        System.out.println(name1 == name2);

        System.out.println(name1.equals(name2));

        System.out.println(name1.equalsIgnoreCase("ALICE"));

        String dept = null;
        System.out.println("Finance".equals(dept));

    }
}
