package finalKeyword;


final class EncryptionKey { 
    private final String keyValue; 
    private final String algorithm; 

    EncryptionKey(String key, String algo) { 
        this.keyValue = key; 
        this.algorithm = algo; 
    } 
    String getKey() { return keyValue; } 
    String getAlgorithm() { return algorithm; } 

    @Override 
    public String toString() { 
        return "[" + algorithm + "] Key: " + keyValue.substring(0, 4) + "****"; 
    } 
} 
// This would cause a COMPILE ERROR: 
// class HackedKey extends EncryptionKey { }  // Cannot subclass final! 
// Famous Java final classes: 
// java.lang.String      — immutable text 
// java.lang.Integer     — immutable int wrapper 
// java.lang.Math        — utility class 
// java.lang.System      — system operations 

public class FinalClass { 
    public static void main(String[] args) { 
        EncryptionKey key = new EncryptionKey("AES256SECRETKEY", "AES"); 
        System.out.println(key); 
        // String is final class — can't be subclassed 
        String s = "Hello Java"; 
        System.out.println(s.toUpperCase());  // HELLO JAVA 
    }
}