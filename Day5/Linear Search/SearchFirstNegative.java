public class SearchFirstNegative {
    // Method to find the first negative number using Linear Search 
    public static int findFirstNegative(int array[]) {
        // Iterating to find the first negative 
        for (int i = 0; i < array.length; i++) {    
            if (array[i] < 0) {
                return array[i];
            }
        }

        return 0; //No negative number exist in the array 
    }
    public static void main(String[] args) {
        // Defining a sample array for testing the program
        System.out.println("Taken sample array as {1, 2, -3, -5, 4, 9, -8}");
        int sampleArray[] = {1, 2, -3, -5, 4, 9, -8};

        // Calling the findFirstNegative() method 
        int firstNegative = findFirstNegative(sampleArray);

        // Displaying the output 
        System.out.println("The first negative Integer in the array is " + firstNegative);
    }
}
