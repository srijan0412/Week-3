import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // Method to find the longest consecutive sequence 
    public static int findLongestConsecutiveSequence(int array[]) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : array) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : array) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;   
    }
    public static void main(String[] args) {
        // Taking sample array for testing.
        System.out.println("Taking the sample array as below: ");
        System.out.println("{100, 4, 200, 1, 3, 2}"); // Output should be 4 -> [1, 2, 3, 4]
        int array[] = {100, 4, 200, 1, 3, 2};

        // Ouput 
        int result = findLongestConsecutiveSequence(array);
        System.out.println("This is maximum consecutive sequence is of " + result + " length.");
    }
}
