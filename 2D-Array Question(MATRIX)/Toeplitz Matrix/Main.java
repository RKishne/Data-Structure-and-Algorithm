import java.io.*;
import java.util.*;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix, int m, int n) {
        // write code here
        for (int i = 0; i < n; i++) {
            if (!checkdiagonal(matrix, 0, i)) {
                return false;
            }
        }
        for (int i = 1; i < m; i++) {
            if (!checkdiagonal(matrix, i, 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkdiagonal(int[][] mat, int i, int j) {
        int res = mat[i][j];
        int n = mat.length;
        int m = mat[0].length;
        while (++i < n && ++j < m) {
            if (mat[i][j] != res) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        Solution Obj = new Solution();
        boolean ans = Obj.isToeplitzMatrix(A, m, n);
        System.out.println(ans);
    }
}