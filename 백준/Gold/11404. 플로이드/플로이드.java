import java.util.*;
public class Main{
	static final int INF = (int)1e9;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(map[i], INF);
		}
		for(int i=0; i<n; i++) {
			map[i][i] = 0;
		}
		int m = in.nextInt();
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if(map[a-1][b-1] > c)
				map[a-1][b-1] = c;
		}
		for(int z=0; z<n; z++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][z] +map[z][j]);
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == INF) map[i][j] = 0;
				System.out.print(map[i][j] +" ");
			}System.out.println();
		}
	}
}
