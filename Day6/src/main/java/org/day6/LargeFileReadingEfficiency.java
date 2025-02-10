package org.day6;

import java.io.*;

public class LargeFileReadingEfficiency {
    public static void main(String[] args) {
        // Path to the large file
        String filePath = "S:\\Capgemini\\Week-3\\Day6\\src\\main\\java\\org\\day6\\largefile.txt";

        // FileReader Performance
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                // Reading byte-by-byte
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader time: " + (endTime - startTime) / 1000000 + " ms");

        // InputStreamReader Performance
        startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            int data;
            while ((data = inputStreamReader.read()) != -1) {
                // Reading byte-by-byte and converting to characters
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        System.out.println("InputStreamReader time: " + (endTime - startTime) / 1000000 + " ms");
    }
}
