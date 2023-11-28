import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-- != 0) {
			int n = in.nextInt();
			int arr[][] = new int[2][n+1];
			int dp[][] = new int[2][n+1];
			for(int i=0; i<2; i++) {
				for(int j=1; j<=n; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for(int i=2; i<=n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + arr[1][i];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));	
		}
	}
}