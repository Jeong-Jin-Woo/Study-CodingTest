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
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(arr[i] < arr[j])
//					dp[j] = dp[i] + 1;
					dp[j] = Math.max(dp[i] + 1, dp[j]);
			}
		}
		int max = 0;
		for(int i=0; i<n; i++)
			max = Math.max(max, dp[i]);
		System.out.println(max + 1);
	}
}
