import java.io.*;
import java.util.*;

class Solution {

  static boolean isPossible(int arr[], int p, int max) {
    int numOfOpt = 0;
    for (int x : arr) {
      if (x > p) {
        int opt = 0;
        if (x % p == 0) {
          opt = (x / p) - 1;
        } else {
          opt = x / p;
        }
        numOfOpt += opt;
      }
    }
    return numOfOpt <= max;
  }

  public static int solve(int n, int m, int arr[]) {
    // Write your code here
    int si = 1;
    int ei = 0;
    int pans = -1;
    for (int b : arr) {
      ei = Math.max(ei, b);
    }
    while (si <= ei) {
      int mid = (si + ei) / 2;
      if (isPossible(arr, mid, m) == true) {
        pans = mid;
        ei = mid - 1;
      } else {
        si = mid + 1;
      }
    }
    return pans;
  }
}

public class Main {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] arr;
    arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = input.nextInt();
    System.out.println(Solution.solve(n, m, arr));
  }
}
