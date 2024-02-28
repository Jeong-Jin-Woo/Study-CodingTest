import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		dp[0] = arr[0];
		for(int i=1; i<n; i++) {
			if(dp[i-1] < 0) {
				dp[i] = arr[i];
			}
			else {
				dp[i] = dp[i-1] + arr[i];
			}
		}
		int answer = (int)-1e9;
		for(int i=0; i<n; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
