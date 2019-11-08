import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;;

/**
 * TiredTerryV3
 * 
 * @author Tye Knappenberger
 */
public class TiredTerryV3 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    scan.nextInt();
    int p = scan.nextInt();
    int d = scan.nextInt();
    scan.nextLine();
    String s = scan.nextLine();
    scan.close();
    LinkedList<Character> timer = new LinkedList<Character>();
    int sleep = 0;
    for (int i = s.length() - p; i < s.length(); i++) {
      sleep += (s.charAt(i) == 'Z' ? 1 : 0);
      timer.add(s.charAt(i));
    }
    int tiredness = 0;
    for (int i = 0; i < s.length(); i++) {

      char c = timer.remove();
      sleep -= (c == 'Z' ? 1 : 0);
      sleep += (s.charAt(i) == 'Z' ? 1 : 0);
      timer.add(s.charAt(i));
      if (sleep < d) {
        tiredness++;
      }
    }
    System.out.println(tiredness);
  }
}
