import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

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
    boolean repForward = false;
    boolean repRight = false;
    boolean repLeft = false;
    int z = -1;
    for (int i = 0; i < instructions.size(); i++) {
      repForward = arrivalCheck(instructions, x, y, 0, 0, "North", i, "Forward", 0);
      repRight = arrivalCheck(instructions, x, y, 0, 0, "North", i, "Right", 0);
      repLeft = arrivalCheck(instructions, x, y, 0, 0, "North", i, "Left", 0);
      if (repForward || repRight || repLeft) {
        z = i;
        break;
      }
    }
    System.out.println(z + " " + (repForward ? "Forward" : "") + (repLeft ? "Left" : "") + (repRight ? "Right" : ""));

  }

  public static boolean arrivalCheck(ArrayList<String> intstructions, int goalX, int goalY, int currX, int currY,
      String currRot, int stepToReplace, String replacementInstruct, int step) {
    if (step == intstructions.size()) {
      return (currX == goalX && currY == goalY);
    } else if (step == stepToReplace) {
      return arrivalCheck(intstructions, goalX, goalY, updateX(currX, currRot, replacementInstruct),
          updateY(currY, currRot, replacementInstruct), updateRot(currRot, replacementInstruct), stepToReplace,
          replacementInstruct, step + 1);
    } else {
      return arrivalCheck(intstructions, goalX, goalY, updateX(currX, currRot, intstructions.get(step)),
          updateY(currY, currRot, intstructions.get(step)), updateRot(currRot, intstructions.get(step)), stepToReplace,
          replacementInstruct, step + 1);
    }
  }

  public static String updateRot(String initRot, String instruct) {
    if (instruct.equals("Forward")) {
      return initRot;
    } else if (instruct.equals("Right")) {
      switch (initRot.charAt(0)) {
      case N:
        return "East";
        break;
      case E:
        return "South";
        break;
      case S:
        return "West";
        break;
      default:
        return "North";
        break;
      }
    } else {
      switch (initRot.charAt(0)) {
      case N:
        return "West";
        break;
      case E:
        return "North";
        break;
      case S:
        return "East";
        break;
      default:
        return "South";
        break;
      }
    }
  }

  public static int updateX(int x, String rot, String instruct) {
    if (intstruct.equals("Forward") && (rot.equals("North") || rot.equals("South")))
      return (rot.equals("North") ? x + 1 : x - 1);
    else
      return x;

  }

  public static int updateY(int y, String rot, String instruct) {
    if (intstruct.equals("Forward") && (rot.equals("East") || rot.equals("West")))
      return (rot.equals("East") ? y + 1 : y - 1);
    else
      return y;

  }
}