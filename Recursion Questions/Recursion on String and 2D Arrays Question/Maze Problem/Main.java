import java.io.*;
import java.util.*;

public class Main {
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        // Write your code here
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        /*
         * if(sr>dr || sc>dc){
         * return;
         * }
         */
        // horizontal jumps
        // max jumps(dc-sc)
        for (int i = 1; i <= dc - sc; i++) {
            printMazePaths(sr, sc + i, dr, dc, psf + "h" + i);
        }
        // vertical jumps
        // max jumps(dr-sr)
        for (int i = 1; i <= dr - sr; i++) {
            printMazePaths(sr + i, sc, dr, dc, psf + "v" + i);
        }
        // diagonal jumps
        // min(dr-sr,dc-sc);
        for (int i = 1; i <= Math.min(dr - sr, dc - sc); i++) {
            printMazePaths(sr + i, sc + i, dr, dc, psf + "d" + i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        printMazePaths(0, 0, n - 1, m - 1, "");
    }
}