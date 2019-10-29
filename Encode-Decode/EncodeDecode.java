import java.util.Scanner;

public class EncodeDecode {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    scan.close();
    System.out.println(((input.charAt(0) == 'E') ? encode(input.substring(2)) : decode(input.substring(2))));

  }

  public static String decode(String in) {
    String out = "";
    for (int i = 0; i < in.length(); i += 2) {
      String let = in.substring(i, i + 1);
      int num = Integer.parseInt(in.substring(i + 1, i + 2));
      for (int j = 0; j < num; j++) {
        out += let;
      }
    }
    return out;
  }

  public static String encode(String in) {
    String out = "";
    char let = in.charAt(0);
    int letCount = 0;
    for (int i = 0; i < in.length(); i++) {
      if (in.charAt(i) == let) {
        letCount++;
      } else {
        out += let + "" + letCount;
        let = in.charAt(i);
        letCount = 1;
      }
    }
    out += let + "" + letCount;
    return out;
  }
}