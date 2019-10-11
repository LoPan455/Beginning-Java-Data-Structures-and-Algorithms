package info.tjohander;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {

    // Algorithm to compare binary numbers to decimal
    // Accepts a string of 1's and 0's and convers to decimal

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a string");
    String string = scanner.nextLine();
    System.out.println("You entered \"" + string + "\"");
    char[] charArray = string.toCharArray();
    System.out.println(Arrays.toString(charArray));

    // we need an variable to store the total
    int result = 0;

    for (int i = 1; i <= charArray.length; i++) {
        // we need to figure out the value of this bit if it's on.
      if (charArray[i - 1] == '1') {
          // What's the value of this bit.
          // it's going to be the last
          // if there are 5 bits in the String, the first position would represent 2^5
        result += Math.pow(2, charArray.length - i);
      }
    }
      assert result == 180;
  }
}
