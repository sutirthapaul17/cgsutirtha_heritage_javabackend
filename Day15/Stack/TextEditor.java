package Stack;
import java.util.ArrayDeque;
import java.util.Deque;


public class TextEditor {
    private StringBuilder text = new StringBuilder();
    private Deque<String> history = new ArrayDeque<>();


    public void type(String word) {
        history.push(word);    // save for undo
        text.append(word);
        System.out.println("Text: " + text);
    }


    public void undo() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        String last = history.pop();
        text.delete(text.length() - last.length(), text.length());
        System.out.println("After Undo: " + text);
    }


    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.type("Hello ");  // Text: Hello
        editor.type("World");   // Text: Hello World
        editor.type("!");       // Text: Hello World!
        editor.undo();           // After Undo: Hello World
        editor.undo();           // After Undo: Hello
    }
}
