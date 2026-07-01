import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Pattern: map.getOrDefault(key, 0) + 1
public class FrequencyCount {

    // 1. Word frequency in a sentence
    public static Map<String, Integer> wordFrequency(String sentence) {
        Map<String, Integer> freq = new HashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return freq;
    }

    // 2. Character frequency
    public static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }

    // 3. Find first non-repeating character
    public static char firstUnique(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        for (Map.Entry<Character, Integer> e : freq.entrySet())
            if (e.getValue() == 1) return e.getKey();
        return '\0';
    }

    public static void main(String[] args) {
        // Word frequency
        System.out.println(wordFrequency("apple banana apple cherry banana apple"));
        // {apple=3, banana=2, cherry=1}

        // Char frequency
        System.out.println(charFrequency("hello"));
        // {h=1, e=1, l=2, o=1}

        // First unique char
        System.out.println(firstUnique("aabbcde")); // c
    }
}
