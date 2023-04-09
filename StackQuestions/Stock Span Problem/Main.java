import java.io.*;
import java.util.*;

class Pair {

  int val;
  int idx;

  Pair(int val, int idx) {
    this.val = val;
    this.idx = idx;
  }
}

public class Main {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    Solution s = new Solution();
    int ans[] = s.stockSpan(a);
    for (int i = 0; i < n; i++) {
      System.out.print(ans[i] + " ");
    }
  }
}

class Solution {

  static int[] nextGreaterElementonLeft(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int ngel[] = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      int ele = arr[i];
      while (stack.size() > 0 && ele > arr[stack.peek()]) {
        int idx = stack.peek();
        stack.pop();
        ngel[idx] = i;
      }
      stack.push(i);
    }
    while (stack.size() > 0) {
      int idx = stack.pop();
      ngel[idx] = -1;
    }
    return ngel;
  }

  static int[] stockSpan(int[] a) {
    int[] ngel = nextGreaterElementonLeft(a);
    int span[] = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      span[i] = i - ngel[i];
    }
    return span;
  }
}
