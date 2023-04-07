import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(countEncodings(str));
    }

    public static int countEncodings(String str) {
        // your code here
        ArrayList<String> ans = new ArrayList<>();
        f(str, "", ans);
        return ans.size();
    }

    public static void f(String ques, String asf, ArrayList<String> arr) {
        if (ques.length() == 0) {
            arr.add(asf);
            return;
        }
        if (ques.charAt(0) == '0') {
            return;
        }
        char c = ques.charAt(0);
        int integere = c - '0';
        char mapping = (char) ('a' + (integere - 1));
        f(ques.substring(1), asf + mapping, arr);
        if (ques.length() >= 2) {
            int equiv = Integer.parseInt(ques.substring(0, 2));
            if (equiv <= 26) {
                char mapp = (char) ('a' + (equiv - 1));
                f(ques.substring(2), asf + mapp, arr);
            }
        }
    }
}