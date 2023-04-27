import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {

  public static int solve(String s) {
    //Write code here and print output
    int n = s.length();

    int count = 0;
    for (int i = 0; i < n / 2; i++) {
      if (s.charAt(i) != s.charAt(n - 1 - i)) {
        count++;
      }
    }
    return (count <= 1) ? 1 : 0;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String A = sc.nextLine();
    Solution Obj = new Solution();
    int ans = Obj.solve(A);
    System.out.println(ans);
  }
}
