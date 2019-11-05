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
        z = i + 1;
        break;
      }
    }
    System.out.println(z + " " + (repForward ? "Forward" : "") + (repLeft ? "Left" : "") + (repRight ? "Right" : ""));

  }

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

  public static int updateX(int x, String rot, String instruct) {
    if (instruct.equals("Forward") && (rot.equals("East") || rot.equals("West")))
      return (rot.equals("East") ? x + 1 : x - 1);
    else
      return x;

  }

  public static int updateY(int y, String rot, String instruct) {
    if (instruct.equals("Forward") && (rot.equals("North") || rot.equals("South")))
      return (rot.equals("North") ? y + 1 : y - 1);
    else
      return y;

  }
}