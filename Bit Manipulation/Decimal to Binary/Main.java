import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    Solution obj = new Solution();
    obj.toBinary(N);
    System.out.println();
  }
}

class Solution {

  void toBinary(int N) {
    //Write your code here

    int[] binaryNum = new int[1000];

    // counter for binary array
    int i = 0;
    while (N > 0) {
      // storing remainder in binary array
      binaryNum[i] = N % 2;
      N = N / 2;
      i++;
    }

    // printing binary array in reverse order
    for (int j = i - 1; j >= 0; j--) System.out.print(binaryNum[j]);
  }
}
