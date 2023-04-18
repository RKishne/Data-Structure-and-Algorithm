import java.util.*;

class Solution {

  public int longestWindowXUniqueAtleastKreapting(String s, int k, int x) {
    int countUnique = 0;
    int countRep = 0;
    int sp = 0;
    int ep = 0;
    int ans = 0;

    int freq[] = new int[123];

    while (ep < s.length()) {
      //introduce
      int nc = s.charAt(ep);
      freq[nc]++;

      if (freq[nc] == 1) countUnique++;
      if (freq[nc] == k) countRep++;

      while (countUnique > x) {
        int dc = s.charAt(sp);

        freq[dc]--;

        if (freq[dc] == 0) countUnique--;
        if (freq[dc] == k - 1) countRep--;

        sp++;
      }
      if (countUnique == x && countRep == x) {
        ans = Math.max(ans, ep - sp + 1);
      }
      ep++;
    }
    return ans;
  }

  public int longestSubstring(String s, int k) {
    // write code here
    int ans = 0;
    for (int i = 1; i <= 26; i++) {
      int xuniquerep = longestWindowXUniqueAtleastKreapting(s, k, i);
      ans = Math.max(ans, xuniquerep);
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    int k = scn.nextInt();
    Solution Obj = new Solution();
    System.out.println(Obj.longestSubstring(str, k));
  }
}
