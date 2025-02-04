//Concatinate string using string buffer 
public class ConcantinateString {
    public static String concatString(String string1, String string2) {
        // Creating a string a buffer object 
        StringBuffer sb = new StringBuffer();

        // Iterating over the strings and appending it to the string buffer 
        for (int i = 0; i < string1.length(); i++) {
            sb.append(string1.charAt(i));
        }

        for (int i = 0; i < string2.length(); i++) {
            sb.append(string2.charAt(i));
        }

        // Returning the string 
        return sb.toString();
    }
    public static void main(String[] args) {
        // Creating a sample string to test the concatination function 
        String sampleString1 = "Hello ";
        String sampleString2 = "world!";

        // Calling the concatString function 
        String result = concatString(sampleString1, sampleString2);

        // Output 
        System.out.println("The concatinated string is : " + result);
    }
}
