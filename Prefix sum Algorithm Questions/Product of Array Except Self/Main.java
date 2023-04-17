import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int nums[] = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    Solution obj = new Solution();
    long ans[] = obj.ProductOfArrayExceptSelf(n, nums);
    for (int i = 0; i < n; i++) {
      System.out.print(ans[i] + " ");
    }
  }
}

class Solution {

  public long[] ProductOfArrayExceptSelf(int n, int[] a) {
    //write code here
    if (n == 1) {
      return new long[0];
    }
    long[] left = new long[n];
    long[] right = new long[n];
    long[] product = new long[n];

    left[0] = 1;

    right[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      left[i] = a[i - 1] * left[i - 1];
    }
    for (int j = n - 2; j >= 0; j--) {
      right[j] = a[j + 1] * right[j + 1];
    }
    for (int i = 0; i < n; i++) {
      product[i] = left[i] * right[i];
    }
    return product;
  }
}
