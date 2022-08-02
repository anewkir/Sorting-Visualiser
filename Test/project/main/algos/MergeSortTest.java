package project.main.algos;

import project.main.ArrayData;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    private ArrayData testArray = new  ArrayData(250,1235, 1235);
    private MergeSort mergeSort = new MergeSort(testArray);

    // test to see if the merge sort method actually sorts the array
    @org.junit.jupiter.api.Test
    void mergeSortTest() {


        testArray.initShuffler();
        mergeSort.mergeSort();
        assertTrue(Worker.isSorted(testArray.getArr(), testArray.getSIZE()));

    }




}