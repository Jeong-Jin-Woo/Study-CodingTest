import java.util.*;
public class Main{
	static int[] dp = new int[32];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		dp[0] = 1;
		dp[2] = 3;
//		dp[4] = 11;
		for(int i=4; i<=n; i+=2) {
			dp[i] = dp[i-2]*4 - dp[i-4];
		}
		System.out.println(dp[n]);
	}
}
