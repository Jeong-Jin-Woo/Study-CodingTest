import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] map = new int[n + 1][n + 1];
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = in.nextInt();
			}
		}
		dp[1][1] = map[1][1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = map[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int x1 = in.nextInt(); // 2
			int y1 = in.nextInt(); // 2
			int x2 = in.nextInt(); // 3
			int y2 = in.nextInt(); // 4
			sb.append(dp[x1 - 1][y1 - 1] + dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
