package info.tjohander;

/**
 * Recursion takes a problem and breaks it down in to smaller chunks that are structurally identical
 * to the larger problem Recursion functions have these common elements:
 *   1. One or more stop conditions.
 *   2. One or more recursive calls.
 */
public class Recursion {

  private static int factorial(int value) {
    // break condition
    if (value == 0) {
      // This will not call the function again.  It's the "back-wall"
      return 1;
    }

    // The function will call itself repeatedly until the number that's passed in is 0
    // then we start returning the values of the previous calls.
    return value * factorial(value - 1);
  }

  public static void main(String[] args) {
    int factorialNumber = 5;
    System.out.println(factorial(factorialNumber));
  }

}
