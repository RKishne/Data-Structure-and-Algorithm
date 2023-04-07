import java.io.*;
import java.util.*;

public class Main {

    static String hey(String str) {
        // Your code here
        StringBuilder ans = new StringBuilder();
        int n = str.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'e') {
                count++;
            }
        }
        count *= 2;
        ans.append(str.charAt(0));
        while (count-- > 0) {
            ans.append('e');
        }
        ans.append(str.charAt(n - 1));
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String result = hey(str);
        System.out.print(result);
        System.out.println('\n');
    }
}