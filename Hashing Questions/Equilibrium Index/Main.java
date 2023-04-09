import java.util.*;

public class Main {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int ans = Solution.findEquilibriumIndex(a);
    System.out.println(ans);
  }
}

class Solution {

  static int findEquilibriumIndex(int[] a) {
    //Write code here
    int n = a.length;
    int total = 0;
    for (int i = 0; i < n; i++) {
      total += a[i];
    }
    int lsum = 0;
    int rsum = total;
    for (int i = 0; i < n; i++) {
      rsum = rsum - a[i];
      if (lsum == rsum) {
        return i;
      }
      lsum += a[i];
    }
    return -1;
  }
}
