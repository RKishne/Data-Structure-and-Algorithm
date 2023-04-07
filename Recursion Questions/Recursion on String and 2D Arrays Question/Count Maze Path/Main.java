import java.io.*;
import java.util.*;

public class Main {
    static int countMazePath(int n, int m) {
        // Write your code here
        ArrayList<String> ans = new ArrayList<>();
        f(1, 1, n, m, "", ans);
        return ans.size();
    }

    static void f(int r, int c, int n, int m, String asf, ArrayList<String> ans) {
        if (r == n && c == m) {
            ans.add(asf);
            return;
        }
        if (r > n || c > m) {
            return;
        }
        f(r, c + 1, n, m, asf + "h", ans);
        f(r + 1, c, n, m, asf + "v", ans);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(countMazePath(n, m));
    }
}