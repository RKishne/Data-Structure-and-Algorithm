import java.io.*;
import java.util.*;

class Main {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = input.nextInt();
    }
    Solution solution = new Solution();
    List<List<Integer>> result = solution.threeSum(nums);
    //Sort all lists inside the list first
    for (int i = 0; i < result.size(); i++) {
      Collections.sort(result.get(i));
    }
    //Sort the list
    Collections.sort(
      result,
      new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {
          for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) < l2.get(i)) return -1; else if (
              l1.get(i) > l2.get(i)
            ) return 1;
          }
          return 0;
        }
      }
    );
    for (int i = 0; i < result.size(); i++) {
      for (int j = 0; j < result.get(i).size(); j++) {
        System.out.print(result.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }
}

class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> ans = new ArrayList<>();
    int i = 0;
    while (i < n) {
      int l = i + 1;
      int r = n - 1;

      int newTarget = 0 - nums[i];
      while (l < r) {
        int currSum = nums[l] + nums[r];
        if (currSum == newTarget) {
          List<Integer> currTrip = new ArrayList<>();
          currTrip.add(nums[i]);
          currTrip.add(nums[l]);
          currTrip.add(nums[r]);
          ans.add(currTrip);

          int prevL = nums[l];
          while (l < r && nums[l] == prevL) l++;

          int prevR = nums[r];
          while (l < r && nums[r] == prevR) r--;
        } else if (currSum < newTarget) {
          int prevL = nums[l];
          while (l < r && nums[l] == prevL) l++;
        } else {
          int prevR = nums[r];
          while (l < r && nums[r] == prevR) r--;
        }
      }
      int prevI = nums[i];
      while (i < n && nums[i] == prevI) i++;
    }
    return ans;
  }
}
