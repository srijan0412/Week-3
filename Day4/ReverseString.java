public class ReverseString {
    public static void main(String[] args) {

        // Createing a new StringBuilder object.
        StringBuilder sb = new StringBuilder();
        
        // Appending "Hello"
        sb.append("Hello");

        // Reversing the String String builder 
        sb.reverse();

        // Output 
        System.out.println("The reverse of the string is  " + sb);
    }
}