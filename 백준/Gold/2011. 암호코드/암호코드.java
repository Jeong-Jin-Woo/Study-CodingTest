import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		int mod = 1000000;
		int[] dp = new int[5001];
		dp[0] = 1;
		if(str.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		dp[1] = 1;
		for(int i=2; i<=str.length(); i++) {
			String sub = str.substring(i-1, i);
			int s = Integer.valueOf(sub);
			if(s >= 1 && s <= 9) {
				dp[i] += dp[i-1];
				dp[i] %= mod;
			}
			int p = str.charAt(i-2) - '0';
			if(p == 0) continue;
			int v = p*10+s;
			if(v >= 10 && v <= 26) {
				dp[i] += dp[i-2];
				dp[i] %= mod;
			}
//			System.out.println(sub + " " + dp[i]);
		}
		System.out.println(dp[str.length()] % mod);
	}
}