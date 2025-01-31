import java.util.HashMap;
import java.util.ArrayList;

class Pair {
    public int first;
    public int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class SubarraysWithSumZero {
    // Method to print all the sub arrays with sum as zero 
    public static void findSubArraysWithZeroSum(int array[]) {
        // Initializing the hashmap
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        
        // Initialinght array list with pair to store the subarray starting and ending index 
        ArrayList<Pair> result = new ArrayList<>();

        // Calculating the subarrays with zero sum 
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (sum == 0) {
                Pair pair = new Pair(0, i);
                result.add(pair);
            }

            ArrayList<Integer> arrayList = new ArrayList<>();
            if (hashMap.containsKey(sum)) {
                arrayList = hashMap.get(sum);
                for (int j = 0; j < arrayList.size(); j++) {
                    Pair pair = new Pair(arrayList.get(j)+1, i);
                    result.add(pair);
                }
            }

            arrayList.add(i);
            hashMap.put(sum, arrayList);
        }

        // Printing the output 
        for (Pair pair : result) {
            System.out.println("Subarray exist from " + pair.first + " to " + pair.second);
        }
    }

    public static void main(String[] args) {
        // Taking sample array for testing.
        System.out.println("Taking the sample array as below: ");
        System.out.println("{6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7}");
        int array[] = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};

        // Output 
        findSubArraysWithZeroSum(array);
    }
}
