import java.util.*;

class Accio {

  public int longestOnes(int[] arr, int k) {
    //Your code goes here
    int cnt = 0;
    int l = 0;
    int max_Len = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        cnt++;
      }
      while (cnt > k) {
        if (arr[l] == 0) {
          cnt--;
        }
        l++;
      }
      max_Len = Math.max(max_Len, i - l + 1);
    }
    return max_Len;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) A[i] = sc.nextInt();
    int B = sc.nextInt();
    Accio Obj = new Accio();
    System.out.println(Obj.longestOnes(A, B));
  }
}
