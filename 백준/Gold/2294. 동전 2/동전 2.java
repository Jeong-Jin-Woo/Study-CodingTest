import java.util.*;

public class Main {
	static final int INF = (int)1e9;
	static int[] dp = new int[100001];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		Arrays.fill(dp, INF);
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			dp[arr[i]] = 1;
		}
		dp[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=arr[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
			}
		}
		if(dp[k] == INF) {
			System.out.println(-1);
			return;
		}
		System.out.println(dp[k]);
	}
}