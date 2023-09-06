import java.util.*;
public class ±Ý±¤{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		for(int t = 0; t < c; t++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int arr[][] = new int[n+2][m+2];
			int[][] d = new int[n+2][m+2];
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			for(int i=1; i<=n; i++) {
				d[i][1] = arr[i][1];
			}
			
			for(int i=2; i<=m; i++) {
				for(int j=1; j<=n; j++) {
					d[j][i] += Math.max(d[j-1][i-1] + arr[j][i], Math.max(d[j][i-1]+ arr[j][i], d[j+1][i-1]+ arr[j][i]));
				}
			}
			
			int answer = 0;
			for(int i=1; i<=n; i++) {
				answer = Math.max(d[i][m],answer);
			}
			System.out.println(answer);
		}
	}
}