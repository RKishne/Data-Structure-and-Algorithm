import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        sc.close();
        barGraph(arr, n, max);
    }

    /**
     * @param arr
     * @param n
     * @param max
     */
    public static void barGraph(int[] arr, int n, int max) {
        // your code here
        int rows = max;
        int currentheight = max;
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] >= currentheight) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
            currentheight--;
        }
    }
}
