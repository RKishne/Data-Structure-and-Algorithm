import java.util.*;

class Solution {

  public int numRabbits(int[] answers) {
    // write code here
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int ans : answers) {
      map.put(ans, map.getOrDefault(ans, 0) + 1);
    }
    int minRabbitVerified = 0;
    for (int key : map.keySet()) {
      int gs = key + 1;
      int noOfAns = map.get(key);

      int fullyFilledGroups = noOfAns / gs;
      int partiallyFilledGroups = noOfAns % gs;

      int numberOfGroups = fullyFilledGroups * gs;
      if (partiallyFilledGroups > 0) {
        numberOfGroups += 1;
      }
      int rabbitFigureOut = numberOfGroups * gs;
      minRabbitVerified += rabbitFigureOut;
    }
    return minRabbitVerified;
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
    System.out.println(Obj.numRabbits(arr));
  }
}
