import java.util.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i == max) {
                    continue;
                }
                if (2 * arr[i] > arr[max]) {
                    max = -1;
                    break;
                }
            }
            System.out.println(max);
        }
    }
}