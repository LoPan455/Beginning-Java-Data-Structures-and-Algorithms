package info.tjohander;

import static info.tjohander.Util.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class BubbleSort {

  // swap elements array[j] and array[k]
  private static void swap(int[] array, int j, int k) {
    int temp = array[j];
    array[j] = array[k];
    array[k] = temp;
  }

  private static void bubbleSort(int[] array) {

    // we have to do the following operation as many times as there are members of the array
    // That's why we have to start with 1 instead of 0
    for (int i = 1; i < array.length; i++) {

      // Now do the actual operation
      for (int j = 0; j < array.length - 1; j++) {

        // if the current position is greater than the next position, swap them
        if (array[j] > array[j + 1]) {
          swap(array, j, j + 1);
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] array = Util.generateArrayOfSizeAndMax(10000, 100);
    // Let's see what we're working with
    System.out.println(Arrays.toString(array));

    // Start timer
    Instant start = Instant.now();

    // our method
    bubbleSort(array);

    // Stop timer
    Instant end = Instant.now();

    // Let's look at the array now
    System.out.println(Arrays.toString(array));

    // Let's make a quick assertion to ensure each int is sorted properly.
    for (int i = 0; i < array.length - 1; i++) {
      // There will be duplicates here, so we need <= as the comparison operator
      assert array[i] <= array[i + 1];
    }
    System.out.println("Time to complete: " + Duration.between(start, end).toMillis() + "ms");
  }
}
