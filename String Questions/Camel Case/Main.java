import java.util.*;

class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            String ans = camelCase(s);
            System.out.println(ans);
        }
    }

    static String camelCase(String s) {
        // your code here
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '_') {
                continue;
            }
            if (i > 0 && s.charAt(i - 1) == '_') {
                char ch = (char) (s.charAt(i) - 32);
                ans.append(ch);
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}