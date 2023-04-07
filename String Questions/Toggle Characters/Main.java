import java.util.*;

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        toggleCase(n, str);
    }

    static void toggleCase(int n, String str) {
        // your code here
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            ans.append(ch);
        }
        System.out.println(ans);
    }
}