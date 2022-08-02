package project.main.algos;

import org.junit.jupiter.api.Test;
import project.main.ArrayData;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private ArrayData testArray = new  ArrayData(250,1235, 1235);
    private BubbleSort bubbleSort = new BubbleSort(testArray);

    @Test
    void bubbleSort() {

        testArray.initShuffler();
        bubbleSort.bubbleSort();
        assertTrue(Worker.isSorted(testArray.getArr(),testArray.getSIZE()));

    }
}