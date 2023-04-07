
// Java program to sum two numbers
// represented two arrays.
import java.util.*;

public class Main {

    static int[] subtract(int[] n1, int[] n2) {
        // your code here
        int n = n1.length;
        int m = n2.length;
        int nsize = Math.max(n, m);
        int ans[] = new int[nsize];
        int i = n - 1;
        int j = m - 1;
        int k = nsize - 1;
        int borrow = 0;
        while (i >= 0 || j >= 0) {
            int diff = borrow;
            if (i >= 0) {
                diff = diff + n1[i];
            }
            if (j >= 0) {
                diff = diff - n2[j];
            }
            if (diff < 0) {
                diff = diff + 10;
                borrow = -1;
            } else {
                borrow = 0;
            }
            ans[k] = diff;
            i--;
            j--;
            k--;
        }
        if (borrow == -1) {
            int newans[] = subtract(n2, n1);
            newans[0] *= -1;
            return newans;
        }
        return ans;
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

        int[] res = subtract(arr1, arr2);
        for (int i : res)
            System.out.println(i);
    }
}