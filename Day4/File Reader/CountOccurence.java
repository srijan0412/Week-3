import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class CountOccurence {
    // Method to count the occurence of a word in a file
    public static int countOccurenceOfAWord(String filePath, String word) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String completeWord= "";
            int i;
            while((i = br.read()) != -1) {
                if ((char)i == ' ' || (char)i == '\n') {
                    if (hashMap.containsKey(completeWord)) {
                        hashMap.put(completeWord, hashMap.get(completeWord)+1);
                    }
                    else {
                        hashMap.put(completeWord, 1);
                    }
                    completeWord = "";
                }
                else {
                    completeWord += (char) i;
                }
            }
        } catch(IOException e) { //Catching the exception if any 
            e.printStackTrace();
        }
        
        if (hashMap.containsKey(word)) {
            return hashMap.get(word);
        }
        return -1; //-1 signifies the the word does not exits in the file 
    }
    public static void main(String[] args) {
        // Defining the file-path 
        String filePath = "sampleFile.txt";

        // Defining a sample word 
        String word = "This";

        // Calling the method to count the occurence fo a word in a file  
        int result = countOccurenceOfAWord(filePath, word);

        // Output 
        System.out.println("The occurence of the word \"" + word + "\" in the file is :" + result);
    }
}
