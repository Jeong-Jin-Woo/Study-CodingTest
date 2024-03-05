import java.util.*;
public class Main{
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = in.nextInt();
			}
		}
		int[][] dp = new int[n][m];
		dp[0][0] = map[0][0];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int d=0; d<4; d++) {
					int nx = dx[d] + i;
					int ny = dy[d] + j;
					if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
						dp[nx][ny] = Math.max(dp[nx][ny], dp[i][j] + map[nx][ny]);
					}
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(dp[i][j] + " ");
//			}System.out.println();
//		}
		System.out.println(dp[n-1][m-1]);
	}
}
