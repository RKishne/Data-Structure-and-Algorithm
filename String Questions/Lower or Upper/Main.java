import java.util.*;

public class Main {
    public static char LowerUpper(char ch) {
        // Write your code here
        char ans1 = 'U';
        char ans2 = 'L';
        if (ch >= 'A' && ch <= 'Z') {
            return ans1;
        }
        return ans2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        System.out.println(LowerUpper(ch));
    }
}