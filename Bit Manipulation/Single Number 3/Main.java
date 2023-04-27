import java.util.*;

class Solution {

  public static Boolean checkKthBit(int n, int k) {
    // Your code here
    int mask = (1 << k);
    return (n & mask) > 0;
  }

  public int[] singleNumber3(int n, int[] nums) {
    // write code here
    int XOROfAll = 0;
    for (int x : nums) XOROfAll ^= x;
    //in xorOfAll we will be having a^b - xor of the numbers which are unique

    //we have to find the position of rightmost set bit in XorOfAll
    //that bit indicate, kth bit different in both unique numbers
    int k = 0;
    while ((XOROfAll & (1 << k)) == 0) k++; //the loop will keep on running until 1<<k comes under RMSB
    //make 2 sets, the first set should maintain the xor all the elements having kth bit set,
    // and second should be having kth but unset
    int kthBitSet = 0;
    int kthBitUnSet = 0;

    //we will iterate over the array, and for every number we will check if kth bit is set or not
    // in order to
    for (int x : nums) {
      if (checkKthBit(x, k)) {
        kthBitSet ^= x;
      } else {
        kthBitUnSet ^= x;
      }
    }
    //now the two variables kthBitSet and kthBitUnset are having my unique values
    int res[] = new int[2];
    res[0] = kthBitSet;
    res[1] = kthBitUnSet;
    Arrays.sort(res);
    return res;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    Solution Obj = new Solution();
    scn.close();
    int[] ans = Obj.singleNumber3(n, arr);
    System.out.print(ans[0] + " " + ans[1]);
  }
}
