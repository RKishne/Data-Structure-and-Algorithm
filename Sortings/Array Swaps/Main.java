import java.io.*;
import java.util.*;

public class Main {
    static String arraySwaps(int arr[], int n, int x) {
        // Your code here
        String ans = "";
        if (x <= n / 2) {
            ans += "YES";
        } else {
            ans += "NO";
        }
        return ans;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        String ans = arraySwaps(a, n, x);
        System.out.println(ans);
    }
}