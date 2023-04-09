import java.io.*;
import java.util.*;

class Solution {

  public String minWindow(String s, String t) {
    // write code here
    HashMap<Character, Integer> map2 = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      map2.put(ch, map2.getOrDefault(ch, 0) + 1);
    }
    String ans = "";
    HashMap<Character, Integer> map1 = new HashMap<>();
    int dmcnt = t.length();
    int mcnt = 0;
    int inc = -1;
    int exc = -1;
    while (true) {
      boolean f1 = false;
      //include step
      while (inc + 1 < s.length() && mcnt < dmcnt) {
        inc = inc + 1;
        char ch = s.charAt(inc);
        map1.put(ch, map1.getOrDefault(ch, 0) + 1);

        if (map2.containsKey(ch) == true && map1.get(ch) <= map2.get(ch)) {
          mcnt++;
        }
        f1 = true;
      }
      // exculde step.
      boolean f2 = false;
      while (exc < inc && dmcnt == mcnt) {
        String pans = s.substring(exc + 1, inc + 1);
        if (ans.length() == 0 || pans.length() < ans.length()) {
          ans = pans;
        }
        exc = exc + 1;
        char ch = s.charAt(exc);
        map1.put(ch, map1.get(ch) - 1);

        if (map2.containsKey(ch) == true && map1.get(ch) < map2.get(ch)) {
          mcnt--;
        }
        if (map1.get(ch) == 0) {
          map1.remove(ch);
        }
        f2 = true;
      }
      if (f1 == false && f2 == false) {
        break;
      }
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s, t;
    s = sc.next();
    t = sc.next();
    Solution Obj = new Solution();
    System.out.print(Obj.minWindow(s, t));
  }
}
