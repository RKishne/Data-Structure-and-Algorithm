import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                mat[i][j] = sc.nextInt();
            }
        }
        alternateMatrixSum(mat, n);
        System.out.println('\n');
    }

    public static void alternateMatrixSum(int[][] mat, int n) {
        // your code here
        int blacksum = 0;
        int whitesum = 0;
        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j = j + 2) {
                        blacksum += mat[i][j];
                    }
                    for (int k = 1; k < n; k = k + 2) {
                        whitesum += mat[i][k];
                    }
                } else {
                    for (int j = n - 1; j >= 0; j = j - 2) {
                        blacksum += mat[i][j];
                    }
                    for (int k = n - 2; k >= 0; k = k - 2) {
                        whitesum += mat[i][k];
                    }
                }
            }
            System.out.println(blacksum);
            System.out.println(whitesum);
        } else {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j = j + 2) {
                        blacksum += mat[i][j];
                    }
                    for (int k = 1; k < n; k = k + 2) {
                        whitesum += mat[i][k];
                    }
                } else {
                    for (int j = n - 1; j >= 0; j = j - 2) {
                        whitesum += mat[i][j];
                    }
                    for (int k = n - 2; k >= 0; k = k - 2) {
                        blacksum += mat[i][k];
                    }
                }
            }
            System.out.println(blacksum);
            System.out.println(whitesum);
        }
    }
}
