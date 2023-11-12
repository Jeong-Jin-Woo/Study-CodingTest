import java.util.*;
public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][2];
		int[] dp = new int[n];
		for(int i=0; i<n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			arr[i][0] = a;
			arr[i][1] = b;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
		
		int max = 0;
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j][1] <= arr[i][1]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		for(int i=0; i<n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(n - max);
	}
}
