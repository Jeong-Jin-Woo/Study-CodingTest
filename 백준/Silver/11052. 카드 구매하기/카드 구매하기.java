import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = in.nextInt();
			dp[i] = Math.max(arr[i], dp[i]);
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], arr[j]+dp[i-j]);
			}
		}
//		for(int i=1; i<=n ;i++) {
//			System.out.println(i + " " + dp[i]);
//		}
		System.out.println(dp[n]);
	}
}
