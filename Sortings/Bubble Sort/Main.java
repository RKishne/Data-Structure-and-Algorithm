import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[N];

        // Input of array
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // bubble sort in descending order
        bubbleSort(N, arr);
        // printing array elements
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void bubbleSort(int n, int[] arr) {
        // your code here
        for (int i = 0; i < n - 1; i++) {
            int flag = 0;
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] < arr[j + 1]) {
                    flag = 1;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        return;
    }
}