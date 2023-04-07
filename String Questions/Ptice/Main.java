import java.util.*;

public class Main {

    static void ptice(int n, String key) {
        // Write your code here and print output in this function
        int a = 0;
        int b = 0;
        int g = 0;
        String adrian = "ABC";
        String bruno = "BABC";
        String goran = "CCAABB";
        for (int i = 0; i < n; i++) {
            char correctoption = key.charAt(i);
            char aoption = adrian.charAt(i % adrian.length());
            char boption = bruno.charAt(i % bruno.length());
            char goption = goran.charAt(i % goran.length());
            if (aoption == correctoption) {
                a++;
            }
            if (boption == correctoption) {
                b++;
            }
            if (goption == correctoption) {
                g++;
            }
        }
        int ans = Math.max(a, Math.max(b, g));
        System.out.println(ans);
        if (a == ans) {
            System.out.println("Adrian");
        }
        if (b == ans) {
            System.out.println("Bruno");
        }
        if (g == ans) {
            System.out.println("Goran");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String str = sc.next();
        ptice(n, str);
        sc.close();
    }
}