import java.util.Scanner;

/**
 * Hiss
 */
public class Hiss {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println(scan.nextLine().contains("ss") ? "hiss" : "no hiss");
    scan.close();
  }
}