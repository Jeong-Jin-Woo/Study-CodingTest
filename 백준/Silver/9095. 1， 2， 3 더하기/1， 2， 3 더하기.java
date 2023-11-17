import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		int[] dp = new int[12];
		while (c-- != 0) {
			int n = in.nextInt();
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
			System.out.println(dp[n]);
		}
	}
}
