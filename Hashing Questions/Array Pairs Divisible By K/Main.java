import java.io.*;
import java.util.*;

class Solution {

  public boolean arrayPairs(int[] arr, int k) {
    // write code here
    int n = arr.length;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int rem = arr[i] % k;
      hm.put(rem, hm.getOrDefault(rem, 0) + 1);
    }
    for (int i = 0; i < k; i++) {
      if (i == 0) {
        if (hm.getOrDefault(0, 0) % 2 == 1) {
          return false;
        }
      } else if (hm.getOrDefault(i, 0) != hm.getOrDefault(k - i, 0)) {
        return false;
      }
    }
    return true;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, k;
    n = sc.nextInt();
    k = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    Solution Obj = new Solution();
    if (Obj.arrayPairs(arr, k)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}
