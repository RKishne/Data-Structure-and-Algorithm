import java.util.*;

class Main {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int t = sc.nextInt();
      while (t > 0) {
        int n = sc.nextInt();
        int[] A = new int[n];
        int m = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
          A[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        int ans = ob.minDays(A, n, m, k);
        System.out.println(ans);
        t--;
      }
    }
  }
}

class Solution {

  boolean isPossible(int arr[], int mid, int madecakes, int k) {
    int c = 0;
    int t = 0;
    for (int r : arr) {
      if (r > mid) {
        c = 0;
      } else {
        c++;
        if (c == k) {
          t++;
          c = 0;
        } else {
          continue;
        }
      }
    }
    return t >= madecakes;
  }

  public int minDays(int[] bloomDay, int n, int m, int k) {
    //Write code here
    if ((m + k) > n) {
      return -1;
    }
    int si = 0;
    int ei = 100000;
    int pans = -1;
    while (si <= ei) {
      int mid = si + (ei - si) / 2;
      if (isPossible(bloomDay, mid, m, k) == true) {
        pans = mid;
        ei = mid - 1;
      } else {
        si = mid + 1;
      }
    }
    return pans;
  }
}
