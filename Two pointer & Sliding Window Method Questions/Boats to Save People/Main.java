import java.io.*;
import java.util.*;

class Solution {

  public static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int sp = 0;
    int ep = people.length - 1;
    int ans = 0;

    while (sp <= ep) {
      ans++;
      if (people[sp] + people[ep] <= limit) {
        sp++;
      }
      ep--;
    }
    return ans;
  }
}

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println(Solution.numRescueBoats(nums, k));
  }
}
