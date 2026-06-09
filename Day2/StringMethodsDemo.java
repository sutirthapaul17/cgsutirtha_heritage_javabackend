public class StringMethodsDemo {
    public static void main(String[] args) {

        String rawName  = "  alice johnson  ";
        String empCode  = "EMP-HR-1042";
        String email    = "alice@corporatesguide.com";

        String trimmed   = rawName.trim();
        String formatted = trimmed.toUpperCase();
        int    nameLen   = trimmed.length();
        String dept     = empCode.substring(4, 6);
        String idPart   = empCode.substring(7);
        char   firstChar = empCode.charAt(0);
        boolean isEmp   = empCode.startsWith("EMP");
        boolean hasHR   = empCode.contains("HR");
        boolean isEmail = email.endsWith(".com");


        System.out.println("Name: "    + formatted);
        System.out.println("Dept: "    + dept);
        System.out.println("Is Employee: " + isEmp);
    }
}

