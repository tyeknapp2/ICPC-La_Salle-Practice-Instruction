import java.util.Scanner;
import java.util.ArrayList;

/**
 * Still Timesout but gets another test case
 * 
 * TiredTerryTwo
 * 
 *
 */
public class TiredTerryTwo {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    scan.nextInt();
    int p = scan.nextInt();
    int d = scan.nextInt();
    scan.nextLine();
    String s = scan.nextLine();
    scan.close();
    ArrayList<Integer> foo = new ArrayList<Integer>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'Z')
        addIndexes(s, i, p, d, foo);
    }
    ArrayList<Integer> goo = new ArrayList<Integer>();
    for (Integer integer : foo) {
      if (!goo.contains(integer))
        goo.add(integer);
    }
    System.out.println(s.length() - goo.size());
  }

  public static void addIndexes(String s, int startingIndex, int p, int d, ArrayList<Integer> indexes) {
    int x = 0;

    for (int i = startingIndex; i < startingIndex + p; i++) {
      int h = i % s.length();
      x += (s.charAt(h) == 'Z' ? 1 : 0);
      if (x >= d) {
        indexes.add(h);
      }

    }

  }
}