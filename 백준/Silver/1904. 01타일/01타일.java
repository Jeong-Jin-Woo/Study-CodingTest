import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] dp = new long[1000001];
		int mod = 15746;
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] % mod) + (dp[i-2] % mod);
		}
		System.out.println(dp[n] % mod);
	}
}
