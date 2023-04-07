import java.util.*;
import java.io.*;

public class Main {
    public static void isPangram(String s) {
        // Your code here
        String str = s.toLowerCase();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a'] = 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                System.out.print("not pangram");
                return;
            }
        }
        System.out.print("pangram");
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        isPangram(s);

    }
}