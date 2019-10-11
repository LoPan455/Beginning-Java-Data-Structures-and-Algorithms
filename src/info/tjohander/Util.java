package info.tjohander;

import static java.util.Random.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Util {

  /**
   * Generate an array of ints of a given size with ints ranging from 0 to <max>
   */
  public static int[] generateArrayOfSizeAndMax(int size, int max) {
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = ThreadLocalRandom.current().nextInt(max);
    }
    return result;
  }
}
