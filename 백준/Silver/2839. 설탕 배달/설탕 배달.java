import java.util.*;
public class Main{
	static int n;
	static final int INF = (int)1e9;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int dp[] = new int[n+6];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for(int i=0; i<=n; i++) {
			dp[i+3] = Math.min(dp[i+3], dp[i] + 1);
			dp[i+5] = Math.min(dp[i+5], dp[i] + 1);
		}
//		for(int i=0; i<=n; i++) {
//			System.out.println(i + " " +dp[i]);
//		}
		System.out.println(dp[n] != INF ? dp[n] : -1);
	}
}
