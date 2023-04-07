import java.util.*;

class Solution{
    public void balancedBrackets(String s, int n) {
        // write code here
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<n;i++){
			char ch=s.charAt(i);
			if(ch=='(' || ch=='{' || ch=='['){
				stack.push(ch);
				continue;
			}
			if(stack.isEmpty()){
				System.out.println("NO");
				return;
			}
			char check;
			if(ch==')'){
				check=stack.pop();
				if(check=='{' || check=='['){
					System.out.println("NO");
					return;
				}
			}
			else if(ch=='}'){
				check=stack.pop();
				if(check=='(' || check=='['){
					System.out.println("NO");
					return;
				}
			}
			else if(ch==']'){
				check=stack.pop();
				if(check=='{' || check=='('){
					System.out.println("NO");
					return;
				}
			}
		}
		if(stack.isEmpty()){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Solution Obj = new Solution();
        Obj.balancedBrackets(s, n);
    }
}