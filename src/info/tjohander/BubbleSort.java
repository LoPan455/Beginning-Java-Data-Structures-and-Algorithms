package info.tjohander;

import static info.tjohander.Util.*;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {

    int[] array = Util.generateArrayOfSizeAndMax(10, 100);
    System.out.println(Arrays.toString(array));

  }

}
