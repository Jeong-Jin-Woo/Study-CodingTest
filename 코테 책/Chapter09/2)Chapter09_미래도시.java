import java.util.*;
public class Chapter09_2_미래도시{
	static final int INF = (int)1e9;
	static int n, m, x, k, start;
	static int d[][] = new int[101][101];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		
		for(int i=1; i<=100; i++) {
			Arrays.fill(d[i], INF);
		}
		
		for(int i=1; i<=n; i++)
			d[i][i] = 0;
		
		for(int i=1; i<=m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			d[a][b] = 1;
			d[b][a] = 1;
		}
		
		x = in.nextInt();
		k = in.nextInt();
		
		for(int z=1; z<=n; z++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					d[i][j] = Math.min(d[i][j] , d[i][z]+d[z][j]);
				}
			}
		}
		
		int dist = d[1][k] + d[k][x];
		
		if(dist >= INF)
			System.out.println("-1");
		else
			System.out.println(dist);
		
	}
}