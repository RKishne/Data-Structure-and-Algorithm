import java.io.*;
import java.util.*;

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

        spirallyTraverse(mat);
        System.out.println('\n');
    }

    public static void spirallyTraverse(int[][] mat) {
        // your code here
        int n = mat.length;
        int m = mat[0].length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        int dir = 0;
        while (bottom >= top && right >= left) {
            if (dir == 0) {
                for (int j = left; j <= right; j++) {
                    System.out.print(mat[top][j] + " ");
                }
                top++;
                dir = 1;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    System.out.print(mat[i][right] + " ");
                }
                right--;
                dir = 2;
            } else if (dir == 2) {
                for (int j = right; j >= left; j--) {
                    System.out.print(mat[bottom][j] + " ");
                }
                bottom--;
                dir = 3;
            } else {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(mat[i][left] + " ");
                }
                left++;
                dir = 0;
            }
        }
    }
}