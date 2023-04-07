import java.util.*;

public class Main {
	public static void printEncodings(String str) {
		// Write your code here
		ArrayList<String> arr = new ArrayList<>();
		f(str, "", arr);
		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	public static void f(String ques, String asf, ArrayList arr) {
		if (ques.length() == 0) {
			arr.add(asf);
			return;
		}
		if (ques.charAt(0) == '0') {
			return;
		}
		char c = ques.charAt(0);
		int integere = c - '0';
		char mapping = (char) ('a' + (integere - 1));
		f(ques.substring(1), asf + mapping, arr);
		if (ques.length() >= 2) {
			int equiv = Integer.parseInt(ques.substring(0, 2));
			if (equiv <= 26) {
				char mapp = (char) ('a' + (equiv - 1));
				f(ques.substring(2), asf + mapp, arr);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		printEncodings(str);
	}
}