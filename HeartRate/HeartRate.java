import java.util.Scanner;

/**
 * HeartRate
 */
public class HeartRate {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    scan.nextLine();
    while (scan.hasNext()) {
      double b = scan.nextDouble();
      double p = scan.nextDouble();
      double bpm = 60 * b / p;
      System.out.println((bpm - bpm / b) + " " + bpm + " " + (bpm + bpm / b));
    }
    scan.close();
  }
}