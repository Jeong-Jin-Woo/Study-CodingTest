import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int answer = 0;
		int arr[] = new int[n];
		int dp[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			dp[i] = arr[i];
		}
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(arr[i] < arr[j]) {
					dp[j] = Math.max(dp[j], arr[j] + dp[i]);
				}
			}
		}
		for(int i=0; i<n; i++) {
			answer = Math.max(answer, dp[i]);
//			System.out.print(dp[i] + " ");
		}
		System.out.println(answer);
	}
}
