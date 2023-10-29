import java.util.*;

public class Main {
	static int dp[][];
	static int W[];
	static int K[];

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		W = new int[n + 1];
		K = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			W[i] = in.nextInt();
			K[i] = in.nextInt();
		}
		dp = new int[n + 1][k + 1];
		for (int j = 1; j <= k; j++) {
			for (int i = 1; i <= n; i++) {
				if (j < W[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + K[i]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
