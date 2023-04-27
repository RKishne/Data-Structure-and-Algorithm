import java.io.*;
import java.util.*;

class Solution {

  public boolean check(int last, int[] arr, int n) {
    for (int i = n - 2; i >= 0; i--) {
      if (last <= arr[i]) {
        return false;
      }
    }
    return true;
  }

  public int findElement(int[] arr, int n) { // arr{5 1 4 4} n=4
    // Write your code here
    int min[] = new int[n];
    int max[] = new int[n];

    if (check(arr[n - 1], arr, n)) {
      return (n - 1);
    }
    for (int i = 0; i < n; i++) {
      min[i] = 1000000;
      max[i] = 0;
    }
    max[0] = arr[0]; // max 5
    for (int i = 1; i < n; i++) {
      max[i] = Math.max(max[i - 1], arr[i]); // max{5 5 5 5}
    }
    min[n - 1] = arr[n - 1]; // min 4
    for (int i = n - 2; i >= 0; i--) {
      min[i] = Math.min(min[i + 1], arr[i]); // min {1 1 4 4}
    }
    for (int i = 1; i < n - 1; i++) {
      if (arr[i] < min[i + 1] && arr[i] > max[i - 1]) {
        return i;
      }
    }
    return -1;
  }
}

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }

    Solution Obj = new Solution();
    System.out.println(Obj.findElement(nums, n));
  }
}
