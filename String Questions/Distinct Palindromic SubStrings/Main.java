import java.util.*;

public class Main {
    static void palindromeSubStrs(String s) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String ss = s.substring(i, j);
                if (ispalindrome(ss)) {
                    if (!present(ss, res)) {
                        res.add(ss);
                    }
                }
            }
        }
        Collections.sort(res);
        for (String b : res) {
            System.out.println(b);
        }
    }

    public static boolean present(String s, ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ispalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        palindromeSubStrs(s);
    }
}