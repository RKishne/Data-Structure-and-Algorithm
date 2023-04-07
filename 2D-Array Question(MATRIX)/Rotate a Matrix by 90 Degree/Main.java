import java.io.*;
import java.util.*;

class Solution {
    public void rotateBy90(int[][] mat) {
        // Your code here
        int rows = mat.length;
        int cols = mat[0].length;
        transpose(mat);
        for (int i = 0; i < rows; i++) {
            int start = 0;
            int end = cols - 1;
            while (start < end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void transpose(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                mat[i][j] = sc.nextInt();
            }
        }
        Solution Obj = new Solution();
        Obj.rotateBy90(mat);
        System.out.println('\n');
    }
}