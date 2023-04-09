import java.util.*;

class Solution {

  static int countEqualSubarray01(int arr[], int n) {
    //Write your code here//Write your code here
    int cnt0 = 0;
    int cnt1 = 0;

    int d1 = cnt1 - cnt0;

    String key = d1 + "#";

    int ans = 0;

    HashMap<String, Integer> map = new HashMap<>();
    map.put(key, 1);

    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        cnt0++;
      } else if (arr[i] == 1) {
        cnt1++;
      }
      d1 = cnt1 - cnt0;

      key = d1 + "#";
      if (map.containsKey(key) == true) {
        ans += map.get(key);
        map.put(key, map.get(key) + 1);
      } else {
        map.put(key, 1);
      }
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int arr[] = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Solution Obj = new Solution();
    System.out.println(Obj.countEqualSubarray01(arr, N));
  }
}
