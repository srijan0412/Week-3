import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    private static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaryDemands = {50000, 70000, 40000, 60000, 80000};
        System.out.println("Before Sorting: " + Arrays.toString(salaryDemands));
        heapSort(salaryDemands);
        System.out.println("After Sorting: " + Arrays.toString(salaryDemands));
    }
}

