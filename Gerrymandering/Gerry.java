import java.util.Scanner;
import java.text.DecimalFormat;

public class Gerry {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int inputs = scan.nextInt();
    int districts = scan.nextInt();
    int[][] votes = new int[districts][2];
    for (int i = 0; i < districts; i++) {
      votes[i][0] = 0;
      votes[i][1] = 0;
    }
    int totalVs = 0;
    for (int i = 0; i < inputs; i++) {
      int x = scan.nextInt();
      votes[x - 1][0] += scan.nextInt();
      votes[x - 1][1] += scan.nextInt();
    }
    scan.close();
    for (int i = 0; i < districts; i++) {
      totalVs += votes[i][0] + votes[i][1];
    }
    int wa = 0;
    int wb = 0;
    for (int i = 0; i < districts; i++) {
      if (votes[i][0] > votes[i][1]) {
        System.out.print("A ");
        int y = votes[i][0] - ((votes[i][0] + votes[i][1]) / 2 + 1);
        wa += y;
        System.out.print(y + " ");
        System.out.println(votes[i][1]);
        wb += votes[i][1];
      } else {
        System.out.print("B ");
        System.out.print(votes[i][0] + " ");
        wa += votes[i][0];
        int y = votes[i][1] - ((votes[i][0] + votes[i][1]) / 2 + 1);
        wb += y;
        System.out.println(y);
      }
    }
    double d = Math.abs(wa - wb) / (double) totalVs;
    System.out.println(d);
  }
}