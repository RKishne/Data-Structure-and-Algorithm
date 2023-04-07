import java.util.*;

public class Main {
    static void oddEvenSort(int a[], int n) {
        // Write your code here
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        oddEvenSort(array, n);
    }
}