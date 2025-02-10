package com.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecursiveVsIterativeFibonacciSequenceTest {
    // Test for Recursive Fibonacci
    @Test
    public void testFibonacciRecursive() {
        int n = 10; // Change as needed for the test
        int expected = 55; // Fibonacci of 10 is 55
        int actual = RecursiveVsIterativeFibonacciSequence.fibonacciRecursive(n);
        Assertions.assertEquals(expected, actual, "Recursive Fibonacci failed!");
    }

    // Test for Iterative Fibonacci
    @Test
    public void testFibonacciIterative() {
        int n = 10; // Change as needed for the test
        int expected = 55; // Fibonacci of 10 is 55
        int actual = RecursiveVsIterativeFibonacciSequence.fibonacciIterative(n);
        Assertions.assertEquals(expected, actual, "Iterative Fibonacci failed!");
    }

    // Performance Test for Recursive Fibonacci (for larger input)
    @Test
    public void testFibonacciRecursivePerformance() {
        int n = 30; // Test for a larger value
        long startTime = System.nanoTime();
        RecursiveVsIterativeFibonacciSequence.fibonacciRecursive(n);
        long endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci time for n=" + n + ": " + (endTime - startTime) / 1000000 + " ms");
    }

    // Performance Test for Iterative Fibonacci (for larger input)
    @Test
    public void testFibonacciIterativePerformance() {
        int n = 30; // Test for a larger value
        long startTime = System.nanoTime();
        RecursiveVsIterativeFibonacciSequence.fibonacciIterative(n);
        long endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci time for n=" + n + ": " + (endTime - startTime) / 1000000 + " ms");
    }

    // Test for correctness with larger Fibonacci numbers
    @Test
    public void testFibonacciLargeInput() {
        int n = 10; // Larger input for Fibonacci number
        int expectedRecursive = 55; // Fibonacci of 50
        int expectedIterative = 55; // Fibonacci of 50 (same result)

        int recursiveResult = RecursiveVsIterativeFibonacciSequence.fibonacciRecursive(n);
        int iterativeResult = RecursiveVsIterativeFibonacciSequence.fibonacciIterative(n);

        Assertions.assertEquals(expectedRecursive, recursiveResult, "Recursive Fibonacci failed for large input!");
        Assertions.assertEquals(expectedIterative, iterativeResult, "Iterative Fibonacci failed for large input!");
    }
}
