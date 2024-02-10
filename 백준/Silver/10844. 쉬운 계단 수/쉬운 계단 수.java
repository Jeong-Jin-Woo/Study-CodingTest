import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int mod = 1_000_000_000;
		int[][] dp = new int[101][11];
		for(int i=1; i<10; i++) {
			dp[1][i] = 1;
		}
		dp[1][10] = 9;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<10; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1];
				}
				else if(j == 9) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
				}
				dp[i][10] += dp[i][j]%mod;
				dp[i][10] %= mod;
			}
		}
		System.out.println(dp[n][10]);
	}
}	
