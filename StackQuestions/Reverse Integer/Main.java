import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {

  public int reverseInteger(int x) {
    // write code here

    Stack<Integer> stack = new Stack<>();
    int rev = 0;
    if (x > 10000000) {
      return 0;
    }
    while (x > 0 || x < 0) {
      int digit = x % 10;
      stack.push(digit);
      int idx = stack.pop();
      rev = (rev * 10) + idx;
      x = x / 10;
    }
    return rev;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    Solution obj = new Solution();
    System.out.println(obj.reverseInteger(x));
  }
}
