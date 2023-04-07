import java.util.*;
import java.io.*;

public class Main {
    static String compressedString(String s) {
        // Write your code here
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int start = 0;
        int end = 0;
        while (start < n) {
            while (end < n && s.charAt(end) == s.charAt(start)) {
                end++;
            }
            int blocksize = end - start;
            char blockchar = s.charAt(start);
            ans.append(blockchar);
            if (blocksize > 1) {
                ans.append(blocksize);
            }
            start = end;
        }
        return ans.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            System.out.println(compressedString(s));
        }
    }
}