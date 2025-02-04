public class CompareStringBufferAndStringBuilder {
    public static void compareStringBufferAndStringBuilder() {
        // Defining the ojects of both the stringBuilder and stringBuffer class
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        
        // Calculating the time it takes for the StringBuffer to append 1M strings
        long startTime1 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append("Hello");
        }
        long endTime1 = System.nanoTime();
        
        
        // Calculating the time it takes for the StringBuilder to append 1M strings
        long startTime2 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("Hello");
        }
        long endTime2 = System.nanoTime();
        
        // Output 
        System.out.println("The information is in Nano-Seconds");
        System.out.println("The time taken by the String buffer to append 1M Strings is " + (endTime1-startTime1));
        System.out.println("The time taken by the String buffer to append 1M Strings is " + (endTime2-startTime2));
        System.out.println("Observation: ");
        if ((endTime1-startTime1) > (endTime2 - startTime2)) {
            System.out.println("StringBuilder is faster.");
        }
        else {
            System.out.println("StringBuffer is faster.");
        }
        
    }
    public static void main(String[] args) {
        // Calling the compareStringBufferAndStringBuilder() function 
        compareStringBufferAndStringBuilder();
    }
}
