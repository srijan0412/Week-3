import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;


public class SlidingWindowMaximum {
    public static List<Integer> calculateSlidingWindowMaximum(int[] array, int windowSize) {
        int arrayLength = array.length;
        
        List<Integer> slidingWindowMaximum = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        for (int i = 0; i < arrayLength; i++) {
            if (!deque.isEmpty() && deque.getFirst() <= i - windowSize) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && array[deque.getLast()] <= array[i]) {
                deque.removeLast();
            }
            deque.addLast(i);

            if (i >= windowSize-1) {
                slidingWindowMaximum.add(array[deque.getFirst()]);
            }
        }
        return slidingWindowMaximum;
    }
    public static void main(String[] args) {
        // Defining a sample array to demonstrate the problem 
        System.out.println("Taking the sample data as following");
        System.out.println("{1, 3, -1, -3, 5, 3, 7, 1, 6}");
        int sampleArray[] = {1, 3, -1, -3, 5, 3, 7, 1, 6};

        // Calling the calculate sliding window maximum function 
        int windowSize = 3;
        List<Integer> slidingWindowMaximum = calculateSlidingWindowMaximum(sampleArray, windowSize);

        // Output 
        System.out.println("Sliding window maximum is : ");
        for (int element : slidingWindowMaximum) {
            System.out.print(element + ", ");
        }
    }    
}
