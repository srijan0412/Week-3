public class ReverseString {
    public static String reverseString(String sampleString) {
        // Creating a new StringBuilder object.
        StringBuilder sb = new StringBuilder();
        
        // Appending "Hello"
        sb.append(sampleString);

        // Reversing the String String builder 
        sb.reverse();

        return sb.toString();
    }
    public static void main(String[] args) {
        // Defining a sample string to test 
        String sampleString = "Hello";

        // Calling the reverseString function 
        String result = reverseString(sampleString);

        // Output 
        System.out.println("The reverse of the string is  " + result);
    }
}