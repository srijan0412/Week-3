import java.util.HashMap;

class Pair {
    // Attributes 
    public int first;
    public int second;

    // Constructor 
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class TwoSumProblem {
    public static Pair findPairForGivenSum(int array[], int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(sum-array[i])) {
                return new Pair(hashMap.get(sum-array[i]), i);
            }
            hashMap.put(array[i], i);
        }
        return new Pair(1, 2);
    }
    public static void main(String[] args) {
        // Taking sample array for testing.
        System.out.println("Taking the sample array as below: ");
        System.out.println("{2, 4, 5, 7, 13}");
        int array[] = {2, 4, 5, 7, 13};

        // Finding pairs 
        int sum = 11; //sample
        Pair result = findPairForGivenSum(array, sum);

        // Output 
        System.out.println(sum + " can be produced by adding elements at index " + result.first + " and " + result.second);
    }
}
