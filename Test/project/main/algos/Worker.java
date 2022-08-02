package project.main.algos;

import project.main.ArrayData;

public class Worker {



    public static boolean isSorted(float[] arr, int length){
        // check if the array is in fact sorted
        if(arr == null || length < 2)
            return true;
        if(arr[length - 2] > arr[length -1])
            return false;
        return isSorted(arr, length -1);

    }
}
