import java.util.*;

class Solution {

  public void allDuplicates(int n, int[] arr) {
    // Write Your code here.
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] == arr[j]) {
          System.out.print(arr[i] + " ");
        }
      }
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    Solution Obj = new Solution();
    Obj.allDuplicates(n, arr);
    sc.close();
  }
}
