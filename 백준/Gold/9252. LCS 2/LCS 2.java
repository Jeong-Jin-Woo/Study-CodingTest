import java.util.*;

public class Main {
	static String answer = "";
	static int[][] dp;
	static int n,m;
	static String str1, str2;
	static void st(int x, int y) {
		Stack<Character> s = new Stack<>();
		while(dp[x][y] != 0) {
			if(dp[x][y] == dp[x-1][y]) {
				x-=1;
			}
			else if(dp[x][y] == dp[x][y-1]) {
				y-=1;
			}
			else {
				s.push(str1.charAt(x-1));
				x-=1;
				y-=1;
			}
		}
		while(!s.isEmpty()) {
			answer += s.pop();
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		str1 = in.next();
		str2 = in.next();
		n = str1.length();
		m = str2.length();
		dp = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[n][m]);
		st(n, m);
		System.out.println(answer);
	}
}
