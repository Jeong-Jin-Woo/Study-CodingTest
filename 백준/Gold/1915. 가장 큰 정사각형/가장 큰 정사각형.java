import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] map = new int[n][m];
		int[][] dp = new int[n+1][m+1];
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int max = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(map[i-1][j-1] == 1) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max * max);
	}
}
