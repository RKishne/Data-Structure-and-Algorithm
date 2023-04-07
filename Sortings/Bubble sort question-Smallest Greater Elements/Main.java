import java.util.*;

public class Main {
    public static int[] SmallestGreaterElements(int[] arr) {
        // Write your code here
        int n = arr.length;
        int copyarr[] = new int[n];
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            copyarr[i] = arr[i];
        }
        Arrays.sort(copyarr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i] == copyarr[j]) {
                    ans[i] = copyarr[j + 1];
                }
                if (arr[i] == copyarr[n - 1]) {
                    ans[i] = -10000000;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] ans = SmallestGreaterElements(arr);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}