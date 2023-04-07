import java.util.*;


public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int n;
			
			n = sc.nextInt();
			int []arrA=new int[n];
			for(int i=0;i<n;++i){
			        arrA[i]=sc.nextInt();
			}
			
			n = sc.nextInt();
			int []arrB=new int[n];
			for(int i=0;i<n;++i){
			    arrB[i]=sc.nextInt();
			}
			
			System.out.println(ArrayProblem(arrA,arrB));
		} 
    }
    public static String ArrayProblem(int []arrA,int []arrB){
       // Write code here
		int arrAsize=arrA.length;
		int arrBsize=arrB.length;
		int sum1=0;
		int sum2=0;
		for(int i=0;i<arrAsize;i++){
			sum1+=arrA[i];
		}
		for(int i=0;i<arrBsize;i++){
			sum2+=arrB[i];
		}
		if(sum1>sum2){
			return "First array is larger";
		}
		else if(sum2>sum1){
			return "Second array is larger";
		}
		else{
			return "Both are equal";
		}
    }
}
