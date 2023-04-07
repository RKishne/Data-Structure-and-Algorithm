import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {

  public static long[] prevGreater(long[] arr, int n) {
    //Write code here and print output
    Stack<Integer> stack = new Stack<>();
    long ngel[] = new long[n];
    for (int i = n - 1; i >= 0; i--) {
      long ele = arr[i];
      while (stack.size() > 0 && ele > arr[stack.peek()]) {
        int idx = stack.peek();
        stack.pop();
        ngel[idx] = ele;
      }
      stack.push(i);
    }
    while (stack.size() > 0) {
      int idx = stack.pop();
      ngel[idx] = -1;
    }
    return ngel;
  }
}

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().trim());
    String inputLine[] = br.readLine().trim().split(" ");
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
    long[] res = new Solution().prevGreater(arr, n);
    for (int i = 0; i < n; i++) System.out.print(res[i] + " ");
    System.out.println();
  }
}
