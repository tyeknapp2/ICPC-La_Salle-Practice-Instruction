import java.util.Scanner;

/**
 * QuickEstimates
 * 
 * @author Tye Knappenberger
 */

public class QuickEstimates {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    scan.nextLine();
    while (scan.hasNext()) {
      System.out.println(scan.nextLine().length());
    }
    scan.close();
  }
}