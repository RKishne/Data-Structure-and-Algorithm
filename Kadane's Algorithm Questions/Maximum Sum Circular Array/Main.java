import java.util.*;

class Solution {

  public int MaxSum(int[] arr, int n) {
    // Write your code here
    int total = 0;
    int maxSumSubarray = Integer.MIN_VALUE;
    int minSumSubarray = Integer.MAX_VALUE;

    int trainMax = 0;
    int trainMin = 0;

    for (int i = 0; i < n; i++) {
      total += arr[i];

      //calculate maxsumsubarray
      int maxprev = trainMax + arr[i];
      int maxNew = arr[i];
      trainMax = Math.max(maxprev, maxNew);
      maxSumSubarray = Math.max(maxSumSubarray, trainMax);

      //calculate minsumsubarray
      int minprev = trainMin + arr[i];
      int minNew = arr[i];
      trainMin = Math.min(minprev, minNew);
      minSumSubarray = Math.min(minSumSubarray, trainMin);
    }
    //if all the people in array are +ve
    if (total == maxSumSubarray) return total;

    //if all the people in array are -ve
    if (total == minSumSubarray) return maxSumSubarray; //if a single element

    //if answer is in the array itself
    int itself = maxSumSubarray;

    //if i need to do a wrap around
    int wraparound = total - minSumSubarray;

    return Math.max(itself, wraparound);
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    Solution Obj = new Solution();
    int ans = Obj.MaxSum(arr, n);
    System.out.println(ans);
  }
}
