import java.util.*;
import java.util.Scanner;

public class Main {
    static void printSubsequence(String s) {
        // Write your code here
        f(s, "");
    }

    static void f(String ques, String asf) {
        if (ques.length() == 0) {
            System.out.print(asf + " ");
            return;
        }
        char c = ques.charAt(0);
        String roq = ques.substring(1);
        f(roq, asf + c);
        f(roq, asf);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printSubsequence(s);
    }
}