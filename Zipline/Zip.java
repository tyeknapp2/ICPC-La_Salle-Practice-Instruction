import java.util.Scanner;

import sun.print.resources.serviceui;

/**
 * Zip
 * 
 * @author Tye Knappenberger
 */
public class Zip {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int m = scan.nextInt();
    for (int i = 0; i < m; i++) {
      int w = scan.nextInt();
      int g = scan.nextInt();
      int h = scan.nextInt();
      int r = scan.nextInt();
      System.out.print(minDist(w, g, h) + " " + maxDist(w, g, h, r));
      System.out.println();
    }
    scan.close();
  }

  public static double minDist(int w, int g, int h) {
    int diff = Math.abs(h - g);
    return (diff == 0) ? w : Math.sqrt((double) ((diff * diff) + (w * w)));
  }

  public static double maxDist(int w, int g, int h, int r) {
    double l1 = 0;
    return l1;
  }
}