import java.util.Scanner;

/**
 * ANewAlphabet
 * 
 * @author Tye Knappenberger
 */
public class ANewAlphabet {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine().toLowerCase();
    scan.close();
    String outString = "";
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
      case 'a':
        outString += "@";
        break;
      case 'b':
        outString += "8";
        break;
      case 'c':
        outString += "(";
        break;
      case 'd':
        outString += "|)";
        break;
      case 'e':
        outString += "3";
        break;
      case 'f':
        outString += "#";
        break;
      case 'g':
        outString += "6";
        break;
      case 'h':
        outString += "[-]";
        break;
      case 'i':
        outString += "|";
        break;
      case 'j':
        outString += "_|";
        break;
      case 'k':
        outString += "|<";
        break;
      case 'l':
        outString += "1";
        break;
      case 'm':
        outString += "[]\\/[]";
        break;
      case 'n':
        outString += "[]\\[]";
        break;
      case 'o':
        outString += "0";
        break;
      case 'p':
        outString += "|D";
        break;
      case 'q':
        outString += "(,)";
        break;
      case 'r':
        outString += "|Z";
        break;
      case 's':
        outString += "$";
        break;
      case 't':
        outString += "']['";
        break;
      case 'u':
        outString += "|_|";
        break;
      case 'v':
        outString += "\\/";
        break;
      case 'w':
        outString += "\\/\\/";
        break;
      case 'x':
        outString += "}{";
        break;
      case 'y':
        outString += "`/";
        break;
      case 'z':
        outString += "2";
        break;
      default:
        outString += s.charAt(i);
      }
    }
    System.out.println(outString);
  }
}