import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		int max = 0;
		for(int i=1; i<=n; i++) {
			arr[i] = in.nextInt();
			max = Math.max(max, arr[i]);
		}
		for(int i=1; i<=n; i++) {
			for(int j=i; j <= n; j++) {
				if(arr[i] > arr[j]) {
					dp[j] = Math.max(dp[i]+1, dp[j]);
				}
			}
		}
		int answer = 0;
		for(int i=1; i<=n; i++) {
			answer = Math.max(answer, dp[i]);
//			System.out.println(dp[i]);
		}
		System.out.println(answer+1);
	}
}
