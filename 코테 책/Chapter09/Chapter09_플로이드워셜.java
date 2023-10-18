import java.util.*;
public class Chapter09_플로이드워셜{
	static final int INF = (int)1e9;
	static int n, m;
	static int d[][] = new int[1001][1001];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();

		for(int i=0; i<1001; i++)
			Arrays.fill(d[i], INF);
		
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			d[a][b] = c;
		}
		
		for(int i=1; i<=n; i++) {
			d[i][i] = 0;
		}
		
		for(int z=1; z<=n; z++) { // ex) D12 와 D13+D32 중 작은거
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					d[i][j] = Math.min(d[i][j], d[i][z] + d[z][j]);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(d[i][j] == INF)
					System.out.print("INFINITY ");
				else
					System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
	}
}