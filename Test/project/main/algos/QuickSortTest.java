package project.main.algos;

import org.junit.jupiter.api.Test;
import project.main.ArrayData;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private ArrayData testArray = new  ArrayData(250,1235, 1235);
    private QuickSort quickSort = new QuickSort(testArray);

    @Test
    void quickSort() {

        testArray.initShuffler();
        quickSort.quickSort();

        assertTrue(Worker.isSorted(testArray.getArr(),testArray.getSIZE()));
        

    }
}