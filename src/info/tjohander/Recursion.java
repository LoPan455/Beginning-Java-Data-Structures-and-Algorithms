package info.tjohander;

/**
 * Recursion takes a problem and breaks it down in to smaller chunks that are structurally identical
 * to the larger problem Recursion functions have these common elements: 1. One or more stop
 * conditions. 2. One or more recursive calls. 3.
 */
public class Recursion {

  private static int factorial(int factorialNumber) {
    // break condition
    if (factorialNumber == 0) {
      return 1;
    }

    return factorialNumber * factorial(factorialNumber - 1);
  }

  public static void main(String[] args) {
    int factorialNumber = 5;
    System.out.println(factorial(factorialNumber));
  }

}
