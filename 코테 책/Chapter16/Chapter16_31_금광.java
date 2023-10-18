import java.util.*;
public class Chapter16_31_±Ý±¤ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int c = 0; c < t; c++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] arr = new int[n][m];
			int d[][] = new int[21][21];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					arr[i][j] = in.nextInt();
					d[i][j] = arr[i][j];
				}
			}
			
			for(int j=0; j<m-1; j++) {
				for(int i=0; i<n; i++) {
					if(i > 0) {
						d[i-1][j+1] = Math.max(d[i-1][j+1], arr[i-1][j+1]+ d[i][j]);
					}
					if(i < n-1) {
						d[i+1][j+1] = Math.max(d[i+1][j+1], arr[i+1][j+1] + d[i][j]);
					}
					d[i][j+1] = Math.max(d[i][j+1], arr[i][j+1] + d[i][j]);
				}
			}
			
			int answer = 0;
			for(int i=0; i<n; i++) {
				answer = Math.max(answer, d[i][m-1]);
			}
			
			System.out.println(answer);
		}
	}
}