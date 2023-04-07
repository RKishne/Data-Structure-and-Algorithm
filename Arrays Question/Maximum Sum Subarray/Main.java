
// Java program to print largest contiguous array sum
import java.util.*;

public class Main {

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println(maxSubArraySum(arr));
    }

    // Function Call
    static int maxSubArraySum(int a[]) {
        // your code here
        int n = a.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}