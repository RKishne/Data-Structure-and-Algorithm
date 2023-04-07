import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> paths = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(paths);
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // your code here
        if (sr == dr && sc == dc) {
            ArrayList<String> a = new ArrayList<>();
            a.add("");
            return a;
        }
        if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }
        ArrayList<String> hh = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> vv = getMazePaths(sr + 1, sc, dr, dc);
        ArrayList<String> ans = new ArrayList<>();
        for (String s : hh) {
            ans.add("h" + s);
        }
        for (String s : vv) {
            ans.add("v" + s);
        }
        return ans;
    }
}
