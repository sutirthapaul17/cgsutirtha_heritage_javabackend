import java.util.HashMap;
import java.util.Map;

public class TopFrequentEle {

    public static void printTop3FrequentWords(String sentence) {

        String[] words = sentence.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
        String sentence = "Java is great. Java is powerful and Java is fun.";

        printTop3FrequentWords(sentence);
    }
}
