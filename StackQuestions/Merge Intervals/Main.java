import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {

  public void merge(int[][] intervals) {
    // Your code here, Print your output here
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      if (ans.size() == 0) {
        ArrayList<Integer> interval = new ArrayList<>();
        interval.add(intervals[i][0]);
        interval.add(intervals[i][1]);
        ans.add(interval);
      } else {
        ArrayList<Integer> prevInterval = ans.remove(ans.size() - 1);
        if (prevInterval.get(1) >= intervals[i][0]) {
          ArrayList<Integer> interval = new ArrayList<>();
          interval.add(prevInterval.get(0));
          interval.add(Math.max(prevInterval.get(1), intervals[i][1]));
          ans.add(interval);
        } else {
          ans.add(prevInterval);
          ArrayList<Integer> interval = new ArrayList<>();
          interval.add(intervals[i][0]);
          interval.add(intervals[i][1]);
          ans.add(interval);
        }
      }
    }
    int[][] sol = new int[ans.size()][2];
    for (int i = 0; i < sol.length; i++) {
      sol[i][0] = ans.get(i).get(0);
      sol[i][1] = ans.get(i).get(1);
    }
    for (int i = 0; i < ans.size(); i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(sol[i][j] + " ");
      }
      System.out.println();
    }
  }
}

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int m;
    m = sc.nextInt();
    int[][] A = new int[m][2];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < 2; j++) {
        A[i][j] = sc.nextInt();
      }
    }
    Solution Obj = new Solution();
    Obj.merge(A);
  }
}
