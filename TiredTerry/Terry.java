import java.util.Scanner;

/**
 * This one timeouts
 * 
 * Terry
 * 
 * @author Tye Knappenberger
 */
public class Terry {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int p = scan.nextInt();
    int d = scan.nextInt();
    scan.nextLine();
    String s = scan.nextLine();
    scan.close();
    int tiredness = 0;
    for (int i = 0; i < n; i++) {
      tiredness += numSecondsOfSleep(
          (i - p + 1 > 0 ? s.substring(i - p + 1, i + 1) : s.substring(n + (i - p + 1)) + s.substring(0, i + 1))) < d
              ? 1
              : 0;
    }
    System.out.println(tiredness);
  }

  public static int numSecondsOfSleep(String subString) {
    int index = subString.indexOf("Z");
    if (index == -1)
      return 0;
    else
      return numSecondsOfSleep(subString.substring(index + 1), 1);
  }

  public static int numSecondsOfSleep(String subString, int num) {
    int index = subString.indexOf("Z");
    if (index == -1)
      return num;
    else
      return numSecondsOfSleep(subString.substring(index + 1), num + 1);
  }
}