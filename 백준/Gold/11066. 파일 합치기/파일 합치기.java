import java.util.*;
public class Main{
	static int sumDist(int[] sum, int x, int y) {
		if(x == 0) {
			return sum[y];
		}
		return sum[y] - sum[x-1];
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T--!=0) {
			int n = in.nextInt();
			int dp[][] = new int[n][n];
			int files[] = new int[n];
			int sum[] = new int[n];
			for(int i=0; i<n; i++) {
				files[i] = in.nextInt();
			}
			sum[0] = files[0];
			for(int i=1; i<n; i++) {
				sum[i] = sum[i-1] + files[i];
			}
			for(int i=1; i<n; i++) {
				dp[i-1][i] = files[i-1] + files[i];
			}
			
			for(int j=2; j<n; j++) {
				for(int i=0; i+j<n; i++) {
					for(int k=i; k<i+j; k++) {
						if(dp[i][i+j]==0) {
							dp[i][i+j] = dp[i][k] + dp[k+1][i+j] + sumDist(sum, i, i+j);
						}
						else {
							dp[i][i+j] = Math.min(dp[i][i+j], dp[i][k] + dp[k+1][i+j] + sumDist(sum, i, i+j));
						}
					}
	
				}
			}
			System.out.println(dp[0][n-1]);
	//		for(int a=0; a<n; a++) {
	//			for(int b=0; b<n; b++) {
	//				System.out.print(dp[a][b] + " ");
	//			}System.out.println();
	//		}
		}
	}
}
