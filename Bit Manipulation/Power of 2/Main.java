import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    System.out.println(isPowerOfTwo(n));
  }

  public static boolean isPowerOfTwo(int n) {
    // your code here
    int power = 1;
    for (int i = 1; i <= n; i++) {
      if (n == 1) {
        power = 1;
      }
      if (n > 1) {
        power *= 2;
      }

      if (n == power || power == 1) {
        return true;
      }
    }
    return false;
  }
}
