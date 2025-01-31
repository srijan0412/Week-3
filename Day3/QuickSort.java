public class QuickSort {
    // Method to sort an integer array with Quick Sort algorithm
    public static void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Helper function for quick sort 
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Defining a sample array which stores the prices of 5 products
        int priceArray[] = {499, 351, 299, 799, 99}; //prices of 5 products

        // Sorting the array by Quick Sort
        quickSort(priceArray, 0, (priceArray.length - 1));

        // Output 
        System.out.println("The sorted price array is: ");
        for (int element : priceArray) {
            System.out.print(element + ", ");
        }
    }
}
