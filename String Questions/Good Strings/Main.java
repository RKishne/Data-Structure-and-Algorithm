import java.util.*;

public class Main {

    static int goodStrings(String s, String[] A, int n) {
        // your code here
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isGood(A[i], s)) {
                count++;
            }
        }
        return count;
    }

    static boolean isGood(String s1, String s) {
        for (int i = 0; i < s1.length(); i++) {
            if (ispre(s1.charAt(i), s)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean ispre(char ch, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = sc.nextInt();
            String[] A = new String[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.next();
            }

            System.out.println(goodStrings(s, A, n));
        }
    }
}