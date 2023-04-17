import java.io.*;
import java.util.*;

public class Main {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    int ans = Solution.bestTimeToBuyAndSell(n, a);
    System.out.println(ans);
  }
}

class Solution {

  static int bestTimeToBuyAndSell(int n, int[] prices) {
    int maxprofit = 0;
    int buy = prices[0];
    for (int i = 1; i < n; i++) {
      if (buy > prices[i]) {
        buy = prices[i];
      } else if (prices[i] - buy > maxprofit) {
        maxprofit = prices[i] - buy;
      }
    }
    return maxprofit;
  }
}
