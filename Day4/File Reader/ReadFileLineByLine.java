import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileLineByLine {
    // Method to read a file line by line 
    public static void readFileLineByLine(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = br.readLine()) != null) { //Readng file line by line 
                System.out.println(line);
            }
        } catch(IOException e) { //Catching the exception if any 
            e.printStackTrace();
        }        
    }
    public static void main(String[] args) {
        // Defining the file-path 
        String filePath = "sampleFile.txt";

        // Calling the method to read the file line by line 
        readFileLineByLine(filePath);
    }
}
