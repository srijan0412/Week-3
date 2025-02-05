public class FindPeakElement {
    // Method to find the peak element with binary search 
    public static int findPeakElement(int array[]) {
        int low = 0;
        int high = array.length - 1;
        while (high > low) {
            int mid = (low + high) / 2;
            if (array[mid] > array[mid+1]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        // Defining a sample rotated sorted array for testing
        int[] arr = {1, 3, 20, 4, 1, 0};

        // Calculating the peak index 
        int peakIndex = findPeakElement(arr);

        // Output 
        System.out.println("Peak element is: " + arr[peakIndex] + " at index " + peakIndex);
    }
}
