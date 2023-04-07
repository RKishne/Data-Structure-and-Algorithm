import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<String> allPossiblePaths(int n, int m) {
        // write code here
        ArrayList<String> ans = f(1, 1, n, m);
        return ans;
    }

    public static ArrayList<String> f(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> a = new ArrayList<>();
            a.add("");
            return a;
        }
        ArrayList<String> dd1 = new ArrayList<>();
        ArrayList<String> dd2 = new ArrayList<>();
        ArrayList<String> hh1 = new ArrayList<>();
        ArrayList<String> hh2 = new ArrayList<>();
        ArrayList<String> vv1 = new ArrayList<>();
        ArrayList<String> vv2 = new ArrayList<>();
        if (sr < dr && sc < dc) {
            dd1 = f(sr + 1, sc + 1, dr, dc);
            dd2 = f(sr + 2, sc + 2, dr, dc);
        }
        if (sc < dc) {
            hh1 = f(sr, sc + 1, dr, dc);
            hh2 = f(sr, sc + 2, dr, dc);
        }
        if (sr < dr) {
            vv1 = f(sr + 1, sc, dr, dc);
            vv2 = f(sr + 2, sc, dr, dc);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (String s : dd1) {
            ans.add("d1" + s);
        }
        for (String s : dd2) {
            ans.add("d2" + s);
        }
        for (String s : hh1) {
            ans.add("h1" + s);
        }
        for (String s : hh2) {
            ans.add("h2" + s);
        }
        for (String s : vv1) {
            ans.add("v1" + s);
        }
        for (String s : vv2) {
            ans.add("v2" + s);
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> result = allPossiblePaths(n, m);
        Collections.sort(result);
        for (String str : result) {
            System.out.println(str);
        }

    }
}
