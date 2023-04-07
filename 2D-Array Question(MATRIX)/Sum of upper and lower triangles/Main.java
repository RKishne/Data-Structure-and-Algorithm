import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        triangleSums(n, matrix);
        sc.close();
    }

    public static void triangleSums(int n, int[][] matrix) {
        // your code here
        int uppersum = 0;
        int lowersum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i) {
                    uppersum += matrix[i][j];
                }
                if (j <= i) {
                    lowersum += matrix[i][j];
                }
            }
        }
        System.out.print(uppersum + " " + lowersum);
    }
}