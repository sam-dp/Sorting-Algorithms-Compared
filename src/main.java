
// Sam Park
// February 2023

// Imports
import java.util.*;
import java.time.Duration;
import java.time.Instant;


class Main {

    // Initial array
    private static int[] array;

    // Map stores sort name and runtime in millliseconds
    private static Map<String, Long> sortMap = new HashMap<>();

    // Continue program bool
    private static boolean doContinue = true;

    public static void main (String[] args) {

        // While user continues
        while(doContinue) {
            userDialogue();
            shuffle();
            callSorts();
            printMap();
        }

    }
    
    // Prints formatted table of sort results
    private static void printMap() {
        String leftAlignFormat = "| %-35s | %-12d |%n";

        System.out.print("\033[33m\n");
        System.out.format("|================== Sort & Runtime ==================|%n");
        System.out.print("\033[34m");
        System.out.format("+-------------------------------------+--------------+%n");
        System.out.format("| Sort Name                           | Runtime (ms) |%n");
        System.out.format("+-------------------------------------+--------------+%n");
        System.out.print("\033[0m");

        for(Map.Entry<String, Long> element : sortMap.entrySet()) {
            String key = element.getKey().trim();
            long value = element.getValue();

            System.out.printf(leftAlignFormat, key, value);
            System.out.format("+-------------------------------------+--------------+%n");

        }
        
    }

    // Calls all sort methods to populate map
    private static void callSorts() {
        mergeSort();
        bubbleSort();
        selectionSort();
        quickSort();
    }

    // Assigns array length
    private static void userDialogue() {

        // Scanner and temporary string for user input
        Scanner sc = new Scanner(System.in);
        String userInput = "";

        // If user input is an integer, start dialogue
        while (!isInteger(userInput)) {
            
            System.out.print("\nThis program prompts for an array size, then shuffles \nand sorts an array of this size. The compiled time of each sort is displayed.\n");
            System.out.print("\033[31m");
            System.out.print("(Type \"quit\" to exit program.)\n");
            System.out.print("\033[0m");
            System.out.print("\nEnter size of array: ");
            
            userInput = sc.next();
            
            // Quit, invalid, and valid input cases
            if(userInput.toUpperCase().equals("QUIT")) {
                doContinue = false;
                System.out.println();
                System.exit(0);
            }
            else if (isInteger(userInput) == false || Integer.parseInt(userInput) < 1) {
                System.out.println("Invalid Input!");
                userInput = "";
            } else {
                array = new int[Integer.parseInt(userInput)];
            }
        }
    
    }

    // Checks if a string represents an integer
    private static boolean isInteger(String string) {
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
    private static void shuffle() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1001) + 1;
        }

    }


    //////////////////
    // SORT METHODS //
    //////////////////

    // Bubble Sort
    private static void bubbleSort() {
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
    private static void mergeSort() {
        int[] cloneArr = array;
        int arrayLength = cloneArr.length;
        Instant start = java.time.Instant.now();

        mergeSorter(cloneArr, 0, arrayLength - 1);

        Instant end = java.time.Instant.now();
        Duration duration = java.time.Duration.between(start, end);
        sortMap.put("Merge Sort", duration.toMillis());
    }

    private static void merge(int arr[], int l, int m, int r) {
        // Sizes of subarrays
        int sub1 = m - l + 1;
        int sub2 = r - m;
  
        // Temporary arrays
        int L[] = new int[sub1];
        int R[] = new int[sub2];
  
        // Clone to temporary arrays
        for (int i = 0; i < sub1; ++i) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < sub2; ++j) {
            R[j] = arr[m + 1 + j];
        }
  
        // Initial indexes of subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < sub1 && j < sub2) {
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
  
        // Copy rest of L[]
        while (i < sub1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        // Copy rest of R[]
        while (j < sub2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Primary mergeSort helper
    private static void mergeSorter(int arr[], int l, int r) {
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
    private static void selectionSort() {
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
    private static void quickSort() {
        int[] cloneArr = array;
        int arrayLength = cloneArr.length;
        Instant start = java.time.Instant.now();

        quickSorter(cloneArr, 0, arrayLength-1);

        Instant end = java.time.Instant.now();
        Duration duration = java.time.Duration.between(start, end);
        sortMap.put("Quick Sort", duration.toMillis());
    }

    // Swap elements of array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // Pivot becomes last element, places pivot, and moves smaller elements to the left
    // and greater elements to the right
    private static int partition(int[] arr, int start, int end) {
 
        // Pivot
        int pivot = arr[end];
        int i = (start - 1);
 
        for (int j = start; j <= end - 1; j++) {
 
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
 
                // Increment index of the smaller element by 1
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return (i + 1);
    }
 
    // Primary quickSort helper
    private static void quickSorter(int[] arr, int start, int end) {
        if (start < end) {
            int pi = partition(arr, start, end);
            quickSorter(arr, start, pi - 1);
            quickSorter(arr, pi + 1, end);
        }
    }

}