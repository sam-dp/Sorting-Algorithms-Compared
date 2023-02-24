# Sorting Algorithms Compared
This java program uses implementations of four sorting algorithms (Bubble, Merge, Quick, and Selection) on an array of user-prompted size and compares their runtimes in the terminal.

## Preview

```
This program prompts for an array size, then shuffles
and sorts an array of this size. The compiled time of each sort is displayed.
(Type "quit" to exit program.)

Enter size of array: 200000

|================== Sort & Runtime ==================|
+-------------------------------------+--------------+
| Sort Name                           | Runtime (ms) |
+-------------------------------------+--------------+
| Bubble Sort                         | 3421         |
+-------------------------------------+--------------+
| Merge Sort                          | 24           |
+-------------------------------------+--------------+
| Quick Sort                          | 82           |
+-------------------------------------+--------------+
| Selection Sort                      | 2566         |
+-------------------------------------+--------------+

This program prompts for an array size, then shuffles 
and sorts an array of this size. The compiled time of each sort is displayed.
(Type "quit" to exit program.)

Enter size of array: quit
```

## Explanation
The programs dialogues the user for an array size, and then randomly populates an array of this size with random values. The same array is cloned and sorted by the four sorting algorithms, where the timing of the method is done through the [java.time](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html) package.

## Possible Improvements
- The current process initializes an array, sets its size (filling it with null values) then iteratively populates the array. There is likely room to improve the efficieny here

- There may be a more accurate method to timing sort runtimes

- Merge Sort may have a problem with its timing, despite two different implementations it persists in seemingly unrealistic runtimes

