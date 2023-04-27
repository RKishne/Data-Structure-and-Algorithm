import java.util.*;

public class Main {

  public static long DistinctCharacterSubstring(String s) {
    //write code here
    int ans = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    int i = -1;
    int j = -1;
    while (true) {
      boolean f1 = false;
      boolean f2 = false;

      while (i < s.length() - 1) {
        f1 = true;
        i++;
        char ch = s.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);

        if (map.get(ch) == 2) {
          break;
        } else {
          ans += i - j;
        }
      }
      while (j < i) {
        f2 = true;

        j++;
        char ch = s.charAt(j);
        map.put(ch, map.get(ch) - 1);

        if (map.get(ch) == 1) {
          ans += i - j;
          break;
        }
      }
      if (f1 == false && f2 == false) {
        break;
      }
    }
    return ans;
  }

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    long ans = DistinctCharacterSubstring(s);
    System.out.println(ans);
  }
}
