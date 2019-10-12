package info.tjohander;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Quick Sort is going to work on the notion of a 'pivot'.  Recursion is required. At a High-Level,
 * we are going to:
 *
 * 1. Select a pivot. 2. Partition the list so that the items on the left of the pivot are less than
 * the pivot and the values on the right are greater 3.  Repeat steps 1 and 2 on the left and right
 * parts separately.
 *
 *
 * In more depth, we will:
 *
 * 1. Pick the right-most index in the array as the pivot: int pivot = array[array.length -1];
 *
 * 2. Start from the left and find the next element that is larger than the pivot
 *
 * 3. Swap the element with the next which smaller than the pivot element
 *
 * 4. Repeat Steps 2 and 3 (Recursio) until no more swapping is possible.
 *
 * 5. Swap the first item which is larger then the pivot's value with the pivot itself
 */
public class QuickSort {

  // Attempt to try these steps in actual code here:
  public static void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  private static void quickSort(int[] array, int start, int end) {
    // this is a stop condition because eventually we are going to partition so many times
    // that all we'll be left with is 1 length arrays.  At that point, the recursion will stop
    if (start < end) {
      // first we partition the array into two halves at the pivot point.  Each half will contain unsorted values from {0 - pivot value} and {pivot value - max}
      int p = partition(array, start, end);
      // Recursively sort lower half.  The recursion will keep happening because start will always be less than the end until the array has been partitioned into the smallest possible unit
      quickSort(array, start, p - 1);
      // Recursively sort the upper half
      quickSort(array, p + 1, end);
    }
  }

  private static int partition(int[] array, int start, int end) {
    // find the pivot
    int pivot = array[end];
    // determine the 'trailing pointer' that will be used as the BOUNDARY of the partition
    int x = start - 1;
    // Iterate over each member of the array
    for (int i = start; i < end; i++) {
      // If we find that a member of the array is less than the pivot, we want to move our
      // boundary to the right by swapping the values located at the these positions
      if (array[i] < pivot) {
        x++;
        swap(array, x, i);
      }
    }
    swap(array, x + 1, end);
    return x + 1;
  }

  // Here is our swap function
  private static void swap(int[] array, int j, int k) {
    int temp = array[j];
    array[j] = array[k];
    array[k] = temp;
  }

  public static void main(String[] args) {
    int[] array = Util.generateArrayOfSizeAndMax(10000, 100);
    System.out.println(Arrays.toString(array));
    Instant start = Instant.now();
    quickSort(array);
    Instant end = Instant.now();
    System.out.println(Arrays.toString(array));
    System.out.println("Time to complete: " + Duration.between(start, end).toMillis() + "ms");
  }
}
