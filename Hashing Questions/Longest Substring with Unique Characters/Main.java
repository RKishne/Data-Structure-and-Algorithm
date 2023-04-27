import java.util.*;

class Solution {

  public int longestSubstring(String s) {
    //Write your code here
    HashMap<Character, Integer> hm = new HashMap<>();

    int left = 0;
    int right = 0;
    int len = 0;
    int n = s.length();

    while (right < n) {
      if (hm.containsKey(s.charAt(right))) {
        left = Math.max(hm.get(s.charAt(right)) + 1, left);
      }
      hm.put(s.charAt(right), right);
      len = Math.max(len, right - left + 1);
      right++;
    }
    return len;
  }
}

public class Main {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    Solution ob = new Solution();
    int ans = ob.longestSubstring(s);
    System.out.println(ans);
  }
}
