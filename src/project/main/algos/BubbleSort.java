package project.main.algos;

import project.main.ArrayData;

import javax.swing.*;

public class BubbleSort {

    private ArrayData arrayData;
    private SwingWorker<Void,Void> bubbleSort;
    int currDex, travDex;


    public BubbleSort(ArrayData arrayData){

        this.arrayData = arrayData;


    }


    public void bubbleSort() {


            bubbleSort = new SwingWorker<>() {
                @Override
                public Void doInBackground() throws InterruptedException {
                    for (currDex = 1; currDex < arrayData.getSIZE(); currDex++) {
                        travDex = currDex;
                        while (travDex > 0 && arrayData.getIndexVal(travDex) < arrayData.getIndexVal(travDex - 1)) {

                            arrayData.swap(travDex, travDex - 1);
                            travDex--;
                            arrayData.setCurrDex(currDex);
                            arrayData.setTravDex(travDex);

                            Thread.sleep(1);
                            arrayData.repaint();
                        }
                    }
                    currDex = 0;
                    travDex = 0;
                    arrayData.setTravDex(currDex);
                    arrayData.setCurrDex(travDex);

                    return null;
                }

                @Override
                public void done() {
                    super.done();

                }
            };

            bubbleSort.execute();


    }



}
