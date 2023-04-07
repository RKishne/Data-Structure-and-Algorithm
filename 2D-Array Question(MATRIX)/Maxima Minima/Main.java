import java.util.*;

public class Main {
    public static int maximaMinima(int[][] mat) {
        // Write code here
        int flag = 0;
        int n = mat.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < n; i++) {
            flag = 0;
            min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] < min) {
                    min = mat[i][j];
                }
            }
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == min) {
                    k = j;
                }
            }
            for (int a = 0; a < n; a++) {
                if (mat[a][k] > min) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return min;
            }
        }
        if (flag == 1) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        int result = maximaMinima(matrix);
        System.out.println(result);
        sc.close();
    }
}