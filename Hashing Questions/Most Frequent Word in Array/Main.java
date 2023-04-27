import java.io.*;
import java.util.*;

class Solution {

  public void mostFrequent(String[] arr, int n) {
    // write your code here
    Map<String, Integer> map = new HashMap<>();
    String ans = "";
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
      if (max <= map.get(arr[i])) {
        max = map.get(arr[i]);
        ans = arr[i];
      }
    }
    System.out.print(ans);
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = sc.next();
    }
    Solution Obj = new Solution();
    Obj.mostFrequent(arr, n);
    System.out.println('\n');
  }
}
