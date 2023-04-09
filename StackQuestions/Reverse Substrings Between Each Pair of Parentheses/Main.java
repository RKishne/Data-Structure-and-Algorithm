import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(reverseParentheses(s));
  }

  public static void reverse(char a[], int l, int h) {
    if (l < h) {
      char ch = a[l];
      a[l] = a[h];
      a[h] = ch;
      reverse(a, l + 1, h - 1);
    }
  }

  public static String reverseParentheses(String s) {
    // your code here
    String ans = "";
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        st.push(i);
      } else if (ch == ')') {
        char a[] = s.toCharArray();
        reverse(a, st.peek() + 1, i);
        s = String.valueOf(a);
        st.pop();
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '(' && s.charAt(i) != ')') {
        ans += s.charAt(i);
      }
    }
    return ans;
  }
}
