import java.util.*;

class Solution {

  public static int longestSubarray(int[] arr) {
    // write code here
    int n = arr.length;
    //count of 0.
    int cnt0 = 0;
    //count of 1
    int cnt1 = 0;
    //count of 2
    int cnt2 = 0;
    //
    int d1 = cnt1 - cnt0;
    int d2 = cnt2 - cnt1;
    String key = d1 + "=" + d2;
    HashMap<String, Integer> map = new HashMap<>();
    map.put(key, -1);

    int maxLen = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        cnt0++;
      } else if (arr[i] == 1) {
        cnt1++;
      } else if (arr[i] == 2) {
        cnt2++;
      }
      d1 = cnt1 - cnt0;
      d2 = cnt2 - cnt1;

      key = d1 + "=" + d2;
      if (map.containsKey(key) == true) {
        int len = i - map.get(key);
        maxLen = Math.max(maxLen, len);
      } else {
        map.put(key, i);
      }
    }
    return maxLen;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    Solution Obj = new Solution();
    System.out.println(Obj.longestSubarray(arr));
  }
}
