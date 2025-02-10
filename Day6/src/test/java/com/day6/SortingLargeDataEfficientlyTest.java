package com.day6;

import org.day6.SortingLargeDataEfficiently;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SortingLargeDataEfficientlyTest {
    @Test
    void testBubbleSort() {
        // Test case 1: Normal case
        int[] input1 = {64, 34, 25, 12, 22, 11, 90};
        int[] expected1 = {11, 12, 22, 25, 34, 64, 90};
        SortingLargeDataEfficiently.bubbleSort(input1);
        assertArrayEquals(expected1, input1);

        // Test case 2: Already sorted
        int[] input2 = {1, 2, 3, 4, 5};
        int[] expected2 = {1, 2, 3, 4, 5};
        SortingLargeDataEfficiently.bubbleSort(input2);
        assertArrayEquals(expected2, input2);

        // Test case 3: Reverse sorted
        int[] input3 = {5, 4, 3, 2, 1};
        int[] expected3 = {1, 2, 3, 4, 5};
        SortingLargeDataEfficiently.bubbleSort(input3);
        assertArrayEquals(expected3, input3);
    }

    @Test
    void testMergeSort() {
        // Test case 1: Normal case
        int[] input1 = {64, 34, 25, 12, 22, 11, 90};
        int[] expected1 = {11, 12, 22, 25, 34, 64, 90};
        SortingLargeDataEfficiently.mergeSort(input1, 0, input1.length-1);
        assertArrayEquals(expected1, input1);

        // Test case 2: Already sorted
        int[] input2 = {1, 2, 3, 4, 5};
        int[] expected2 = {1, 2, 3, 4, 5};
        SortingLargeDataEfficiently.mergeSort(input2, 0, input2.length-1);
        assertArrayEquals(expected2, input2);

        // Test case 3: Reverse sorted
        int[] input3 = {5, 4, 3, 2, 1};
        int[] expected3 = {1, 2, 3, 4, 5};
        SortingLargeDataEfficiently.mergeSort(input3, 0, input3.length-1);
        assertArrayEquals(expected3, input3);
    }

    @Test
    void testQuickSort() {
        // Test case 1: Normal case
        int[] input1 = {64, 34, 25, 12, 22, 11, 90};
        int[] expected1 = {11, 12, 22, 25, 34, 64, 90};
        SortingLargeDataEfficiently.quickSort(input1, 0, input1.length-1);
        assertArrayEquals(expected1, input1);

        // Test case 2: Already sorted
        int[] input2 = {1, 2, 3, 4, 5};
        int[] expected2 = {1, 2, 3, 4, 5};
        SortingLargeDataEfficiently.quickSort(input2, 0, input2.length-1);
        assertArrayEquals(expected2, input2);

        // Test case 3: Reverse sorted
        int[] input3 = {5, 4, 3, 2, 1};
        int[] expected3 = {1, 2, 3, 4, 5};
        SortingLargeDataEfficiently.quickSort(input3, 0, input3.length-1);
        assertArrayEquals(expected3, input3);
    }
}
