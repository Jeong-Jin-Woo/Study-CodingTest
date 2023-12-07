import java.util.*;
public class Main{
	static int[][] dp = new int[30][30];
	static int simul(int n, int r) { // 5 2
		if(dp[n][r] > 0) { 
			return dp[n][r];
		}
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		return dp[n][r] = simul(n-1, r-1) + simul(n-1, r);
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		while(c-- != 0) {
			int r = in.nextInt(); // 2
			int n = in.nextInt(); // 5
			System.out.println(simul(n, r)); // 5 2
		}
	}
}
