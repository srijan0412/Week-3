public class InsertionSort {
    // Method to sort an integer array with Insertion sort algorithm
    public static int[] sortArray(int array[]) {
        int arraySize = array.length;

        for (int i = 1; i < arraySize; i++) {
            int key = array[i];
            int j = i - 1;
            // Move elements that are greater than key to one position ahead
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }


        return array;
    }

    public static void main(String[] args) {
        // Defining a sample array which stores the employee id of 5 employees
        int employeeIdArray[] = {102, 101, 105, 103, 104}; //Employee ID of 5 employees 

        // Sorting the array by InsertionSort
        int sortedMarksArray[] = sortArray(employeeIdArray);

        // Output 
        System.out.println("The sorted EmployeeID array is: ");
        for (int element : sortedMarksArray) {
            System.out.print(element + ", ");
        }
    }
}
