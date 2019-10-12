package info.tjohander;

import static info.tjohander.Util.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {

    int[] array = Util.generateArrayOfSizeAndMax(5000, 100);
    System.out.println(Arrays.toString(array));
    Instant start = Instant.now();

    // we have to do the following operation as many times as there are members of the array
    // That's why we have to start with 1 instead of 0
    for (int i = 1; i < array.length; i++) {
      // now we have to do the following process on each of member so we need another loop
      for (int j = 0; j < array.length - 1; j++) {
        // if the current position is greater than the next position, swap them
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    Instant end = Instant.now();
    System.out.println(Arrays.toString(array));
    for (int i = 0; i < array.length - 1; i++) {
      assert array[i] <= array[i + 1];
    }
    System.out.println("Time to complete: " + Duration.between(start, end).toMillis() + "ms");
  }
}
