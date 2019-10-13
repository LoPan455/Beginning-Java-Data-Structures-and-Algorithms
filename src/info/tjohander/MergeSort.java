package info.tjohander;

import static info.tjohander.Util.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class MergeSort {

  public static void mergeSort(int[] array) {
    int[] tempArray = new int[array.length];
    mergeSort(array, tempArray, 0, array.length - 1);
  }


  private static void mergeSort(int[] array, int[] tempArray, int leftStart, int rightEnd) {
    if (leftStart >= rightEnd) {
      return;
    }
    int middle = (leftStart + rightEnd) / 2;
    mergeSort(array, tempArray, leftStart, middle);
    mergeSort(array, tempArray, middle + 1, rightEnd);
    mergeHalves(array, tempArray, leftStart, rightEnd);
  }

  private static void mergeHalves(int[] array, int[] tempArray, int leftStart, int rightEnd) {
    int leftEnd = (rightEnd + leftStart) / 2;
    int rightStart = leftEnd + 1;
    int size = rightEnd - leftStart + 1;

    int left = leftStart;
    int right = rightStart;
    int index = leftStart;

    while (left <= leftEnd && right <= rightEnd) {
      if (array[left] <= array[right]) {
        tempArray[index] = array[left];
        left++;
      } else {
        tempArray[index] = array[right];
        right++;
      }
      index++;
    }

    // Only one or the other will have an effect.  One will be shorter, one will be longer
    System.arraycopy(array, left, tempArray, index, leftEnd - left + 1);
    System.arraycopy(array, right, tempArray, index, rightEnd - right + 1);

    // Copies everything back.
    System.arraycopy(tempArray, leftStart, array, leftStart, size);
  }

  public static void main(String[] args) {
    int[] array = Util.generateArrayOfSizeAndMax(10, 100);
    System.out.println(Arrays.toString(array));
    Instant start = Instant.now();
    mergeSort(array);
    Instant end = Instant.now();
    System.out.println(Arrays.toString(array));
    System.out.println("During of operation: " + Duration.between(start, end).toMillis() + "ms");
  }

}
