import java.util.*;
import static java.lang.Math.ceil;

class Accio {
    public int ClimbingStairs(int n) {
        // Write your code here
        return f(n + 1);

    }

    public int f(int n) {
        if (n <= 1) {
            return n;
        }
        return f(n - 1) + f(n - 2);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.ClimbingStairs(n));
    }
}