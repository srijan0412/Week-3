import java.util.Stack;

public class SortAStack {
    // Recursive method to sort a stack
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        // Base case 
        if (stack.empty()) {
            return stack;
        }
        
        // Extracting the top element
        int element = stack.peek();
        stack.pop();

        // Recursive call 
        Stack<Integer> sortedStack = sortStack(stack);

        // Checking if the stack is empty 
        if (sortedStack.empty()) {
            sortedStack.push(element);
            return sortedStack;
        }

        // Pushing the element on its position 
        Stack<Integer> tempStack = new Stack<Integer>();
        while (sortedStack.peek() > element) {
            tempStack.push(sortedStack.peek());
            sortedStack.pop();

            if (sortedStack.isEmpty()) break; //Edge case 
        }

        sortedStack.push(element);

        while (!tempStack.empty()) {
            sortedStack.push(tempStack.peek());
            tempStack.pop();
        }

        // Returing the sorted stack 
        return sortedStack;
    }
    
    public static void main(String[] args) {
        // Defining a stack 
        Stack<Integer> stack = new Stack<Integer>();

        // Adding sample elements to the stack 
        System.out.println("Elements are added in the following order to the stack: ");
        System.out.println("{6, 1, 5, 2, -1}");
        stack.add(6);
        stack.add(1);
        stack.add(5);
        stack.add(2);
        stack.add(-1);

        // Calling the recursive sort stack function 
        Stack<Integer> sortedStack = sortStack(stack);

        // Output 
        System.out.println("Output of the sorted stack: ");
        while (!sortedStack.empty()) {
            System.out.print(sortedStack.peek() + ", ");
            sortedStack.pop();
        }
    }
}
