import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }
            int ans = ArrayProblem6(n, arr);
            System.out.println(ans);
        }
    }

    public static int ArrayProblem6(int n, int[] arr) {
        // Write code here
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                if (arr[i] % 2 == 0) {
                    count++;
                }
            }
        }
        if (count <= 1) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] % 2 == 0) && (arr[j] % 2 == 0)) {
                    int sub = Math.abs(i - j);
                    if (sub < min) {
                        min = sub;
                    }
                }
            }
        }
        return min;
    }
}