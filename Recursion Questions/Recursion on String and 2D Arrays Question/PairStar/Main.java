import java.util.*;

public class Main {
    static String PairStar(String str) {
        // Write your code here
        return f(str, "", 0);
    }

    static String f(String str, String ans, int index) {
        ans = ans + str.charAt(index);
        if ((str.length() - 1) == index) {
            return ans;
        }
        if (str.charAt(index) == str.charAt(index + 1)) {
            ans = ans + "*";
        }
        return f(str, ans, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(PairStar(s));
    }
}