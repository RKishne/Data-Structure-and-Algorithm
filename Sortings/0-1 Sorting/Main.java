import java.util.*;

public class Main {
    static int[] Sorting01(int n, int[] arr) {
        // Your code here
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (arr[start] == 0) {
                start++;
            } else if (arr[end] == 1) {
                end--;
            } else {
                arr[start] = 0;
                arr[end] = 1;
                start++;
                end--;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int[] ans = Sorting01(n, arr);
        for (int i = 0; i < n; ++i) {
            System.out.print(ans[i] + " ");
        }
    }
}