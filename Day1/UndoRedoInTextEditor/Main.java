package UndoRedoInTextEditor;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.addState("Hello, Java!");
        
        editor.displayCurrentState(); // Hello, Java!

        editor.undo(); // Hello, World!
        editor.undo(); // Hello, World
        editor.displayCurrentState(); // Hello, World

        editor.redo(); // Hello, World!
        editor.displayCurrentState(); // Hello, World!
    }
}
