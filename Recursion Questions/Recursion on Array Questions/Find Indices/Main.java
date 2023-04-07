import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, x;
        n = sc.nextInt();
        x = sc.nextInt();
        int arr1[] = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        findX(arr1, n, x);
    }

    static void findX(int arr[], int n, int x) {
        // write code here
        int output[] = new int[n];
        int size = f(arr, n, x, output);
        for (int i = 0; i < size; i++) {
            System.out.print(output[i] + " ");
        }
    }

    static int f(int input[], int n, int x, int output[]) {

        if (n == 0) {
            return 0;
        }
        int ans = f(input, n - 1, x, output);
        if (input[n - 1] == x) {
            output[ans++] = n - 1;
        }
        return ans;
    }
}
