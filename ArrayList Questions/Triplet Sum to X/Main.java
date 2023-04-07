import java.io.*;
import java.util.*;

public class Main {
    public static int triplets(ArrayList<Integer> arr, int X) {
        // your code here
        Collections.sort(arr);
        int count = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            int target = X - arr.get(i);
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                if (arr.get(start) + arr.get(end) > target) {
                    end--;
                } else if (arr.get(start) + arr.get(end) < target) {
                    start++;
                } else {
                    count++;
                    while (start < n - 1 && arr.get(start) == arr.get(start + 1)) {
                        start++;
                    }
                    start++;
                    while (end > 0 && arr.get(end) == arr.get(end - 1)) {
                        end--;
                    }
                    end--;
                }
            }
            while (i < n - 1 && arr.get(i) == arr.get(i + 1)) {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t > 0) {
            int n, X;
            n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++)
                arr.add(sc.nextInt());
            X = sc.nextInt();
            int result = triplets(arr, X);
            System.out.println(result);
            t--;
        }
        sc.close();
    }

}