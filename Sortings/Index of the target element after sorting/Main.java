import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        // your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                ans = i;
            }
        }
        System.out.print(ans);
    }
}