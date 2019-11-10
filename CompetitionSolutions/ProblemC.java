import java.util.Scanner;

/**
 * ProblemC
 */
public class ProblemC {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      String s = scan.nextLine();
      if (s.contains("WWW") || s.contains("BBB") || numW(s) != n / 2) {
        scan.close();
        System.out.println(0);
        return;
      }
      for (int j = 0; j < n; j++) {
        board[i][j] = s.charAt(j);
      }
    }
    scan.close();
    for (int j = 0; j < n; j++) {
      String s = "";
      for (int i = 0; i < n; i++) {
        s += board[i][j] + "";
      }
      if (s.contains("WWW") || s.contains("BBB") || numW(s) != n / 2) {
        System.out.println(0);
        return;
      }
    }
    System.out.println(1);
  }

  public static int numW(String s) {
    return numW(s, 0);
  }

  public static int numW(String s, int count) {
    int index = s.indexOf("W");
    if (index == -1)
      return count;
    else
      return numW(s.substring(index + 1), count + 1);
  }
}