import java.util.*;

class Solution {

  public boolean isValid(
    HashMap<Character, Integer> ahm,
    HashMap<Character, Integer> bhm
  ) {
    for (char c : bhm.keySet()) {
      int idealfreq = bhm.get(c);
      if (!ahm.containsKey(c) || ahm.get(c) < idealfreq) return false;
    }
    return true;
  }

  public String SmallestSubstring(String a, String b) {
    // Write your code here
    HashMap<Character, Integer> bhm = new HashMap<>();
    HashMap<Character, Integer> ahm = new HashMap<>();
    for (int i = 0; i < b.length(); i++) {
      char ch = b.charAt(i);
      bhm.put(ch, bhm.getOrDefault(ch, 0) + 1);
    }
    int left = 0;
    int right = 0;
    String ans = "";
    int ansLen = Integer.MAX_VALUE;
    while (right < a.length()) {
      char ch = a.charAt(right);
      ahm.put(ch, ahm.getOrDefault(ch, 0) + 1);

      while (isValid(ahm, bhm)) {
        if (ansLen > right - left + 1) {
          ans = a.substring(left, right + 1);
          ansLen = right - left + 1;
        }
        ahm.put(a.charAt(left), ahm.get(a.charAt(left)) - 1);
        left++;
      }
      right++;
    }
    if (ans.length() == 0) {
      return -1 + "";
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next(), b = sc.next();
    Solution Obj = new Solution();
    System.out.println(Obj.SmallestSubstring(a, b));
  }
}
