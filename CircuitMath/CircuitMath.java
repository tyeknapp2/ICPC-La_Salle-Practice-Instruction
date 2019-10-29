import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

/**
 * This is a simple stack calculator
 * 
 * @author TyeKnappenberger
 */
public class CircuitMath {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    HashMap<Character, Boolean> v = new HashMap<Character, Boolean>();
    for (char i = 'A'; i < 'A' + x; i++) {
      v.put(i, (scan.next().equals("T") ? true : false));
    }
    scan.nextLine();
    String s = scan.nextLine();
    scan.close();

  }
}