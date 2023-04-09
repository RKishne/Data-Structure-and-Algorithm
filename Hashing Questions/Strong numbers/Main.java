import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

  public static boolean strongNumbers(long n) {
    //your code here

    long i = 2;
    for (i = 2; i <= n; i++) {
      if (n % i == 0 && isprime(i)) {
        long ans = i;
        if ((n % (ans * ans)) == 0) {
          continue;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean isprime(long a) {
    for (long i = 2; i < a; i++) {
      if (a % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine().trim());
    if (strongNumbers(n)) System.out.println(1); else System.out.println(0);
  }
}
