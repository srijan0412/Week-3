package com.day6;

import org.day6.SearchTargetInLargeDataset;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTargetInLargeDatasetTest {
    @Test
    void testLinearSearch() {
//        Defining datasets
        int dataset[] = {2, 4, 5, 7, 9, 11, 13};
        int target1 = 7;
        int target2 = 8;

//        Calculaiting result 1
        int result1 = SearchTargetInLargeDataset.linearSearch(dataset, target1);
        int expected1 = 3;

//        Calculaiting result 2
        int result2 = SearchTargetInLargeDataset.linearSearch(dataset, target2);
        int expected2 = -1;

//        Testing validity
        Assertions.assertEquals(expected1, result1);
        Assertions.assertEquals(expected2, result2);
    }

    @Test
    void testBinarySearch() {
//        Defining datasets
        int dataset[] = {2, 4, 5, 7, 9, 11, 13};
        int target1 = 7;
        int target2 = 8;

//        Calculaiting result 1
        int result1 = SearchTargetInLargeDataset.binarySearch(dataset, target1);
        int expected1 = 3;

//        Calculaiting result 2
        int result2 = SearchTargetInLargeDataset.binarySearch(dataset, target2);
        int expected2 = -1;

//        Testing validity
        Assertions.assertEquals(expected1, result1);
        Assertions.assertEquals(expected2, result2);
    }



}
