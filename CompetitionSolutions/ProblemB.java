import java.util.Scanner;
import java.math.BigInteger;

/**
 * ProblemB
 * 
 * @author Tye Knappenberger Shania Kiat Brendan Funk
 */
public class ProblemB {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    BigInteger total = BigInteger.ZERO;
    BigInteger[] cards = new BigInteger[10];
    for (int i = 0; i < 10; i++) {
      cards[i] = scan.nextBigInteger();
    }
    int z = scan.nextInt();
    scan.close();
    switch (z) {
    case 1:
      for (int i = 0; i < 10; i++)
        total = total.add(cards[i]);
      break;
    case 2:
      for (int i = 0; i < 9; i++)
        for (int j = i + 1; j < 10; j++)
          total = total.add(cards[i].multiply(cards[j]));
      break;
    case 3:
      for (int i = 0; i < 8; i++)
        for (int j = i + 1; j < 9; j++)
          for (int h = j + 1; h < 10; h++)
            total = total.add(cards[h].multiply(cards[i]).multiply(cards[j]));
      break;
    case 4:
      for (int i = 0; i < 7; i++)
        for (int j = i + 1; j < 8; j++)
          for (int h = j + 1; h < 9; h++)
            for (int k = h + 1; k < 10; k++)
              total = total.add(cards[k].multiply(cards[h]).multiply(cards[i]).multiply(cards[j]));
      break;
    case 5:
      for (int i = 0; i < 6; i++)
        for (int j = i + 1; j < 7; j++)
          for (int h = j + 1; h < 8; h++)
            for (int k = h + 1; k < 9; k++)
              for (int l = k + 1; l < 10; l++)
                total = total.add(cards[l].multiply(cards[k]).multiply(cards[h]).multiply(cards[i]).multiply(cards[j]));
      break;
    case 6:
      for (int i = 0; i < 5; i++)
        for (int j = i + 1; j < 6; j++)
          for (int h = j + 1; h < 7; h++)
            for (int k = h + 1; k < 8; k++)
              for (int l = k + 1; l < 9; l++)
                for (int r = l + 1; r < 10; r++)
                  total = total.add(cards[r].multiply(cards[l]).multiply(cards[k]).multiply(cards[h]).multiply(cards[i])
                      .multiply(cards[j]));
      break;
    case 7:
      for (int i = 0; i < 4; i++)
        for (int j = i + 1; j < 5; j++)
          for (int h = j + 1; h < 6; h++)
            for (int k = h + 1; k < 7; k++)
              for (int l = k + 1; l < 8; l++)
                for (int r = l + 1; r < 9; r++)
                  for (int y = r + 1; y < 10; y++)
                    total = total.add(cards[y].multiply(cards[r]).multiply(cards[l]).multiply(cards[k])
                        .multiply(cards[h]).multiply(cards[i]).multiply(cards[j]));
      break;
    case 8:
      for (int i = 0; i < 3; i++)
        for (int j = i + 1; j < 4; j++)
          for (int h = j + 1; h < 5; h++)
            for (int k = h + 1; k < 6; k++)
              for (int l = k + 1; l < 7; l++)
                for (int r = l + 1; r < 8; r++)
                  for (int y = r + 1; y < 9; y++)
                    for (int p = y + 1; p < 10; p++)
                      total = total.add(cards[p].multiply(cards[y]).multiply(cards[r]).multiply(cards[l])
                          .multiply(cards[k]).multiply(cards[h]).multiply(cards[i]).multiply(cards[j]));
      break;
    case 9:
      for (int i = 0; i < 2; i++)
        for (int j = i + 1; j < 3; j++)
          for (int h = j + 1; h < 4; h++)
            for (int k = h + 1; k < 5; k++)
              for (int l = k + 1; l < 6; l++)
                for (int r = l + 1; r < 7; r++)
                  for (int y = r + 1; y < 8; y++)
                    for (int p = y + 1; p < 9; p++)
                      for (int d = p + 1; d < 10; d++)
                        total = total
                            .add(cards[d].multiply(cards[p]).multiply(cards[y]).multiply(cards[r]).multiply(cards[l])
                                .multiply(cards[k]).multiply(cards[h]).multiply(cards[i]).multiply(cards[j]));
      break;
    default:
      for (int i = 0; i < 1; i++)
        for (int j = i + 1; j < 2; j++)
          for (int h = j + 1; h < 3; h++)
            for (int k = h + 1; k < 4; k++)
              for (int l = k + 1; l < 5; l++)
                for (int r = l + 1; r < 6; r++)
                  for (int y = r + 1; y < 7; y++)
                    for (int p = y + 1; p < 8; p++)
                      for (int d = p + 1; d < 9; d++)
                        for (int c = 0; c < 10; c++)
                          total = total.add(cards[c].multiply(cards[d]).multiply(cards[p]).multiply(cards[y])
                              .multiply(cards[r]).multiply(cards[l]).multiply(cards[k]).multiply(cards[h])
                              .multiply(cards[i]).multiply(cards[j]));
      break;
    }
    System.out.println(total);
  }
}