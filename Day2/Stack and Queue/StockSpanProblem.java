import java.util.Stack;

public class StockSpanProblem {
    public static int[] calculateSpan(int[] stock) {
        // Initializing the result array 
        int stockSize = stock.length;
        int result[] = new int[stockSize];

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < stockSize; i++) {
            if (stack.empty()) {
                stack.push(i);
                result[i] = 1;
                continue;
            }
            
            while (stock[stack.peek()] <= stock[i]) {
                stack.pop();
                if (stack.empty()) {
                    result[i] = 1;
                    stack.push(i);
                    continue;
                };
            }

            
            result[i] = i - stack.peek();
            
            stack.push(i);
        }

        // Returning the result 
        return result;
    }
    public static void main(String[] args) {
        // defining a sample array to demonstrate the stock span 
        System.out.println("Taking the sample data for testing: ");
        System.out.println("[100, 80, 60, 70, 60, 75, 85]");

        int stockSpan[] = {100, 80, 60, 70, 60, 75, 85};
        int span[] = calculateSpan(stockSpan);

        // Output 
        System.out.println("Stock span : ");
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + ", ");
        }
    }   
}
