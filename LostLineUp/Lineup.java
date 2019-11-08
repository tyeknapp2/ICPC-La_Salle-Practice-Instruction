import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Lineup {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> dists = new ArrayList<Integer>();
    HashMap<Integer, Integer> distToOrder = new HashMap<Integer, Integer>();
    int u = scan.nextInt();
    for (int i = 2; i <= u; i++) {
      int h = scan.nextInt();
      distToOrder.put(h, i);
      dists.add(h);
    }
    Collections.sort(h);
    String outString = "1 ";
    for (Integer integer : dists) {
      outString += distToOrder.get(integer) + " ";
    }
    System.out.println(outString.trim());
  }
}