import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<String> getStrings(ArrayList<String> arr) {
        ArrayList<String> ans = new ArrayList<>();
        int n = arr.size();
        String frow = "qwertyuiop";
        String srow = "asdfghjkl";
        String trow = "zxcvbnm";
        for (int i = 0; i < n; i++) {
            String elem = arr.get(i);
            if (frow.indexOf(elem.charAt(0)) != -1) {
                if (inRow(frow, elem)) {
                    ans.add(elem);
                }
            }
            if (srow.indexOf(elem.charAt(0)) != -1) {
                if (inRow(srow, elem)) {
                    ans.add(elem);
                }
            }
            if (trow.indexOf(elem.charAt(0)) != -1) {
                if (inRow(trow, elem)) {
                    ans.add(elem);
                }
            }
        }
        return ans;
    }

    static boolean inRow(String row, String el) {
        for (int i = 0; i < el.length(); i++) {
            if (row.indexOf(el.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            arr.add(s);
        }

        ArrayList<String> result = getStrings(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
