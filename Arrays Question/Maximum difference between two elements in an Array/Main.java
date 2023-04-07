import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n;
            n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }
            ArrayProblem(arr);
        }
    }

    public static void ArrayProblem(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if ((Math.abs(arr[i] - arr[j])) > max) {
                    max = Math.abs(arr[i] - arr[j]);
                }
            }
        }
        System.out.println(max);
    }
}