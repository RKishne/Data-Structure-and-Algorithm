import java.io.*;
import java.util.*;
import java.util.HashMap;

class Solution {

  public int maxLen(int arr[]) {
    // Write your code here
    HashMap<Integer, Integer> hm = new HashMap<>();
    int n = arr.length;
    int sum = 0;
    int maxlen = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
      if (hm.containsKey(sum) == true) {
        int len = i - hm.get(sum);
        maxlen = Math.max(len, maxlen);
      } else {
        hm.put(sum, i);
      }
    }
    if (sum == 0) {
      return n;
    }
    return maxlen;
  }
}

class Main {

  public static void main(String arg[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    Solution Obj = new Solution();
    System.out.println(Obj.maxLen(nums));
  }
}
