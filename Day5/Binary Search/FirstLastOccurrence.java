public class FirstLastOccurrence {
    // Method to find the first occurence 
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1; // Continue searching in the left half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    // Method to find the last occurence 
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1; // Continue searching in the right half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    // Method to return both first and the last occurence 
    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        // Defining a sample array and sample target for testing. 
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        // Calculating the first and the last occurence 
        int[] result = findFirstAndLast(arr, target);

        // Output 
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}