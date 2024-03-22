import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-- != 0) {
		int n = in.nextInt();
		int[] dp = new int[10001];
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			int index = in.nextInt();
			arr[i] = index;
		}
		int goal = in.nextInt();
		for(int j=1; j<=n; j++) {
			for(int i=1; i<=goal; i++) {
				if(i - arr[j] == 0) {
					dp[i] += 1;
				}
				else if(i - arr[j] > 0) {
					dp[i] = dp[i] + dp[i-arr[j]];
				}
			}
		}
		System.out.println(dp[goal]);
		}
//		for(int i=1; i<=goal; i++) {
//			System.out.println( i + " : " + dp[i]);
//		}
	}
}
