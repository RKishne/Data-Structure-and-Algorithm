import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {

  public static boolean isPossible(int arr[], long cap, int B) {
    int numOfDays = 1;
    long weightOnTheDay = 0;
    for (int w : arr) {
      if (weightOnTheDay + w <= cap) {
        weightOnTheDay += w;
      } else {
        numOfDays++;
        weightOnTheDay = w;
      }
    }
    return numOfDays <= B;
  }

  public static long solve(int[] A, int B) {
    //Write your code here
    long si = 0;
    long ei = 0;
    for (int r : A) {
      si = Math.max(si, r);
      ei += r;
    }
    long pans = -1;
    while (si <= ei) {
      long mid = (si + ei) / 2;
      if (isPossible(A, mid, B) == true) {
        pans = mid;
        ei = mid - 1;
      } else {
        si = mid + 1;
      }
    }
    return pans;
  }
}

class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    int B = sc.nextInt();
    System.out.println(Solution.solve(A, B));
  }
}
