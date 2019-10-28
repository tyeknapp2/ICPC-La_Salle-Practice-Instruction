import java.util.Scanner;

public class MissingNumber {
  public static void main(String[] args) {
    int[] basic = new int[200];
    for (int i = 0; i < 200; i++) {
      basic[i] = i + 1;
    }
    int index = 0;
    boolean boo = true;
    Scanner scan = new Scanner(System.in);
    scan.nextInt();
    while (scan.hasNext()) {
      int y = scan.nextInt();
      while (y != basic[index]) {
        boo = false;
        System.out.println(basic[index++]);
      }
      index++;
    }
    scan.close();
    if (boo) {
      System.out.println("good job");
    }
  }
}