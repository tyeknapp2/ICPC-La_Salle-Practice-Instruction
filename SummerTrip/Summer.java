import java.util.Scanner;

/**
 * My Solution to problem K: SummerTrip in the ICPC North-American Qualifier
 * 2019
 * 
 * @author Tye Knappenberger
 */
public class Summer {
  public static void main(String[] args) {
    /*
     * This section handles getting the input and it saves it to the variable
     * calendar
     */
    Scanner scan = new Scanner(System.in);
    String calendar = scan.nextLine();
    scan.close();

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
       * in that series of a's can be a valid starting point
       * 
       * Note: due to the way I structured our for loop calendar.charAt(i + 1) will
       * never throw an indexOutOfBounds error
       */
      if (calendar.charAt(i) == calendar.charAt(i + 1)) {
        // the continue statemate is used to force a loop to the next iteration
        continue;
      }

      /*
       * Here we create the subsequence we are going to look at. When looking for good
       * itineraries we dont want to look at characters before our starting point; as
       * it turns out, we don't even want to look at the starting character, more on
       * that later.
       */
      String subSequence = calendar.substring(i + 1);

      /*
       * Reminder: a good itinerary has a unique event as its start. This means that
       * we only have to check for good itineraries between our starting index and the
       * index of the next occurence of the char at the starting index. This is the
       * reason we trimmed off the starting char in the subSequence declaration so
       * that checking for another instance of the starting char would be trivial. If
       * there is no other occurence then we want to check all the way to the end of
       * the calendar string.
       * 
       * Also this is the notation for a shortcut if/else statement its very good for
       * assignments depending on a boolean expression. It works the same as it does
       * in JavaScript
       * 
       * (Boolean statement to check) ? toReturnIfTrue : toReturnIfFalse;
       */
      subSequence = (subSequence.contains(calendar.charAt(i) + ""))
          ? subSequence.substring(0, subSequence.indexOf(calendar.charAt(i) + ""))
          : subSequence;

      /*
       * Finally its time to count our good itineraries. Remember a good intinerary is
       * any sequence of characters where the first and last events are completely
       * unique in that sequence. Repeats in the middle are allowed but the first and
       * last events may not ever appear in the sequence other than in the first and
       * last slots. We have already accounted for the first events uniqueness. So all
       * that is left is to deal with the last event.
       * 
       * As it turns out dealing with the last event's uniqueness is surprisingly
       * simple. All you have to do is count the number of different letters in
       * subSequence and voila the number of different good itineraries.
       * 
       * This is proved by two theorems:
       * 
       * Theorem one: If a char occurs in the subSequence string, then there exists a
       * first occurence of that char.
       * 
       * Proof: The subSequence string is finite. So if a char is selected it is
       * either the first or you can continue finding its copies to the left until you
       * arrive at the first occurence where no more copies to the left exist.
       * 
       * Theorem two: If and only if you select the first occurence of a particular
       * char in the subSequence string, then you create a good itinerary between the
       * starting index and the index of that char.
       * 
       * Proof by contradiction of the first part: Supose that you have selected the
       * first occurence of a particular char in the subSequence string and you don't
       * have a good itineray between it and the starting index. Then either the
       * begining or ending character has repeated. Well the beginning cannot repeat
       * since we've already restricted the subSequence string to not include any
       * occurence of the beginning character. If the ending character was to be
       * repeated then we didn't select the first occurence of the particular char
       * thus giving us our contradiction proving that if you select the first
       * occurence of a particular char in the subSequence string, then you create a
       * good itinerary between the starting index and the index of that char.
       * 
       * Proof by contradiction of the second part: Supose that you have a good
       * itinerary, and that the character you have selected for the end is not the
       * first occurence of that character. Then the first occurence of that character
       * must be in your itinerary therefore the last character isn't unique but in a
       * good itineray the last character must be unique giving us our contradiction
       * therefore proving that if you have a good itinerary between the starting
       * point and the index of a particular char then you must have selected the
       * first occurence of that particular char in the subSequence string.
       * 
       * Using those two theorems together we can come to the conclussion that all we
       * have to do to get the number of good intineraries is to count the number of
       * different letters in each of our subSequence strings.
       *
       * @see numOfDifferentLetters
       */
      numGoodItineraries += numOfDifferentLetters(subSequence);
    }
    // printing out our final answer
    System.out.println(numGoodItineraries);
  }

  /**
   * 
   *
   * @param input a string containing events
   * @return The number of unique letters contained in the input
   */
  public static int numOfDifferentLetters(String input) {
    // intializes our count
    int differentLetters = 0;

    /*
     * There are two ways one could go about finding the number of unique characters
     * in a sequence. You could go through the sequence character by character and
     * tally unique char's as you go along. You would do this in a situation where
     * the number of possible chars is greater than the expected string length. Say
     * for example, counting the number of different characters in strings of approx
     * length 30 containning any ASCII character out there. This is very common and
     * obviously you wouldn't want to manually check every character possible but
     * rather go through the string char by char and keep an ArrayList that only
     * contains one of each char as they show up and return the length of that
     * ArrayList.
     * 
     * HOWEVER, this is NOT one of those cases. If we were to do this problem the
     * above way our algorithm would approx to O(n)=n^n.
     * 
     * In this problem the strings are restricted to contain only chars between a-z
     * all lowercase leaving a very manageable 26 characters to check and our
     * subSequence string could be incredibly long being up to 99999 characters long
     * therefore checking the by possible chars makes a lot of sense. By doing it
     * this way you bring our algorithm down to simply O(n)=n^2. (A huge reduction)
     * 
     * (My O(n) estimates are assuming all the string methods I am using are O(n)=1
     * which in reality isn't technically true but they are incredibly efficient and
     * in competition you can pretty much assume that they will never cause you
     * efficiency problems )
     * 
     * It can be noted that you could implement a hybrid method here that handles
     * strings the first way if they are under length 26 or the second way if they
     * are greater for more time efficency but that is entirely unnecessary in this
     * problem.
     * 
     * Your friendly reminder that chars can be added and subtracted from due to the
     * way ASCII works. There are TONS of ways to use this throughout the
     * competition and will save you lots of pain when setting up character logic.
     * You can add chars together, compare them using <,>,<=,>= and ==, and various
     * other things.
     * 
     * (I GOT TO USE A FOR LOOP THAT ITERATES USING CHARS!!!!!!!!!!!!!!!!)
     */
    for (char l = 'a'; l <= 'z'; l++) {
      if (input.contains(l + "")) {
        differentLetters++;
      }
    }
    return differentLetters;
  }
}