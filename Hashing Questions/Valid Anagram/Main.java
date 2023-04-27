import java.util.*;

class Solution {

  public static boolean isValid(
    Map<Character, Integer> ahm,
    Map<Character, Integer> bhm
  ) {
    for (char c : bhm.keySet()) {
      int idealfreq = bhm.get(c);
      if (!ahm.containsKey(c) || ahm.get(c) < idealfreq) return false;
    }
    return true;
  }

  static boolean areAnagram(String c1, String c2) {
    //Write your code here
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    for (int i = 0; i < c1.length(); i++) {
      char ch = c1.charAt(i);
      map1.put(ch, map1.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < c2.length(); i++) {
      char ch = c2.charAt(i);
      map2.put(ch, map2.getOrDefault(ch, 0) + 1);
    }
    if (c1.length() == c2.length()) {
      if (isValid(map1, map2)) {
        return true;
      }
    }
    return false;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    String str2 = sc.nextLine();
    Solution Obj = new Solution();

    if (Obj.areAnagram(str1, str2)) System.out.println(
      "Yes"
    ); else System.out.println("No");
  }
}
