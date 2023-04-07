import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = maxElement(nums);
        System.out.print(result);
    }

    public static int maxElement(int[] arr) {
        // Write your code here
        int n = arr.length;
        return func(arr, n);
    }

    public static int func(int arr[], int n) {
        if (n == 1) {
            return arr[n - 1];
        }
        int max = func(arr, n - 1);
        return Math.max(max, arr[n - 1]);
    }
}