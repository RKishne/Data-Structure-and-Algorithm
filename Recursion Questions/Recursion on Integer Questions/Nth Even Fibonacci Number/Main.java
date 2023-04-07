import java.util.*;
import static java.lang.Math.ceil;

public class Main {
    static long NthEvenFibonacci(long n) {
        // Write your code here
        long m = 1000000007;
        if (n < 1) {
            return n;
        } else if (n == 1) {
            return 2;
        } else {
            long ans = ((4 * NthEvenFibonacci(n - 1)) +
                    NthEvenFibonacci(n - 2));
            return ans % m;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(NthEvenFibonacci(n));
    }
}