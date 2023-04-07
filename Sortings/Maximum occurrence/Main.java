import java.util.*;

public class Main {
    static int maximum_occurrence(int arr[], int n) {
        // Write code here
        Arrays.sort(arr);
        int maxoccurence = 0;
        int elem = 0;
        int start = 0;
        int end = 0;
        while (start < n) {
            while (end < n && arr[start] == arr[end]) {
                end++;
            }
            int blocksize = end - start;
            int element = arr[start];
            if (blocksize > maxoccurence) {
                maxoccurence = blocksize;
                elem = element;
            }
            start = end;
        }
        return elem;
    }

    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(maximum_occurrence(arr, n));

    }
}
