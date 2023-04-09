import java.util.*;

class Solution {

  static void missingNumbers(int n, int arr[], int m, int brr[]) {
    //Write your code here
    int fre1[] = new int[10001];
    int fre2[] = new int[10001];
    for (int i = 0; i < n; i++) {
      fre1[arr[i]]++;
    }
    for (int i = 0; i < m; i++) {
      fre2[brr[i]]++;
    }
    boolean flag = true;
    for (int i = 0; i < 10001; i++) {
      if (fre2[i] != 0 && fre1[i] != fre2[i]) {
        System.out.print(i + " ");
        flag = false;
      }
    }
    if (flag == true) {
      System.out.print(-1);
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int m = sc.nextInt();
    int brr[] = new int[m];
    for (int i = 0; i < m; i++) {
      brr[i] = sc.nextInt();
    }

    Solution Obj = new Solution();
    Obj.missingNumbers(n, arr, m, brr);
  }
}
