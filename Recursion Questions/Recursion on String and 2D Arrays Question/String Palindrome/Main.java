import java.io.*;
import java.util.Scanner;

public class Main {

    static boolean isPalindrome(String str) {
        // Write your code here
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean result = isPalindrome(str);
        if (result)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}