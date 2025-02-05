public class RotatedSortedArray {
    // Method to find the point of rotation in a rotated sorted array
    public static int findRotationPoint(int array[]) {
        int low = 0;
        int high = array.length - 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if (array[mid] > array[low]) {
                low = mid+1;
            }
            else if (array[mid] < array[low]) {
                high = mid-1;
            }
            else {
                low++;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        // Defining a sample rotated sorted array for testing 
        int sampleArray[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};

        // Calculating the rotation point 
        int index = findRotationPoint(sampleArray);

        // Output 
        System.out.println("Point of Rotation is on index: " + index);
    }
}
