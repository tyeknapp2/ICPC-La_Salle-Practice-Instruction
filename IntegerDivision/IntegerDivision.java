import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerDivision
 * Not Acc
 */
public class IntegerDivision {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int d = scan.nextInt();
    ArrayList<Integer> nums = new ArrayList<Integer>();
    while (n > 0) {
      nums.add(scan.nextInt());
      n--;
    }
    scan.close();
    Collections.sort(nums);
    int pairs = 0;
    int r = 0;
    int currInt = nums.get(nums.size() - 1) / d;

    for (int i = (nums.size() - 1); i >= 0; i--) {
      if (nums.get(i) / d == currInt) {
        pairs += r++;
      } else {
        r = 1;
        currInt = nums.get(i) / d;
      }
    }
    System.out.println(pairs);
  }
}