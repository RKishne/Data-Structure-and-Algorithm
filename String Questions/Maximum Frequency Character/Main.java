import java.util.*;

public class Main {

    static char MaximumFrequencyChar(String str) {
        // Write your code here
        char tempArray[] = str.toCharArray();
        Arrays.sort(tempArray);
        String s = new String(tempArray);
        int count[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int max = -1;
        char result = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (max < count[s.charAt(i)]) {
                max = count[s.charAt(i)];
                result = s.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(MaximumFrequencyChar(s));
    }
}