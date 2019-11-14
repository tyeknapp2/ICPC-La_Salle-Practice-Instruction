import java.util.Scanner;
public class Cake { 
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int h = scan.nextInt();
    int v = scan.nextInt();
    scan.close();
    System.out.println(4 * (n - h > h ? n - h : h) * (n - v > v ? n - v : v));
  }
}