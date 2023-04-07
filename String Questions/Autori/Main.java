import java.io.*;
import java.util.*;

public class Main {
    static String autori(String str) {
        // Your code here
        String ans = "";
        int n = str.length();
        ans += str.charAt(0);
        for (int i = 1; i < n; i++) {
            if (str.charAt(i - 1) == '-') {
                ans += str.charAt(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String result = autori(str);
        System.out.print(result);
        System.out.println('\n');
    }
}