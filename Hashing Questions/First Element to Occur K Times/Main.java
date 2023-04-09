import java.io.*;
import java.util.*;

class Solution {

  public void firstElementToOccurKTimes(int[] nums, int n, int k) {
    // Your code here
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
      if (map.get(nums[i]) == k) {
        System.out.println(nums[i]);
        return;
      }
    }
    System.out.println(-1);
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, k;
    n = sc.nextInt();
    k = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    Solution Obj = new Solution();
    Obj.firstElementToOccurKTimes(nums, n, k);
    System.out.println();
  }
}
