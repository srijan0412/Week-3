import java.util.Stack;
import java.util.Scanner;

public class QueueByStacks {
    public static void main(String[] args) {
        // Creating a scanner class object to take input from the user 
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        // Taking count as input from the user 
        System.out.println("How many elements do you want to add in the queue?");
        int count = sc.nextInt();

        // Taking input in the stack1 
        while (count > 0) {
            System.out.print("Enter the element: ");
            int element = sc.nextInt();
            stack1.push(element);
            count--;
        }

        // Putting elements from stack1 to stack2 
        while (!stack1.empty()) {
            stack2.push(stack1.peek());
            stack1.pop();
        }

        // Output of a queue 
        System.out.println("Displaying elements in the order of a queue: ");
        while (!stack2.empty()) {
            System.out.print( stack2.peek() + ", ");
            stack2.pop();
        }

        // Closing the scanner class object 
        sc.close();
    }
}
