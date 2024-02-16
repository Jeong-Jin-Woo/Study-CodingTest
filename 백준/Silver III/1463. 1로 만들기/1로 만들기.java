import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[] = new int[3*n+1];
		int INF = (int) 1e9;
		Arrays.fill(dp, INF);
		dp[1] = 0;
		int index = 1;
		while(true) {
			if(index == n) {
				break;
			}
			dp[index*3] = Math.min(dp[index*3], dp[index] + 1);
			dp[index*2] = Math.min(dp[index*2], dp[index] + 1);
			dp[index+1] = Math.min(dp[index+1], dp[index] + 1);
			index+=1;
		}
		System.out.println(dp[n]);
	}
}