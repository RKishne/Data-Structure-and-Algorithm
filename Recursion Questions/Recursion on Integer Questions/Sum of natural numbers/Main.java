import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long sum = 1;
        for (int i = 2; i <= N; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
}