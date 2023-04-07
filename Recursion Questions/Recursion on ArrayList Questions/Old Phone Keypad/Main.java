import java.util.*;

class Main {
    static ArrayList<String> OldPhone(int n, int[] keys) {
        // Write your code here
        String ref[] = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TU", "VWX", "YZ" };
        ArrayList<String> ans = f(keys, 0, ref);
        return ans;
    }

    static ArrayList<String> f(int key[], int n, String ref[]) {
        if (n == key.length) {
            ArrayList<String> a = new ArrayList<>();
            a.add("");
            return a;
        }
        ArrayList<String> res = f(key, n + 1, ref);
        String s = ref[key[n]];
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < res.size(); j++) {
                ans.add(s.charAt(i) + res.get(j));
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        for (int i = 0; i < n; ++i) {
            keys[i] = sc.nextInt();
        }
        ArrayList<String> ans = OldPhone(n, keys);
        for (String i : ans)
            System.out.print(i + " ");
    }
}