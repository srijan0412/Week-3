package UndoRedoInTextEditor;

// Node representing a state in the text editor
class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

public class TextEditor {
    // Attributes 
    private TextState head, current;
    private final int MAX_HISTORY = 10;
    private int size = 0;

    // Constructor 
    public TextEditor() {
        this.head = null;
        this.current = null;
    }

    // Method to add a new state (simulating typing or an action)
    public void addState(String newText) {
        TextState newState = new TextState(newText);

        // If it's the first state
        if (head == null) {
            head = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
        }

        // Limit the history size
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo function (move to the previous state)
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo function (move to the next state)
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}
