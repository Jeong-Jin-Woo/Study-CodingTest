import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[301];
		int dp[] = new int[301];
		for(int i=1; i<=n; i++) {
			arr[i] = in.nextInt();
		}
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(arr[1], arr[2]) + arr[3];
		for(int i=4; i<=n; i++) {
			dp[i] = Math.max(arr[i-1]+ dp[i-3] + arr[i], dp[i-2] + arr[i]);
		}
//		for(int i=0; i <=n; i++) {
//			System.out.print(dp[i] + "  ");
//		}
		System.out.println(dp[n]);
	}
}