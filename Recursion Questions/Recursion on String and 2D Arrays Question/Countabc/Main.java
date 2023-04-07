import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        // your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.print(countfun(s));
    }

    public static int countfun(String s) {
        if (s.length() < 3)
            return 0;

        if (s.substring(0, 3).equals("abc") || s.substring(0, 3).equals("aba")) {
            return 1 + countfun(s.substring(1));
        } else {
            return countfun(s.substring(1));
        }
    }
}