import java.io.*;
import java.util.*;

class Solution {

  public int peakIndexInMountainArray(int[] arr) {
    // Your code here.
    int low = 0;
    int high = arr.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (arr[mid] >= arr[mid + 1]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int arr1[] = new int[n];
    for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
    Solution Obj = new Solution();
    int result = Obj.peakIndexInMountainArray(arr1);
    System.out.print(result + " ");
    System.out.println('\n');
  }
}
