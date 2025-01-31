public class MergeSort {
    // Method to sort an integer array with Merge Sort algorithm
    public static void mergeSort(int array[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    // Helper function 
    private static void merge(int array[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        System.arraycopy(array, left, leftArr, 0, n1);
        System.arraycopy(array, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }
        while (i < n1) array[k++] = leftArr[i++];
        while (j < n2) array[k++] = rightArr[j++];

    }
    
    public static void main(String[] args) {
        // Defining a sample array which stores the prices of 5 books
        int priceArray[] = {499, 351, 299, 799, 99}; //prices of 5 books

        // Sorting the array by Mergesort
        mergeSort(priceArray, 0, priceArray.length - 1);

        // Output 
        System.out.println("The sorted price array is: ");
        for (int element : priceArray) {
            System.out.print(element + ", ");
        }
    }
}
