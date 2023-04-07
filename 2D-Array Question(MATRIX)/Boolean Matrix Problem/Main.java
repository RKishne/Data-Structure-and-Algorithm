import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int nums[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int[][] ans = BooleanMatrixProblem(m, n, nums);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] BooleanMatrixProblem(int m, int n, int[][] mat) {
        // your code here
        for (int i = 0; i < m; i++) {
            boolean a = false;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    a = true;
                }
            }
            if (a == true) {
                for (int k = i; k <= i; k++) {
                    for (int l = 0; l < n; l++) {
                        mat[k][l] = 1;
                    }
                }
            } else {
                continue;
            }
        }
        return mat;
    }
}