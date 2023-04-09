import java.io.*;
import java.util.*;

class Solution {

  public int givenDifference(int[] arr, int n, int B) {
    // write your code here
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int partner1 = arr[i] - B;
      int partner2 = arr[i] + B;
      if (set.contains(partner1) || set.contains(partner2)) {
        return 1;
      } else {
        set.add(arr[i]);
      }
    }
    return 0;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, B;
    n = sc.nextInt();
    int[] mat = new int[n];
    for (int i = 0; i < n; ++i) {
      mat[i] = sc.nextInt();
    }
    B = sc.nextInt();
    Solution Obj = new Solution();
    System.out.println(Obj.givenDifference(mat, n, B));
    System.out.println('\n');
  }
}
