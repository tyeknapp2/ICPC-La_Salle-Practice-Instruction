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
    Stack<Boolean> c = new Stack<Boolean>();
    for (char i = 'A'; i < 'A' + x; i++) {
      v.put(i, (scan.next().equals("T") ? true : false));
    }
    scan.nextLine();
    String s = scan.nextLine();
    scan.close();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        continue;
      } else if (s.charAt(i) == '*') {
        boolean t = c.pop();
        boolean h = c.pop();
        c.push(t && h);
      } else if (s.charAt(i) == '+') {
        boolean t = c.pop();
        boolean h = c.pop();
        c.push(t || h);
      } else if (s.charAt(i) == '-') {
        boolean t = !c.pop();
        c.push(t);
      } else {
        c.push(v.get(s.charAt(i)));
      }
    }
    System.out.println((c.pop() ? 'T' : 'F'));
  }
}