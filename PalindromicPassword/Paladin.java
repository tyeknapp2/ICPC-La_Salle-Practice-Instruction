import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

/**
 * Paladin
 * 
 * @author Tye Knappenberger
 */
public class Paladin {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    scan.nextLine();
    while (scan.hasNext()) {
      String s = scan.nextLine();
      int x = Integer.parseInt(s);
      if (!isPalindrome(x)) {
        int xUp = x + 1;
        int xDown = x - 1;
        while (true) {
          if (isPalindrome(xDown)) {
            String z = "" + xDown;
            while (z.length() < 6) {
              z = "0" + z;
            }
            System.out.println(z);
            break;
          } else if (isPalindrome(xUp)) {
            String z = "" + xUp;
            while (z.length() < 6) {
              z = "0" + z;
            }
            System.out.println(z);
            break;
          } else {
            xUp++;
            xDown--;
          }
        }
      } else {
        String z = "" + x;
        while (z.length() < 6) {
          z = "0" + z;
        }
        System.out.println(z);
      }
    }

    scan.close();
  }

  private static boolean isPalindrome(int x) {

    String s = "" + x;
    while (s.length() < 6) {
      s = "0" + s;
    }
    return s.substring(0, 3).equals("" + s.charAt(5) + s.charAt(4) + s.charAt(3));

  }
}