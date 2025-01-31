public class BubbleSort {
    // Method to sort an integer array with bubble sort algorithm
    public static int[] sortArray(int array[]) {
        int arraySize = array.length;

        for (int i = 0; i < arraySize-1; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    // swapping the values 
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }
    public static void main(String[] args) {
        // Defining a sample marks array which stores the marks of 5 students 
        int marksArray[] = {75, 50, 95, 85, 66}; //marks of 5 students 

        // Sorting the array by bubble sort 
        int sortedMarksArray[] = sortArray(marksArray);

        // Output 
        System.out.println("The sorted marks array is: ");
        for (int element : sortedMarksArray) {
            System.out.print(element + ", ");
        }
    }
}
