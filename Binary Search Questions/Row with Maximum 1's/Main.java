import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, m;
    n = sc.nextInt();
    m = sc.nextInt();
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    Solution s = new Solution();
    System.out.println(s.rowWithMaximumOnes(arr, n, m));
  }
}

class Solution {

  static int rowWithMaximumOnes(int arr[][], int n, int m) {
    int maximum = 0;
    int count = 0;
    int a = 0;
    for (int i = 0; i < n; i++) {
      count = 0;
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 1) {
          count++;
        }
      }
      if (count > maximum) {
        maximum = count;
        a = i;
      }
    }
    return a;
  }
}
