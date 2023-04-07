
// Java program to sum two numbers
// represented two arrays.
import java.util.*;

public class Main {
    static int[] calSum(int a[], int b[], int n, int m) {
        // your code here
        int arraysize = Math.max(n, m) + 1;
        int ans[] = new int[arraysize];
        int i = n - 1;
        int j = m - 1;
        int k = arraysize - 1;
        int carry = 0;
        int sum;
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0) {
                sum += a[i];
                i--;
            }
            if (j >= 0) {
                sum += b[j];
                j--;
            }
            ans[k] = sum % 10;
            carry = sum / 10;
            k--;
        }
        ans[0] = carry;
        if (ans[0] != 0) {
            return ans;
        }
        int ans2[] = new int[arraysize - 1];
        for (int z = 0; z < ans2.length; z++) {
            ans2[z] = ans[z + 1];
        }
        return ans2;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt();
        sc.close();

        int[] res = calSum(arr1, arr2, n1, n2);
        for (int i : res)
            System.out.println(i);
    }
}