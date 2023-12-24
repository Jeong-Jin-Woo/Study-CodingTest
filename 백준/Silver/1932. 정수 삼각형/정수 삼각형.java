import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] map = new int[n][n];
		int[][] dp = new int[n][n];
		for(int i=0;i<n; i++) {
			for(int j=0; j<=i; j++) {
				map[i][j] = in.nextInt();
			}
		}
		dp[0][0] = map[0][0];
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j != 0) {
					dp[i][j] = Math.max(map[i][j] + dp[i-1][j-1], map[i][j] + dp[i-1][j]);
				}
				else {
					dp[i][j] = dp[i-1][j] + map[i][j];
				}
			}
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				max = Math.max(dp[i][j], max);
			}
		}
		System.out.println(max);
	}
}
