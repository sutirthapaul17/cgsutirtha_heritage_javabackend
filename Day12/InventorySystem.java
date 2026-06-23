// Custom unchecked exception (extends RuntimeException)
class InvalidProductCodeException extends RuntimeException {
    public InvalidProductCodeException(String code) {
        super("Invalid product code format: '" + code + "'. Expected: PRD-XXXX");
    }
}

public class InventorySystem {
    public static void validateCode(String code) {
        // No try-catch needed since it's unchecked
        if (!code.matches("PRD-\\d{4}")) {
            throw new InvalidProductCodeException(code);
        }
        System.out.println("Valid code: " + code);
    }

    public static void main(String[] args) {
        validateCode("PRD-1234");   // Valid
        validateCode("ITEM-ABC");   // Throws InvalidProductCodeException
    }
}

