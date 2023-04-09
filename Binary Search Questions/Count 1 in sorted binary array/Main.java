import java.util.*;

class Solution {

  static int count1(int size, int arr[]) {
    //Write your code here
    int si = 0;
    int ei = size - 1;
    while (si <= ei) {
      int mid = (si + ei) / 2;
      if (arr[mid] < 1) {
        ei = mid - 1;
      } else if (arr[mid] > 1) {
        si = mid + 1;
      } else {
        if (mid == size - 1 || arr[mid + 1] != 1) {
          return mid + 1;
        } else {
          si = mid + 1;
        }
      }
    }
    return 0;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int array[] = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }
    Solution Obj = new Solution();
    System.out.println(Obj.count1(n, array));
  }
}
