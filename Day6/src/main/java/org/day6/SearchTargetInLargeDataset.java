package org.day6;

public class SearchTargetInLargeDataset {
//    Method to search an element in an array by linear search approach
    public static int linearSearch(int array[], int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; //Element not fount case
    }

//    Method to search an element in an array by binary search approach
    public static int binarySearch(int array[], int target) {
        int low = 0;
        int high = array.length - 1;
        while (high > low) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1; // Element not found case
    }
    public static void main(String[] args) {
        // Defining sample arrays for time complexity analysis
        int smallDataSet[] = new int[1000];
        int mediumDataSet[] = new int[10000];
        int largeDataSet[] = new int[1000000];

        // Filling the data set with some values
        for (int i = 1; i <= 1000000; i++) {
            if (i <= 1000) {
                smallDataSet[i-1] = i;
            }
            if (i <= 10000) {
                mediumDataSet[i-1] = i;
            }
            largeDataSet[i-1] = i;
        }

        // Testing and calculating the time for linear Search
        long timeframe1 = System.nanoTime();
        int result1 = linearSearch(smallDataSet, 123);
        long timeframe2 = System.nanoTime();
        int result2 = linearSearch(mediumDataSet, 1230);
        long timeframe3 = System.nanoTime();
        int result3 = linearSearch(largeDataSet, 12300);
        long timeframe4 = System.nanoTime();

        // Displaying the Time complexity result
        System.out.println("Analysis for Linear Search");
        System.out.println("Time taken for 1000 Iterations : " + (timeframe2 - timeframe1));
        System.out.println("Time taken for 10,000 Iterations : " + (timeframe3 - timeframe2));
        System.out.println("Time taken for 10,00,000 Iterations : " + (timeframe4 - timeframe3));
        System.out.println("Results are as follow: ");
        System.out.println("Result for Test 1: " + result1);
        System.out.println("Result for Test 2: " + result2);
        System.out.println("Result for Test 3: " + result3);

        // Testing and calculating the time for binary Search
        long timeframe21 = System.nanoTime();
        int result21 = binarySearch(smallDataSet, 123);
        long timeframe22 = System.nanoTime();
        int result22 = binarySearch(mediumDataSet, 1230);
        long timeframe23 = System.nanoTime();
        int result23 = binarySearch(largeDataSet, 12300);
        long timeframe24 = System.nanoTime();

        // Displaying the Time complexity result
        System.out.println("Analysis for Linear Search");
        System.out.println("Time taken for 1000 Iterations : " + (timeframe22 - timeframe21));
        System.out.println("Time taken for 10,000 Iterations : " + (timeframe23 - timeframe22));
        System.out.println("Time taken for 10,00,000 Iterations : " + (timeframe24 - timeframe23));
        System.out.println("Results are as follow: ");
        System.out.println("Result for Test 1: " + result21);
        System.out.println("Result for Test 2: " + result22);
        System.out.println("Result for Test 3: " + result23);
    }
}
