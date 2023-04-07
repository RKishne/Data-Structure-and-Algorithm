import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        sc.close();
        diagonalTraversal(mat);

    }

    public static void diagonalTraversal(int[][] mat) {
        // your code here
        int z = mat.length;
        int g = z - 1;
        while (g >= 0) {
            for (int i = 0, j = g; j < z; i++, j++) {
                System.out.print(mat[i][j] + " ");
            }
            g--;
        }
        g = 1;
        while (g < z) {
            for (int i = g, j = 0; i < z; i++, j++) {
                System.out.print(mat[i][j] + " ");
            }
            g++;
        }
    }
}