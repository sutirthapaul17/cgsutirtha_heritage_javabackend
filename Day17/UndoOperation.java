import java.util.ArrayDeque;

class TextEditor {
    private ArrayDeque<String> undoStack;
    private ArrayDeque<String> redoStack;
    private String currentText;
    public TextEditor() {
        undoStack = new ArrayDeque<>();
        redoStack = new ArrayDeque<>();
        currentText = "";
    }
    public void write(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }
        undoStack.push(currentText);
        currentText += text;
        redoStack.clear();
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        redoStack.push(currentText);
        currentText = undoStack.pop();
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }
        undoStack.push(currentText);
        currentText = redoStack.pop();
    }
    public String getText() {
        return currentText;
    }
}

public class UndoOperation {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.write("Hello");
        System.out.println(editor.getText());

        editor.write(" World");
        System.out.println(editor.getText());

        editor.write("!");
        System.out.println(editor.getText());

        editor.undo();
        System.out.println("After Undo: " + editor.getText());

        editor.undo();
        System.out.println("After Undo: " + editor.getText());

        editor.redo();
        System.out.println("After Redo: " + editor.getText());

        editor.write(" Java");
        System.out.println(editor.getText());

        editor.redo();
    }
}