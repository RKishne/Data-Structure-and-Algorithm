import java.io.*;
import java.util.*;

class Solution {

  static int solve(int n, int[] arr, int k) {
    // Write your code here
    HashMap<Integer, Integer> hm = new HashMap<>();
    hm.put(0, 1);
    int ans = 0;
    int currsum = 0;
    for (int i = 0; i < n; i++) {
      currsum += arr[i];
      if (hm.containsKey(currsum - k)) {
        ans += hm.get(currsum - k);
        hm.put(currsum, hm.getOrDefault(currsum, 0) + 1);
      } else {
        hm.put(currsum, hm.getOrDefault(currsum, 0) + 1);
      }
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    int N = Integer.parseInt(br.readLine().trim());
    String[] arr_Arr = br.readLine().split(" ");
    int[] Arr = new int[N];
    for (int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++) {
      Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
    }
    int K = Integer.parseInt(br.readLine().trim());

    int out_ = Solution.solve(N, Arr, K);
    System.out.println(out_);

    wr.close();
    br.close();
  }
}
