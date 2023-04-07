import java.io.*;
import java.util.*;

class Solution {

  boolean expBalanced(String str) {
    // write code here
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
        continue;
      }
      if (stack.isEmpty()) {
        return false;
      }
      char check;
      if (ch == ')') {
        check = stack.pop();
        if (check == '{' || check == '[') {
          return false;
        }
      } else if (ch == '}') {
        check = stack.pop();
        if (check == '(' || check == '[') {
          return false;
        }
      } else if (ch == ']') {
        check = stack.pop();
        if (check == '{' || check == '(') {
          return false;
        }
      }
    }
    if (stack.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Solution Obj = new Solution();
    System.out.println(Obj.expBalanced(str));
  }
}
