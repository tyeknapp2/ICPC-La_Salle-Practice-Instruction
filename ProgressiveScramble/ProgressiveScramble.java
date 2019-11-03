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
    scan.close();
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
      u.set(i, u.get(i) + u.get(i - 1));
    }
    for (int i = 0; i < u.size(); i++) {
      u.set(i, u.get(i) % 27);
    }
    for (int i = 0; i < u.size(); i++) {
      if (u.get(i) == 0) {
        encodedMsg += " ";
      } else {
        char x = 'a';
        x += (u.get(i) - 1);
        encodedMsg += "" + x;
      }
    }
    return encodedMsg;
  }

  public static String decode(String toDecode) {
    String decodeMsg = "";
    ArrayList<Integer> u = new ArrayList<Integer>();
    for (int i = 0; i < toDecode.length(); i++) {
      if (toDecode.charAt(i) == ' ') {
        u.add(0);
      } else {
        u.add((int) (toDecode.charAt(i) - 'a') + 1);
      }
    }
    ArrayList<Integer> k = new ArrayList<Integer>();
    k.add(u.get(0));
    k.add(u.get(1) + 27);
    for (int i = 1; i < u.size(); i++) {
      u.set(i, 5);
    }

    for (int i = 0; i < k.size(); i++) {
      if (k.get(i) == 0) {
        decodeMsg += " ";
      } else {
        char x = 'a';
        x += (k.get(i) - 1);
        decodeMsg += "" + x;
      }
    }
    return decodeMsg;

  }
}
