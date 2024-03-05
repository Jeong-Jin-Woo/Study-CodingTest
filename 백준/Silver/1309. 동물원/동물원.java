import java.util.*;
public class Main{
	static int dp[] = new int[100001];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		dp[1] = 3;
		dp[2] = 7;
//		dp[3] = 15;
//		dp[4] = 41;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1]*2+ dp[i-2])%9901;
		}
		System.out.println(dp[n]%9901);
	}
}
