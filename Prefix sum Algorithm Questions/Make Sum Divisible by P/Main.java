import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, q;
    n = sc.nextInt();
    q = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    Solution obj = new Solution();
    System.out.println(obj.minSubarray(a, n, q));
  }
}

class Solution {

  public int minSubarray(int[] nums, int n, int p) {
    //Write code here
    int[] mod = new int[n + 1];
    for (int i = 0; i < n; i++) {
      mod[i + 1] = ((mod[i] + nums[i]) % p + p) % p;
    }
    if (mod[n] == 0) return 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    int res = n;
    for (int i = 1; i <= n; i++) {
      int temp = ((mod[i] - mod[n]) % p + p) % p;
      if (map.containsKey(temp)) {
        int l = i - map.get(temp);
        res = Math.min(l, res);
      }
      map.put(mod[i], i);
    }
    return res == n ? -1 : res;
  }
}
