import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int N = scn.nextInt();
    int K = scn.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = scn.nextInt();
    }
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if ((arr[i] + arr[j]) % K == 0) {
          count = count + 1;
        }
      }
    }
    System.out.println(count);
  }
}
