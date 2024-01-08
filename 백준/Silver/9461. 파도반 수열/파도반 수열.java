import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long dp[] = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		while(T--!=0) {
			int n = in.nextInt();
			for(int i=4; i<=n; i++) {
				dp[i] = dp[i-2] + dp[i-3];
			}
			System.out.println(dp[n]);
		}
	}
}