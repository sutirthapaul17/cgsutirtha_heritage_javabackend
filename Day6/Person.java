public class Person { 

    private String ssn = "XXX-XX-1234";  
    String city = "Mumbai";   
    protected String familyName = "Sharma";
    public String nickname = "Sunny";

    void showAll() { 
        System.out.println(ssn + " | " + city + " | " + familyName + " | " + nickname); 

    } 

} 

class SamePackageTest { 

    public static void main(String[] args) { 

        Person p = new Person(); 

        // System.out.println(p.ssn);     // ERROR - private, not accessible 

        System.out.println(p.city);        // OK - default, same package 

        System.out.println(p.familyName);  // OK - protected, same package 

        System.out.println(p.nickname);    // OK - public 

    } 

} 