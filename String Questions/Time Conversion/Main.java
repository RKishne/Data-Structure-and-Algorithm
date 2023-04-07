import java.util.*;

public class Main {
    static void timeConversion(String s) {
        // Write your code here
        String ans = "";
        String hr = s.substring(0, 2);
        String same = s.substring(2, 8);
        if (s.charAt(8) == 'A') {
            if (hr.equals("12")) {
                hr = "00";
            }
            ans = hr + same;
        } else {
            int num = Integer.parseInt(hr);
            if (num != 12) {
                num += 12;
            }
            ans = num + same;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        timeConversion(str);
        sc.close();
    }
}