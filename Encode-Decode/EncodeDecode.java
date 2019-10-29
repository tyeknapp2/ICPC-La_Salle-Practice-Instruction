import java.util.Scanner;

public class EncodeDecode {
  public static void main(String[] args) {
    // handle input
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    scan.close();

    System.out.println(((input.charAt(0) == 'E') ? encode(input.substring(2)) : decode(input.substring(2))));

  }

  public static String decode(String in) {
    String out = "";

    /*
     * This for loop increments by two because we are guaranteed an encoded string
     * of even length due to the encoding method. You can think of the it as
     * encoding pairs a char followed by an int and that it loops through those
     * pairs
     */
    for (int i = 0; i < in.length(); i += 2) {

      // this grabs the character. Notice that I leave it as a String
      String let = in.substring(i, i + 1);
      /*
       * Note: String.lenght() is a valid ending index for String.substring(int
       * beginIndex, int endIndex)
       */
      int num = Integer.parseInt(in.substring(i + 1, i + 2));
      for (int j = 0; j < num; j++) {
        // the fact that i left let as a string saves me the hassle of converting
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
        // adds the let
        out += let + "" + letCount;
        let = in.charAt(i);
        letCount = 1;
      }
    }
    // after the for loop the last letter and its count will need to be added
    out += let + "" + letCount;
    return out;
  }
}