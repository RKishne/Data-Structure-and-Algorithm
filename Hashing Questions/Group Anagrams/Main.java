// A Java program to print all anagrams together
import java.util.*;

public class Main {

  // Given a list of words in wordArr[],
  public static void printAnagramsTogether(String wordArr[], int size) {
    //your code here

    HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();

    for (String str : wordArr) {
      HashMap<Character, Integer> fmap = new HashMap<>();
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
      }
      if (bmap.containsKey(fmap) == false) {
        ArrayList<String> list = new ArrayList<>();
        list.add(str);
        bmap.put(fmap, list);
      } else {
        ArrayList<String> list = bmap.get(fmap);
        list.add(str);
      }
    }

    for (ArrayList<String> str : bmap.values()) {
      for (int i = 0; i < str.size(); i++) {
        System.out.print(str.get(i) + " ");
      }
    }
  }

  // Driver program to test above functions
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] wordArr = new String[n];
    for (int i = 0; i < n; i++) wordArr[i] = sc.next();
    sc.close();
    printAnagramsTogether(wordArr, n);
  }
}
