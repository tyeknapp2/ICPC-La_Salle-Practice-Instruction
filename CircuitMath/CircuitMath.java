import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

/**
 * This is a simple stack calculator for boolean expressions
 * 
 * @author TyeKnappenberger
 */
public class CircuitMath {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // this is the number of inputs to keep track of
    int numInputs = scan.nextInt();

    // this will be used to reference the value of the inputs
    HashMap<Character, Boolean> inputs = new HashMap<Character, Boolean>();

    // this is where all the math is stored as we perform the operations
    Stack<Boolean> stackCalculator = new Stack<Boolean>();

    // this intializes the hashmap keying each truth value to its input label
    for (char i = 'A'; i < 'A' + numInputs; i++) {
      inputs.put(i, (scan.next().equals("T") ? true : false));
    }

    // this gets us to the next line of input
    scan.nextLine();

    /*
     * I could have solved this using a while(scan.hasNext()) loop and indeed it
     * would have (probably) been more efficient however for testing purposes I
     * chose to go with saving the whole line as a string since it made manually
     * typing in the input trivial
     */
    String postfixExpression = scan.nextLine();

    // close the scanner because you should
    scan.close();

    // this evaluates the expression
    for (int i = 0; i < postfixExpression.length(); i++) {
      evalPostfix(inputs, stackCalculator, postfixExpression, i);
    }

    // this pops out the answer, thransforms it and prints it
    System.out.println((stackCalculator.pop() ? 'T' : 'F'));
  }

  private static void evalPostfix(HashMap<Character, Boolean> inputs, Stack<Boolean> stackCalculator,
      String postfixExpression, int i) {
    if (postfixExpression.charAt(i) == ' ') {
      return;
    } else if (postfixExpression.charAt(i) == '*') {
      /*
       * This handles AND gates
       * 
       * Java Stacks are weird you cannot do these three statements on one line
       * because when I did put it on one line it was pushing everything back onto the
       * stack. I don't know why that happened, whether it is a design flaw or
       * intentional or whether it was with push or pop. Just know that when you
       * actually want to pop something out of the stack that should go on its own
       * line
       *
       */
      boolean t = stackCalculator.pop();
      boolean h = stackCalculator.pop();
      stackCalculator.push(t && h);
    } else if (postfixExpression.charAt(i) == '+') {
      // This handles OR gates
      boolean t = stackCalculator.pop();
      boolean h = stackCalculator.pop();
      stackCalculator.push(t || h);
    } else if (postfixExpression.charAt(i) == '-') {
      // This handles NOT gates
      boolean t = !stackCalculator.pop();
      stackCalculator.push(t);
    } else {
      // This handles inputs
      stackCalculator.push(inputs.get(postfixExpression.charAt(i)));
    }
  }
}