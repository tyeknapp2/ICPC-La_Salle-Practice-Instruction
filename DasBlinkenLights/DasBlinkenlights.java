import java.util.Scanner;

public class DasBlinkenlights {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println(blink(scan.nextInt(), scan.nextInt(), scan.nextInt()));
    scan.close();
  }

  private static String blink(int one, int two, int time) {
    for (int i = 1; i <= time; i++)
      if (i % one == 0 && i % two == 0)
        return "yes";
    return "no";
  }
}