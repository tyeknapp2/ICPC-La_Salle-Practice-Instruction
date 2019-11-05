import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Parade
 * 
 * @author Tye Knappenberger
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

      BigInteger maxSoldiers = new BigInteger("0");
      if (k == 1) {
        for (int i = 0; i < heights.size() - 1; i++) {
          heights.set(i, heights.get(i).add(heights.get(i + 1)));
          if (heights.get(i).andNot(maxSoldiers).equals(BigInteger.ZERO)) {
            maxSoldiers = heights.get(i);
          }
        }
      }

      System.out.println(maxSoldiers);
    }
    scan.close();
  }
}