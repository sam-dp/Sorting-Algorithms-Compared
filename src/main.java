import java.util.*;
import javax.swing.*;
import java.awt.*;

class main {

    public int arraySize;
    public float[] array = new float[arraySize];

    public static void main (String[] args) {
        
    }

    public float[] shuffle(float[] array)  {
        return array;
        
    }

    public void drawArray(float[] array) {

    }


    //////////////////
    // SORT METHODS //
    //////////////////

    public float[] binarySort(float[] array)  {
        
        return array;
        
    }

    public float[] bubbleSort(float[] array)  {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    float temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
        
    }

    public float[] mergeSort(float[] array)  {
        return array;
        
    }

    public float[] quickSort(float[] array)  {
        return array;
        
    }

    public float[] selectionSort(float[] array)  {
        return array;
        
    }

    public float[] sequentialSort(float[] array)  {
        return array;
        
    }


    

    
}