import java.util.*;
public class Main{
	static long[] dp = new long[91];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
	}
}
