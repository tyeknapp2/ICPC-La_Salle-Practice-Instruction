import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Parade
 */
public class Parade {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    scan.nextLine();
    while (scan.hasNext()) {
      int n = scan.nextInt();
      int k = scan.nextInt();
      ArrayList<BigInteger> heights = new ArrayList<BigInteger>();
      for (int i = 0; i < n; i++) {
        heights.add(scan.nextBigInteger());
      }
      System.out.print("");
    }
    scan.close();
  }
}