// Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and InputStreamReader
// Problem:
// Write a program that:
// Uses StringBuilder and StringBuffer to concatenate a list of strings 1,000,000 times.
// Uses FileReader and InputStreamReader to read a large file (e.g., 100MB) and print the number of words in the file.
// Approach:
// StringBuilder and StringBuffer:
// Create a list of strings (e.g., "hello").
// Concatenate the strings 1,000,000 times using both StringBuilder and StringBuffer.
// Measure and compare the time taken for each.
// FileReader and InputStreamReader:
// Read a large text file (100MB) using FileReader and InputStreamReader.
// Count the number of words by splitting the text on whitespace characters.
// Print the word count and compare the time taken for reading the file.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompareEverything {
    // Method to compare String builder and String buffer for appending 1M times 
    public static void compareStringBuilderAndStringBuffer() {
        // Defining an StringBuilder and StringBuffer Class object 
        StringBuilder sBulider = new StringBuilder();
        StringBuffer sBuffer = new StringBuffer();

        // Calculating the time taken by StringBuilder to store 1M appends 
        long startTime1 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) { //This will run 1M times
            sBulider.append("Hello");
        }
        long endTime1 = System.nanoTime();

        // Calculating the time taken by StringBuffer to store 1M appends
        long startTime2 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) { //This will run 1M times
            sBuffer.append("Hello");
        }
        long endTime2 = System.nanoTime();

        System.out.println("The time taken  to store 1M appends: ");
        System.out.println("StringBuilder: " + (endTime1-startTime1));
        System.out.println("StringBuffer: " + (endTime2-startTime2));
        if ((endTime1-startTime1) > (endTime2-startTime2)) {
            System.out.println("StringBuffer is faster.");
        }
        else {
            System.out.println("StringBuilder is faster.");
        }
    }

    // Method to read large file and count all the words that it has 
    public static void countWordsInFile() {
        // Path of the file that is been readen
        String filePath = "largeFile.txt";

        // Count variable to store the count of number of words 
        int count = 0;

        // Using bufferedReader to read and count the words in the file
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = null;
            while ((line = br.readLine()) != null) {
                String arr[] = line.split("\\s+");
                count += arr.length;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Displaying the answer 
        System.out.println("The total number of words the file has are " + count);
    }

    public static void main(String[] args) {
        // Comparing String builder and string buffer 
        compareStringBuilderAndStringBuffer();
        System.out.println("----------------------------------------------------");

        // Reading large file and Displaying the count of words it has 
        countWordsInFile();
    }    
}
