
import java.util.*;
import java.io.*;

class Solution {
    static void quickSort(int[] arr) {
        // Write code here
        int n = arr.length;
        qs(arr, 0, n - 1);
    }

    static void qs(int arr[], int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            qs(arr, l, pi - 1);
            qs(arr, pi + 1, r);
        }
    }

    static int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        arr[right] = arr[i];
        arr[i] = pivot;

        return i;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.quickSort(arr);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        sc.close();
    }
}