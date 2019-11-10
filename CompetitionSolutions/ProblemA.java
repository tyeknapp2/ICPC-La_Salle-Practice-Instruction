import java.util.Scanner;
import java.util.Stack;

/**
 * ProblemA
 * 
 * @author Tye Knappenberger Shania Kiat Brendan Funk
 */
public class ProblemA {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Stack<Integer> signatures = new Stack<Integer>();
    int numDesks = scan.nextInt();
    int loopCount = 1;
    signatures.push(scan.nextInt());
    for (int i = 1; i < numDesks; i++) {
      int currDesk = scan.nextInt();
      loopCount += (signatures.peek() > currDesk ? 1 : 0);
      signatures.push(currDesk);
    }
    scan.close();
    System.out.println(loopCount);
  }

}