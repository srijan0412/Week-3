import java.util.HashSet;

public class RemoveDuplicates {
    // Method to remove duplicates characters from the string 
    public static String removeDuplicates (String sampleString) {
        // Createing a new StringBuilder object.
        StringBuilder sb = new StringBuilder();

        // Creating a hashmap object to keep track of the repeating characters 
        HashSet<Character> hashSet = new HashSet<>();

        // Removing the duplicates 
        for (int i = 0; i < sampleString.length(); i++) {
            if (!hashSet.contains(sampleString.charAt(i))) {
                hashSet.add(sampleString.charAt(i));
                sb.append(sampleString.charAt(i));
            }
        }        

        return sb.toString();
    }
    public static void main(String[] args) {
        // Creating a sample string to test
        String sampleString = "abaacddeffgggg";

        // Calling the remove duplicates function 
        String result = removeDuplicates(sampleString);

        // Output 
        System.out.println("Result is : " + result);
    }
}
