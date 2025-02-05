public class SearchProblems {
    // Method to find the missing positive number 
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    
    // Method to search an element in an array 
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // Defining a sample array for testing 
        int[] arr = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(arr));
        
        // Defining a sample array and sample target for testing 
        int[] sortedArr = {1, 2, 3, 4, 5};
        int target = 3;
        System.out.println("Target Index: " + binarySearch(sortedArr, target));
    }
}
