import java.util.Scanner;

/**
 * My Solution to problem K: SummerTrip in the ICPC North-American Qualifier
 * 2019
 * 
 * @author Tye Knappenberger
 */
public class Summer {
  public static void main(String[] args) {
    /**
     * This section handles getting the input and it saves it to the variable
     * calendar
     */
    Scanner scan = new Scanner(System.in);
    String calendar = scan.nextLine();
    scan.close();
    // +++++++++++++++++++++++++++++++++++++++++++

    // this intializes what we are trying to keep track of
    int numGoodItineraries = 0;

    /*
     * this is going to iterate through our calendar of events calculating
     * numGoodItineraries
     */
    for (int i = 0; i < calendar.length() - 1; i++) {
      /*
       * Since a good itinerary cannot contain the beginning event twice whenever we
       * have a series of consecutive events we want to move directly to the end of
       * that series without checking for good itineraries since we know they are
       * impossible.
       * 
       * Imagine the case aaab. In that case, we know the first two a's have zero good
       * itineraries starting at them because any atempt to make an itinerary from
       * them would include at least another a and one of the requirements of our good
       * itinerary is that the starting event must be unique therefore only the last a
       * in that series of a's an be a valid starting point
       * 
       * Note: due to the way I structured our for loop calendar.charAt(i + 1) will
       * never throw an indexOutOfBounds error
       */
      if (calendar.charAt(i) == calendar.charAt(i + 1)) {
        // the continue statemate is used to force a loop to the next iteration
        continue;
      }

      String subSequence = calendar.substring(i + 1);
      if (subSequence.contains(calendar.charAt(i) + "")) {
        subSequence = subSequence.substring(0, subSequence.indexOf(calendar.charAt(i) + ""));
      }

      numGoodItineraries += numOfLetters(subSequence);
    }
    System.out.println(numGoodItineraries);
  }

  /**
   * 
   *
   * @param input
   * @return The number of unique letters contained in the input
   */
  public static int numOfLetters(String input) {
    int uniqueLetters = 0;
    /*
     * Your friendly reminder that chars can be added and subtracted from due to the
     * way ASCII works. There are TONS of ways to use this throughout the
     * competition and will save you lots of pain when setting up character logic.
     * You can add chars together, compare them using <,>,<=,>= and ==, and various
     * other things.
     * 
     * This for loop iterates through the lower case 
     * 
     * (I GOT TO USE A FOR LOOP THAT ITERATES USING CHARS!!!!!!!!!!!!!!!!)
     */

    for (char l = 'a'; l <= 'z'; l++) {
      if (input.contains(l + "")) {
        uniqueLetters++;
      }
    }
    return uniqueLetters;
  }
}