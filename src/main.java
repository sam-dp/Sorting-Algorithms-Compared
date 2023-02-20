import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;

class main {

    public static int[] array;
    public static Map<String, Long> sortMap = new HashMap<>();
    public static boolean cont = true;

    public static void main (String[] args) {
        while(cont) {
            userDialogue();
            shuffle();
            callSorts();
            printMap();

        }
        

        
    }
    

    public static void printMap() {
        for(Map.Entry<String, Long> element : sortMap.entrySet()) {
            String key = element.getKey();
            long value = element.getValue();
            System.out.printf("%s %d ms", key, value);
            System.out.println();
        }
        
    }

    // Calls all sort methods to populate map
    public static void callSorts() {
        mergeSort();
        bubbleSort();
        selectionSort();
        quickSort();
    }

    // Assigns array length
    public static void userDialogue() {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        while (!isInteger(userInput)) {
            System.out.print("\nType quite exit program.\nEnter size of array: ");
            userInput = sc.next();
            if(userInput.toUpperCase().equals("QUIT")) {
                cont = false;
                System.exit(0);
            }
            else if (isInteger(userInput) == false) {
                System.out.println("Invalid Input!\n");
                userInput = "";
            } else {
                array = new int[Integer.parseInt(userInput)];
            }
        }

    }

    // Checks if a string represents an integer
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
    public static void shuffle() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1001) + 1;
        }

    }



    //////////////////
    // SORT METHODS //
    //////////////////


    // Bubble Sort
    public static void bubbleSort() {
        int[] cloneArr = array;
        int arrayLength = cloneArr.length;

        Instant start = java.time.Instant.now();

        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (cloneArr[j] > cloneArr[j + 1]) {
                    int temp = cloneArr[j];
                    cloneArr[j] = cloneArr[j + 1];
                    cloneArr[j + 1] = temp;
                }
            }
        }

        Instant end = java.time.Instant.now();
        Duration duration = java.time.Duration.between(start, end);
        sortMap.put("Bubble Sort", duration.toMillis());
    }



    // Merge Sort
    public static void mergeSort() {
        int[] cloneArr = array;
        int arrayLength = cloneArr.length;
        Instant start = java.time.Instant.now();

        mergeSorter(cloneArr, 0, arrayLength - 1);

        Instant end = java.time.Instant.now();
        Duration duration = java.time.Duration.between(start, end);
        sortMap.put("Merge Sort", duration.toMillis());
    }

    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    public static void mergeSorter(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
  
            // Sort first and second halves
            mergeSorter(arr, l, m);
            mergeSorter(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }



    // Selection Sort
    public static void selectionSort() {
        int[] cloneArr = array;
        int arrayLength = cloneArr.length;
        Instant start = java.time.Instant.now();
  
        for (int i = 0; i < arrayLength-1; i++) {
            int min_idx = i;

            for (int j = i+1; j < arrayLength; j++) {
                if (cloneArr[j] < cloneArr[min_idx]) {
                    min_idx = j;
                }
            }
                
            int temp = cloneArr[min_idx];
            cloneArr[min_idx] = cloneArr[i];
            cloneArr[i] = temp;
        }

        Instant end = java.time.Instant.now();
        Duration duration = java.time.Duration.between(start, end);
        sortMap.put("Selection Sort", duration.toMillis());
    }



    // Quick Sort
    public static void quickSort() {
        int[] cloneArr = array;
        int arrayLength = cloneArr.length;
        Instant start = java.time.Instant.now();

        quickSorter(cloneArr, 0, arrayLength-1);

        Instant end = java.time.Instant.now();
        Duration duration = java.time.Duration.between(start, end);
        sortMap.put("Quick Sort", duration.toMillis());
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {
 
        // pivot
        int pivot = arr[high];
 
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
 
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
 
    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSorter(int[] arr, int low, int high)
    {
        if (low < high) {
 
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
 
            // Separately sort elements before
            // partition and after partition
            quickSorter(arr, low, pi - 1);
            quickSorter(arr, pi + 1, high);
        }
    }

}