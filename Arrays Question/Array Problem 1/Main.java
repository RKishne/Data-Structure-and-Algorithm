import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;++i){
                arr[i] = sc.nextInt();
            }
            int ans=ArrayProblem1(n,arr);
            System.out.println(ans);
        }
    }

    public static int ArrayProblem1(int n, int[] arr){
        // Write code here
		int max=arr[0];
		int max1=0;
		for(int i=0;i<n;i++){
			if(arr[i]>max){
				max=arr[i];
				max1=i;
			}
		}
		return max1;
    }
}