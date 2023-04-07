import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<String> generateSubsequences(String str) {
        // write your code here
        ArrayList<String> ans = f(str);
        ans.remove("");
        Collections.sort(ans);
        return ans;
    }

    public static ArrayList<String> f(String s) {
        if (s.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        ArrayList<String> roq = f(s.substring(1));
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < roq.size(); i++) {
            ans.add(s.charAt(0) + roq.get(i));
        }
        for (int i = 0; i < roq.size(); i++) {
            ans.add(roq.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.nextLine();
        ArrayList<String> res = generateSubsequences(s);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}