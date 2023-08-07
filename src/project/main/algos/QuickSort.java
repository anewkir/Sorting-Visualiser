package project.main.algos;

import project.main.ArrayData;

import javax.swing.*;

/*
THis class is the quicksort algorithm
it sorts really fast lol
 */
public class QuickSort {

    private SwingWorker<Void,Void> quickSort;
    private ArrayData arrayData;

    //constructor
    public QuickSort(ArrayData arrayData){
        this.arrayData = arrayData;

    }

    /*
    quicksort method
    @Param none
    @Return none
     */
    public void quickSort() {


        quickSort = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                //overloaded recursive quicksort method
                quickSort(arrayData,0,arrayData.getSIZE() -1);
                arrayData.setTravDex(0);
                arrayData.setCurrDex(0);


                return null;
            }
            @Override
            public void done() {
                super.done();
        }


    };
        quickSort.execute();

    }

/*
@Param arrayData object, low index, high index
@Return none
 */
    private void quickSort(ArrayData arrayData, int low, int high) throws InterruptedException {

        if(low < high){

            int partition = partition(arrayData,low,high);


            arrayData.setTravDex(low);
            arrayData.setCurrDex(high);
            arrayData.repaint();

            Thread.sleep(20);
            arrayData.repaint();
            quickSort(arrayData, low, partition -1);
            Thread.sleep(20);
            arrayData.repaint();
            quickSort(arrayData, partition + 1, high);
        }

    }


    /*
    @Param arraydata , low index, high index
    @Return ith index +1
     */
    private int partition(ArrayData arrayData, int low, int high) throws InterruptedException {

        //pivot value
        float pivot = arrayData.getIndexVal(high);


        /*Index of smaller element and
         indicates the right position
         pivot found so far
          */
        int i = (low -1);

        for(int j = low; j <= high - 1; j++){

            if(arrayData.getIndexVal(j) < pivot){
                /*
                 Increment index of
                 smaller element
                 */
                i++;
                arrayData.swap(i,j);


            }
        }
        arrayData.swap(i + 1, high);

        // setting traversal index and current index to allow algorithm to repaint the jpannel
        arrayData.setTravDex(i);
        arrayData.setCurrDex(high);
        Thread.sleep(100);
        arrayData.repaint();
        return (i+1);
    }




}
