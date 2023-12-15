import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] dp = new int[100001];
//		dp[1] = 1;
//		dp[2] = 2;
//		dp[3] = 3;
//		dp[4] = 1;
//		dp[5] = 2;
//		dp[6] = 3;
//		dp[7] = 4;
//		dp[8] = 2;
//		dp[9] = 1;
//		dp[10] = 2;
//		dp[11] = 3;
//		dp[12] = 4;
//		dp[13] = 2;
//		dp[14] = 3;
		for(int i=0; i<=n; i++) {
			dp[i] = i;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j*j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
			}
		}
		System.out.println(dp[n]);
	}
}
