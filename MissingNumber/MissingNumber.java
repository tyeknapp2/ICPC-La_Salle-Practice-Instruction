import java.util.Scanner;

public class MissingNumber {
  public static void main(String[] args) {
    // initializes an array of ints 1-200
    int[] oneToTwoHundred = new int[200];
    for (int i = 0; i < 200; i++) {
      oneToTwoHundred[i] = i + 1;
    }
    // this is the index of the oneToTwoHundred array
    int index = 0;

    // Keeps track of whether the kid did a good job
    boolean didAGoodJob = true;

    // intialize the scanner
    Scanner scan = new Scanner(System.in);
    // throw away the useless first int
    scan.nextInt();

    // this loop compares what the kid said to the actual number line
    while (scan.hasNext()) {
      int whatTheKidSaid = scan.nextInt();

      // if the kid messes up this loop prints all the numbers he missed
      while (whatTheKidSaid != oneToTwoHundred[index]) {
        // we also set the good job tracker to false
        didAGoodJob = false;
        System.out.println(oneToTwoHundred[index++]);
      }
      index++;
    }
    scan.close();

    if (didAGoodJob) {
      System.out.println("good job");
    }
  }
}