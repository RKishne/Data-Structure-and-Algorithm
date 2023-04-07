import java.util.*;

public class Main {
    static int count = 0;

    static int countAllPath(int n, int m) {
        // Write your code here
        int visited[][] = new int[n][m];
        f(0, 0, n - 1, m - 1, visited);
        return count;
    }

    static void f(int cr, int cc, int dr, int dc, int visited[][]) {
        if (cr == dr && cc == dc) {
            count++;
            return;
        }
        if (cr < 0 || cc < 0 || cr > dr || cc > dc || visited[cr][cc] == 1) {
            return;
        }
        visited[cr][cc] = 1;
        f(cr, cc + 1, dr, dc, visited);
        f(cr + 1, cc, dr, dc, visited);
        f(cr, cc - 1, dr, dc, visited);
        f(cr - 1, cc, dr, dc, visited);
        f(cr + 1, cc + 1, dr, dc, visited);
        f(cr + 1, cc - 1, dr, dc, visited);
        f(cr - 1, cc - 1, dr, dc, visited);
        f(cr - 1, cc + 1, dr, dc, visited);
        visited[cr][cc] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(countAllPath(n, m));
    }
}