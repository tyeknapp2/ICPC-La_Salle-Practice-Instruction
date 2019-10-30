import java.util.Scanner;
import java.util.ArrayList;

/**
 * OddGnome
 */
public class OddGnome {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> gnomes;
    int numTests = scan.nextInt();
    for (int h = 0; h < numTests; h++) {
      int numGnomes = scan.nextInt();
      gnomes = new ArrayList<Integer>();
      for (int i = 0; i < numGnomes; i++) {
        gnomes.add(scan.nextInt());
      }
      for (int i = 0; i < numGnomes; i++) {
        System.out
            .print((gnomes.get(i) < gnomes.get(0) || gnomes.get(i) > gnomes.get(numGnomes - 1)) ? ((i + 1) + "") : "");
      }
      System.out.println();
    }
    scan.close();
  }
}