import java.io.*;
import java.util.*;

class Solution {

  public String smallestNumber(String str) {
    // write code here
    String ans = "";
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i <= str.length(); i++) {
      st.push(i + 1);
      if (i == str.length() || str.charAt(i) == 'i') {
        while (!st.isEmpty()) {
          ans += String.valueOf(st.peek());
          ans += "";
          st.pop();
        }
      }
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Solution Obj = new Solution();
    System.out.print(Obj.smallestNumber(str));
  }
}
