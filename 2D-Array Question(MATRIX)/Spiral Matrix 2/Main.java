import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int mat[][] = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    mat[i][j] = sc.nextInt();
            }

            ArrayList<Integer> ans = spirallyTraverse(mat, r, c);
            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static ArrayList<Integer> spirallyTraverse(int mat[][], int n, int m) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int k = 0, l = 0;
        while (k < m && l < n) {
            for (int i = l; i < n; i++) {
                ans.add(mat[i][k]);
            }
            k++;
            for (int i = k; i < m; i++) {
                ans.add(mat[n - 1][i]);
            }
            n--;
            if (k < m) {
                for (int i = n - 1; i >= l; i--) {
                    ans.add(mat[i][m - 1]);
                }
                m--;
            }
            if (l <= n) {
                for (int i = m - 1; i >= k; i--) {
                    ans.add(mat[l][i]);
                }
                l++;
            }
        }
        return ans;
    }
}