import java.util.ArrayList;
import java.util.Scanner;

/**
 * ProgressiveScramble
 * 
 * @author TyeKnappenberger
 */
public class ProgressiveScramble {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    scan.nextLine();
    while (scan.hasNext()) {
      String s = scan.nextLine();
      System.out.println((s.charAt(0) == 'e' ? encode(s.substring(2)) : decode(s.substring(2))));
    }

  }

  public static String encode(String toEncode) {
    String encodedMsg = "";
    ArrayList<Integer> u = new ArrayList<Integer>();
    for (int i = 0; i < toEncode.length(); i++) {
      if (toEncode.charAt(i) == ' ') {
        u.add(0);
      } else {
        u.add((int) (toEncode.charAt(i) - 'a') + 1);
      }
    }
    for (int i = 1; i < u.size(); i++) {
      u.set(i, u.get(i));
    }
    return encodedMsg;
  }

  public static  decode(String toDecode) {
    String  decodeMsg="";

    return decodeMsg;
  }
}