import java.util.*;

class Solution {

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    //Write code here
    if (k == 0) return 0;
    int sp = 0;
    int ep = 0;
    int currWidProd = 1;
    int ans = 0;
    while (ep < nums.length) {
      //step1 introduce new member in the window
      currWidProd *= nums[ep];
      //step2 shrink the window  untill it is invalid
      while (currWidProd >= k) {
        currWidProd /= nums[sp];
        sp++;
      }
      //step3 consider answer
      ans += ep - sp + 1;
      //step4 expand window
      ep++;
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    int k;
    k = sc.nextInt();
    Solution Obj = new Solution();
    int result = Obj.numSubarrayProductLessThanK(arr, k);
    System.out.println(result);
    sc.close();
  }
}
