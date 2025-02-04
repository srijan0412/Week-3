import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;

public class ReadAndWriteToFile {
    public static void main(String[] args) {
        // Defining a path to the sample file
        String filePath = "sampleFile.txt";
        
        // Applying try-catch block to take input using bufferdInputStream
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // Taking input from the user 
            System.out.println("Enter the String you want to save in the file");
            String userInput = br.readLine();

            // Defining a file-Writer object to write the data from the user to the file
            FileWriter fWriter = new FileWriter(filePath);
            fWriter.append(userInput);

            // Displaying the output 
            System.out.println("The data has been successfully stored to the file.");
            fWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
