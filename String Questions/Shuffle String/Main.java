import java.util.*;

public class Main {

    static void shuffleString(int[] indices, String s) {
        // Write your code here and print output in this function
        StringBuilder res = new StringBuilder(s);
        for (int i = 0; i < indices.length; ++i) {
            res.setCharAt(indices[i], s.charAt(i));
        }
        System.out.print(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String str = sc.next();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        shuffleString(arr, str);
        sc.close();
    }
}