import java.util.*;

class Solution {

  public static boolean checkValidString(int n, String s) {
    //write code here
    //without stack 
    /*if (s == null || s.length() == 0) {
      return true;
    }

    int lo = 0;
    int hi = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == '(') {
        lo++;
        hi++;
      } else if (c == ')') {
        if (lo > 0) {
          lo--;
        }
        hi--;
      } else {
        if (lo > 0) {
          lo--;
        }
        hi++;
      }

      if (hi < 0) {
        return false;
      }
    }

    return lo == 0;*/
    int open =0;
    for(int i=0;i<n;i++){
        char ch=s.charAt(i);
        if(ch=='(' || ch=='*'){
            open++;
        }
        else{
            open--;
        }
        if(open<0){
            return false;
        }
    }
    if(open==0){
        return true;
    }
    int close=0;
    for(int i=n-1;i>=0;i--){
        char ch=s.charAt(i);
        if(ch==')' || ch=='*'){
            close++;
        }
        else{
            close--;
        }
        if(close<0){
            return false;
        }
    }
    return true;
  }
}

public class Main {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    String s = sc.next();
    Solution obj = new Solution();
    boolean ans = obj.checkValidString(n, s);
    if (ans == true) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}
