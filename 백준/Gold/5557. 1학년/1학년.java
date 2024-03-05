import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		long dp[][] = new long[n][21];
		for(int i=0; i<n-1; i++) {
			arr[i] = in.nextInt();
		}
		int ans = in.nextInt();
		dp[0][arr[0]] = 1;
		for(int i=1; i<n-1; i++) {
			for(int j=0; j<21; j++) {
				if(dp[i-1][j] > 0) {
					if(j + arr[i] <= 20) {
						dp[i][j + arr[i]] += dp[i-1][j];
					}
					if(j - arr[i] >= 0) {
						dp[i][j - arr[i]] += dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[n-2][ans]);
	}
}
