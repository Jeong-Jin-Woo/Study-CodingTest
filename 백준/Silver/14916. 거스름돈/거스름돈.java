import java.util.*;

public class Main {
	static int[] dp = new int[100001];
	static final int INF = (int)1e9;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Arrays.fill(dp, INF);
		dp[2] = 1;
		dp[4] = 2;
		dp[5] = 1;
		for(int i=6; i<=n; i++) {
			if(dp[i-2] != INF || dp[i-5] != INF)
				dp[i] = Math.min(dp[i-2] + 1, dp[i-5] + 1);
		}
		System.out.println(dp[n] == INF ? -1 : dp[n]);
//		for(int i=1; i<=n; i++) {
//			System.out.println(i + " : " + dp[i]);
//		}
	}
}
