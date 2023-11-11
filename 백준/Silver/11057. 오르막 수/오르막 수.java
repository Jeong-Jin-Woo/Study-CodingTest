import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] arr = new long[10];
		long[] dp = new long[10];
		Arrays.fill(dp, 1);
		Arrays.fill(arr, 1);
		for(int i=1; i<n; i++) {
			for(int j=1; j<10; j++) {
				dp[j] = dp[j-1] % 10_007 + arr[j] % 10_007;
				arr[j] = dp[j];
			}
		}
		long answer = 0;
		for(int i=0; i<10; i++) {
			answer += dp[i] % 10_007;
		}
		System.out.println(answer% 10_007);
	}
}
