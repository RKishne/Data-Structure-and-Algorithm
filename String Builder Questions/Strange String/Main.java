import java.io.*;
import java.util.*;

public class Main {
    static String strangeString(int n) {
        // Write your code here
        StringBuilder ans = new StringBuilder();
        char c = 'a';
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ans.insert(0, c);
            } else {
                ans.append(c);
            }
            c++;
            if (c > 'z') {
                c = 'a';
            }
        }
        String sb = ans.toString();
        return sb;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            System.out.println(strangeString(n));
        }
    }
}