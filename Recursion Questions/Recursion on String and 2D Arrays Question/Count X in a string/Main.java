import java.util.Scanner;

public class Main {
    static int countX(String str, int i, int n) {
        // Write your code here
        int count = 0;
        for (i = 0; i < n; i++) {
            if (str.charAt(i) == 'x') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        System.out.println(countX(str, 0, n));
    }
}
