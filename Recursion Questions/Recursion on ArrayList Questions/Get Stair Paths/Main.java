import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
    }

    public static ArrayList<String> getStairPaths(int n) {
        // your code here
        if (n == 0) {
            ArrayList<String> a = new ArrayList<>();
            a.add("");
            return a;
        }
        if (n < 0) {
            return new ArrayList<>();
        }
        ArrayList<String> a1 = getStairPaths(n - 1);
        ArrayList<String> a2 = getStairPaths(n - 2);
        ArrayList<String> a3 = getStairPaths(n - 3);
        ArrayList<String> ans = new ArrayList<>();
        for (String s : a1) {
            ans.add("1" + s);
        }
        for (String s : a2) {
            ans.add("2" + s);
        }
        for (String s : a3) {
            ans.add("3" + s);
        }
        return ans;
    }
}
