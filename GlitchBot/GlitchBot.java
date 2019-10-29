import java.util.Scanner;
import java.util.ArrayList;

public class GlitchBot {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    int y = scan.nextInt();
    int numInstructions = scan.nextInt();
    ArrayList<String> instructions = new ArrayList<String>();
    scan.nextLine();
    for (int i = 0; i < numInstructions; i++) {
      instructions.add(scan.nextLine());
    }
    scan.close();


  }

  public static boolean arrivalCheck() {
    
    return false;
  }
}