import java.io.*;
import java.util.*;

public class Main {
    static int isPalindrome(String str) {
        // write code here
        String s = str.toLowerCase();
        int n = s.length();
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (s.charAt(start) < 'a' || s.charAt(start) > 'z') {
                start++;
            } else if (s.charAt(end) < 'a' || s.charAt(end) > 'z') {
                end--;
            } else {
                if (s.charAt(start) != s.charAt(end)) {
                    return 0;
                }
                start++;
                end--;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = isPalindrome(str);
        System.out.println(result);
    }
}