import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int mod = 10_007;
		int n = in.nextInt();
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1]%mod) + (dp[i-2] * 2) % mod;
		}
		System.out.println(dp[n]%mod);
	}
}
