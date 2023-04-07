import java.util.*;

public class Main {

    public static void findGeometricTriplets(int arr[], int n) {
        // Write code here
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((arr[j] * arr[j]) == (arr[i] * arr[k])) {
                        System.out.print(arr[i] + " " + arr[j] + " " + arr[k]);
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        findGeometricTriplets(arr, N);
        sc.close();
    }
}