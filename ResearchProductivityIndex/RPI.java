import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RPI {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numInput = scan.nextInt();
    ArrayList<Integer> rates = new ArrayList<Integer>();
    for (int i = 0; i < numInput; i++) {
      rates.add(scan.nextInt());
    }
    scan.close();
    Collections.sort(rates);
    double d = 0;
    for (int i = 1; i <= numInput; i++) {
      ArrayList<Integer> sub = new ArrayList<Integer>();
      for (int j = 1; j <= i; j++)
        sub.add(rates.get(rates.size() - j));
      d = maxExpectedValue(sub, d);
    }
    System.out.println(d);
  }

  public static double maxExpectedValue(ArrayList<Integer> sub, double d) {
    double xp = 0;
    for (int i = 0; i < sub.size(); i++) {
      xp += calcX(i, sub.size());
    }
    return (d < xp ? xp : d);
  }

  public static double calcX(int a, int s) {
    return Math.pow((double) a, (double) a / (double) s);
  }

  // STUMPED HERE
  public static double calcP(ArrayList<Integer> sub, int i) {
    double prob = 0;

    return prob;
  }

}