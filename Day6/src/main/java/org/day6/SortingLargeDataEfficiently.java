package org.day6;

import java.util.Random;
import java.util.Arrays;

public class SortingLargeDataEfficiently {
//    Method to sort a large array efficiently using bubble sort algorithm
    public static void bubbleSort(int array[]) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

//    Method to sort a large array efficiently using mergeSort algorithm
    public static void mergeSort(int array[], int start, int end) {
        // Base Case
        if (start == end) {
            return;
        }

        // Recursive case
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);

        merge(array, start, mid, end); //Merging 2 sorted arrays
    }

//    Helper method for quick sort function
    private static void merge(int array[], int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        //Left and right array
        int left[] = new int[n1];
        int right[] = new int[n2];

        // Copying elements from start to mid in left
        int it = 0;
        for (int i = start; i <= mid; i++) {
            left[it] = array[i];
            it++;
        }

        // Copying elements from mid+1 to end in right
        it = 0;
        for (int i = mid + 1; i <= end; i++) {
            right[it] = array[i];
            it++;
        }

        // Merging 2 sorted arrays
        int l = 0;
        int r = 0;
        int k = start;
        while (l < n1 && r < n2) {
            if (left[l] < right[r]) {
                array[k] = left[l];
                l++;
                k++;
            }
            else {
                array[k] = right[r];
                r++;
                k++;
            }
        }

        while (l < n1) array[k++] = left[l++];
        while (r < n2) array[k++] = right[r++];
    }

//    Method to sort a large array efficiently using quickSort algorithm
    public static void quickSort(int array[], int start, int end) {
//        base case
        if (start >= end) {
            return;
        }

        int pi = partition(array, start, end);

//        Recursive case
        quickSort(array, start, (pi - 1)); //calling quicksort on left partition
        quickSort(array, (pi + 1), end); //calling quicksort on right partition
    }
    public static int partition(int array[], int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }

    // Helper function to generate random arrays
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000000);
        }
        return arr;
    }

    // Function to test sorting algorithms
    public static void testSortingAlgorithms(int size) {
        int[] arr1 = generateArray(size);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);

        long start, end;

        start = System.currentTimeMillis();
        bubbleSort(arr1);
        end = System.currentTimeMillis();
        System.out.println("Bubble Sort (" + size + " elements): " + (end - start) + " ms");

        start = System.currentTimeMillis();
        mergeSort(arr2, 0, arr2.length - 1);
        end = System.currentTimeMillis();
        System.out.println("Merge Sort (" + size + " elements): " + (end - start) + " ms");

        start = System.currentTimeMillis();
        quickSort(arr3, 0, arr3.length - 1);
        end = System.currentTimeMillis();
        System.out.println("Quick Sort (" + size + " elements): " + (end - start) + " ms");
    }
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            testSortingAlgorithms(size);
            System.out.println("-------------------------");
        }
    }
}
