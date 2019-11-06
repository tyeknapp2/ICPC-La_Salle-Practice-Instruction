import java.util.Scanner;
import java.util.ArrayList;

/**
 * GlitchBot Solution
 * 
 * @author Tye Knappenberger
 */
public class GlitchBot {
  public static void main(String[] args) {
    // input handling
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

    // initalization of goal variables
    boolean replaceWithForward = false;
    boolean replaceWithRight = false;
    boolean replaceWithLeft = false;
    int numOfReplacedStep = -1;

    /*
     * This
     */
    for (int i = 0; i < instructions.size(); i++) {

      replaceWithForward = !instructions.get(i).equals("Forward")
          ? arrivalCheck(instructions, x, y, 0, 0, "North", i, "Forward", 0)
          : false;
      replaceWithRight = !instructions.get(i).equals("Right")
          ? arrivalCheck(instructions, x, y, 0, 0, "North", i, "Right", 0)
          : false;
      replaceWithLeft = !instructions.get(i).equals("Left")
          ? arrivalCheck(instructions, x, y, 0, 0, "North", i, "Left", 0)
          : false;

      if (replaceWithForward || replaceWithRight || replaceWithLeft) {
        numOfReplacedStep = i + 1;
        break;
      }
    }

    System.out.println(numOfReplacedStep + " " + (replaceWithForward ? "Forward" : "") + (replaceWithLeft ? "Left" : "")
        + (replaceWithRight ? "Right" : ""));

  }

  /**
   * 
   * @param instructions        The array list of instructions
   * @param goalX               This should be passed the X value given in the
   *                            input
   * @param goalY               This should be passed the Y value given in the
   *                            input
   * @param currX               This should be passed zero
   * @param currY               This should be passed zero
   * @param currRot             This should be passed "North"
   * @param stepToReplace       the index of the the instruction to be replace in
   *                            the instructions ArrayList
   * @param replacementInstruct the instruction to do instead;
   * @param step
   * @return
   */
  public static boolean arrivalCheck(ArrayList<String> instructions, int goalX, int goalY, int currX, int currY,
      String currRot, int stepToReplace, String replacementInstruct, int step) {
    if (step == instructions.size()) {
      return (currX == goalX && currY == goalY);
    } else if (step == stepToReplace) {
      return arrivalCheck(instructions, goalX, goalY, updateX(currX, currRot, replacementInstruct),
          updateY(currY, currRot, replacementInstruct), updateRot(currRot, replacementInstruct), stepToReplace,
          replacementInstruct, step + 1);
    } else {
      return arrivalCheck(instructions, goalX, goalY, updateX(currX, currRot, instructions.get(step)),
          updateY(currY, currRot, instructions.get(step)), updateRot(currRot, instructions.get(step)), stepToReplace,
          replacementInstruct, step + 1);
    }
  }

  /**
   * 
   * @param initRot  the
   * @param instruct
   * @return
   */
  public static String updateRot(String initRot, String instruct) {
    if (instruct.equals("Forward")) {
      return initRot;
    } else if (instruct.equals("Right")) {
      switch (initRot.charAt(0)) {
      case 'N':
        return "East";
      case 'E':
        return "South";
      case 'S':
        return "West";
      default:
        return "North";
      }
    } else {
      switch (initRot.charAt(0)) {
      case 'N':
        return "West";
      case 'E':
        return "North";
      case 'S':
        return "East";
      default:
        return "South";
      }
    }
  }

  /**
   * 
   * @param x
   * @param rot
   * @param instruct
   * @return
   */
  public static int updateX(int x, String rot, String instruct) {
    if (instruct.equals("Forward") && (rot.equals("East") || rot.equals("West")))
      return (rot.equals("East") ? x + 1 : x - 1);
    else
      return x;

  }

  /**
   * 
   * @param y
   * @param rot
   * @param instruct
   * @return
   */
  public static int updateY(int y, String rot, String instruct) {
    if (instruct.equals("Forward") && (rot.equals("North") || rot.equals("South")))
      return (rot.equals("North") ? y + 1 : y - 1);
    else
      return y;

  }
}