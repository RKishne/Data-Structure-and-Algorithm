import java.io.*;
import java.util.*;

class Main {

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M[][] = new int[N][N];
    for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) M[i][j] =
      sc.nextInt();
    System.out.println(new Solution().findCelebrity(M, N));
  }
}

class Solution {

  int findCelebrity(int M[][], int n) {
    Stack<Integer> PC = new Stack<>();
    for (int i = 0; i < n; i++) {
      PC.push(i);
    }
    while (PC.size() > 1) {
      int p1 = PC.pop();
      int p2 = PC.pop();
      if (M[p1][p2] == 1) {
        PC.push(p2);
      } else {
        PC.push(p1);
      }
    }
    int pCeleb = PC.pop();
    for (int c = 0; c < n; c++) {
      if (M[pCeleb][c] == 1) {
        return -1;
      }
    }
    for (int r = 0; r < n; r++) {
      if (pCeleb != r) {
        if (M[r][pCeleb] == 0) {
          return -1;
        }
      }
    }
    return pCeleb;
  }
}
