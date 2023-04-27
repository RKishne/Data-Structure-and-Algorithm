import java.io.*;
import java.util.*;

class Solution {

  public long pairDifference(int[] A, int n, int k) {
    // write code here
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (i != 0 && A[i] == A[i - 1] && k != 0) {
        continue;
      }
      if (k == 0) {
        if (map.containsKey(A[i] - k)) {
          count += map.get(A[i] - k);
        }
      } else {
        if (map.containsKey(A[i] - k)) {
          count += map.get(A[i] - k);
        }
        if (map.containsKey(A[i] + k)) {
          count += map.get(A[i] + k);
        }
      }
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }
    return count;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, k;
    n = sc.nextInt();
    k = sc.nextInt();
    int[] mat = new int[n];
    for (int i = 0; i < n; ++i) {
      mat[i] = sc.nextInt();
    }
    Solution Obj = new Solution();
    System.out.println(Obj.pairDifference(mat, n, k));
    System.out.println('\n');
  }
}
