import java.math.BigInteger;
import java.util.*;
public class Main {
	static int n;
	static long map[][];
	static long dp[][];
	static int dx[] = {0, 1};
	static int dy[] = {1, 0};
	static long dfs(int x, int y) {
		if(x == n-1 && y == n-1) {
			return 1;
		}
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		int nx = (int) (x + map[x][y]);
		int ny = (int) (y + map[x][y]);
		if(ny < n) {
			dp[x][y] += dfs(x, ny);
		}
		if(nx < n)
			dp[x][y] += dfs(nx, y);
		return dp[x][y];
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new long[n][n];
		dp = new long[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = in.nextInt();
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(dp[i][j] + " ");
//			}System.out.println();
//		}
		
	}
}