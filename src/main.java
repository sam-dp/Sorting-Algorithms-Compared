import java.util.*;
import javax.swing.*;
import java.awt.*;

class main {

    public static int[] array;

    public static void main (String[] args) {
        shuffle();
        userDialogue();
        


    }

    // Assigns array length
    public static void userDialogue() {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        while(!isInteger(userInput)) {
            System.out.print("Enter size of array: ");
            userInput = sc.next();
            if(isInteger(userInput) == false) {
                System.out.println("Invalid Input!\n");
                userInput = "";
            } else {
                array = new int[Integer.parseInt(userInput)];
            }
        }
        
    }

    // Checks if a string  represents an integer
    public static boolean isInteger(String string) {
        if (string == null) {
            return false;
        }
        int stringLength = string.length();
        if (stringLength == 0) {
            return false;
        }
        int i = 0;
        if (string.charAt(0) == '-') {
            if (stringLength == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < stringLength; i++) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    // Fills array with random values
    public static void shuffle()  {
        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1001) + 1;
        }
        
    }


    //////////////////
    // SORT METHODS //
    //////////////////


    // Binary Sort
    public int[] binarySort(int[] array)  {
        
        return array;
        
    }

    // Bubble Sort
    public static int[] bubbleSort(int[] array)  {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    // Merge Sort
    public int[] mergeSort(int[] array)  {
        return array;
        
    }

    // Quick Sort
    public int[] quickSort(int[] array)  {
        return array;
        
    }

    // Selection Sort
    public int[] selectionSort(int[] array)  {
        return array;
        
    }

    // Sequential Sort
    public int[] sequentialSort(int[] array)  {
        return array;
        
    }


    

    
}