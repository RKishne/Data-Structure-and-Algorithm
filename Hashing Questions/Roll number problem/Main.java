import java.util.*;

class Solution {

  static int[] findRepeatingAndMissingNumbers(int[] nums) {
    //Write code here and print output
    int ans[] = new int[2];
    int freq[] = new int[100001];
    for (int i = 0; i < nums.length; i++) {
      freq[nums[i]]++;
    }
    boolean flag = true;
    for (int i = 1; i <= nums.length; i++) {
      if (freq[i] == 0) {
        ans[1] = i;
      }
      if (freq[i] == 2) {
        ans[0] = i;
      }
      flag = false;
    }
    if (flag == true) {
      return new int[-1];
    }
    return ans;
  }
}

public class Main {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    int[] ans = Solution.findRepeatingAndMissingNumbers(nums);
    System.out.print(ans[0] + " " + ans[1] + "\n");
  }
}
