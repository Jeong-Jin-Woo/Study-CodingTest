import java.util.*;
public class Main{
	static final int INF = (int)1e9;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] map = new int[n][3];
		int[][] dp = new int[n][3];
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				map[i][j] = in.nextInt();
			}
		}
		int answer = INF;
		for(int rgb = 0; rgb < 3; rgb++) {
			for(int i=0; i<3; i++) {
				if(rgb==i) {
					dp[0][i] = map[0][i];
				}
				else {
					dp[0][i] = INF;
				}
			}
			for(int i=1; i<n; i++) {
				dp[i][0] = Math.min(dp[i-1][1] + map[i][0], dp[i-1][2] + map[i][0]);
				dp[i][1] = Math.min(dp[i-1][0] + map[i][1], dp[i-1][2] + map[i][1]);
				dp[i][2] = Math.min(dp[i-1][1] + map[i][2], dp[i-1][0] + map[i][2]);
			}
			dp[n-1][rgb] = INF;
			for(int i=0; i<3; i++) {
				answer = Math.min(answer, dp[n-1][i]);
			}
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<3; j++) {
//					System.out.print(dp[i][j] + " ");
//				}System.out.println();
//			}System.out.println();
		}
		System.out.println(answer);
	}
}
