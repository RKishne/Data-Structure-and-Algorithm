import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static String reverseWords(String s) {
        // your code here
        String[] ans = s.split(" ");
        String reverse = "";
        int n = ans.length;
        for (int i = n - 1; i >= 0; i--) {
            reverse += ans[i];
            reverse += " ";
        }
        return reverse;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String p = sc.nextLine();
        while (t > 0) {
            String s = sc.nextLine();
            System.out.println(reverseWords(s));
            t--;
        }
    }
}