package HW;

public class q3 {
    public static void main(String[] args) {

        byte byteValue = 10;

        short shortValue = byteValue;
        int intValue = shortValue;
        long longValue = intValue;
        float floatValue = longValue;
        double doubleValue = floatValue;

        System.out.println("byte value   : " + byteValue);
        System.out.println("short value  : " + shortValue);
        System.out.println("int value    : " + intValue);
        System.out.println("long value   : " + longValue);
        System.out.println("float value  : " + floatValue);
        System.out.println("double value : " + doubleValue);
    }
}
