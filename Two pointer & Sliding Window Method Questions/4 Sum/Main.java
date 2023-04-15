import java.io.*;
import java.util.*;

class Solution {

  public List<List<Integer>> fourSum(int[] arr, int target) {
    // Write your code here
    //we are avoiding duplicate cases by ensuring that whenever we;ll move a pointer that pointer points to a new number,
    //in case we are having duplicate numbes in the array.
    Arrays.sort(arr);
    int n = arr.length;
    List<List<Integer>> ans = new ArrayList<>();
    int i = 0;

    while (i < n) {
      int j = i + 1;
      while (j < n) {
        //problem is reduced to two sum on the remaining target
        int l = j + 1; //remaining array will start at j+
        int r = n - 1; //last index in array

        long newTarget = (long) ((long) target - (long) (arr[i] + arr[j]));
        while (l < r) {
          long currSum = (long) (long) arr[l] + (long) arr[r];
          if (currSum == newTarget) { //newTarget is the target we are searching for in the remaing array
            List<Integer> currQuad = new ArrayList<>();
            currQuad.add(arr[i]);
            currQuad.add(arr[j]);
            currQuad.add(arr[l]);
            currQuad.add(arr[r]);
            ans.add(currQuad);

            //this ensures that l comes to a new number in the array
            int prevL = arr[l];
            while (l < r && arr[l] == prevL) l++;

            int prevR = arr[r];
            while (l < r && arr[r] == prevR) r--;
          } else if (currSum < newTarget) {
            int prevL = arr[l];
            while (l < r && arr[l] == prevL) l++;
          } else {
            int prevR = arr[r];
            while (l < r && arr[r] == prevR) r--;
          }
        }
        int prevJ = arr[j];
        while (j < n && arr[j] == prevJ) j++;
      }
      int prevI = arr[i];
      while (i < n && arr[i] == prevI) i++;
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
    int k = sc.nextInt();
    Solution Obj = new Solution();
    List<List<Integer>> res = Obj.fourSum(nums, k);

    for (int i = 0; i < res.size(); i++) {
      Collections.sort(res.get(i));
    }

    Collections.sort(
      res,
      new Comparator<List<Integer>>() {
        public int compare(List<Integer> frst, List<Integer> scnd) {
          int i = 0;
          while (frst.get(i) == scnd.get(i)) i++;
          return frst.get(i) - scnd.get(i);
        }
      }
    );

    for (int i = 0; i < res.size(); i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(res.get(i).get(j) + " ");
      }
      System.out.println("");
    }
    sc.close();
  }
}
