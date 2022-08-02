package project.main.algos;

import project.main.ArrayData;

import javax.swing.*;


/*
This is the merge sort algorithm

This is an in place merge sort as creating a ton of different ArrayData classes.

 */
public class MergeSort {

    ArrayData arrayData;
    SwingWorker<Void, Void> mergeSort;

    public MergeSort(ArrayData arrayData){

        this.arrayData = arrayData;

    }



    public void mergeSort(){
        mergeSort = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                mergeSort(arrayData, 0, arrayData.getSIZE() - 1);
                arrayData.setTravDex(0);
                arrayData.setCurrDex(0);
                arrayData.repaint();
                return null;
            }

            @Override
            protected void done() {
                super.done();
            }
        };

        mergeSort.execute();
    }





    private void merge(ArrayData arg, int start , int middle, int end) throws InterruptedException {

        int start2 = middle + 1;

        //if the direct merge is already sorted return
        if(arg.getIndexVal(middle) <= arg.getIndexVal(start2)){
            return;
        }

        // two pointers to maintain the start
        //set both arrays to merge
        while(start <= middle && start2 <= end){

            //if element 1 is in the right place increment start index
            if(arg.getIndexVal(start) <= arg.getIndexVal(start2)) {
                start++;
            }else{
                float value = arg.getIndexVal(start2);
                int index = start2;

                //shift all the elements between element oen
                //element 2, right by one
                while(index != start){
                    arg.setIndexVal(index, arg.getIndexVal(index - 1));
                    index--;
                }

                Thread.sleep(50);
                arrayData.setTravDex(start);
                arrayData.getArr();
                //arrayData.setMoveDex(middle);
                arrayData.setCurrDex(end);
                arrayData.repaint();
                arg.setIndexVal(start, value);

                //update pointers
                start++;
                middle++;
                start2++;



            }

        }

    }


    public void mergeSort(ArrayData arr, int left, int right) throws InterruptedException {

        if(left< right){


            //find middle of index reliably
            int middle = left + (right - left) / 2;


            Thread.sleep(50);
            arrayData.setTravDex(right);
            arrayData.setCurrDex(left);
            arrayData.repaint();

            //sort first and second half
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }

    }



}