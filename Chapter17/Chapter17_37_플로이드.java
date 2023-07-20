import java.util.*;
public class Chapter17_37_플로이드 {
	static final int INF = (int)1e9;
	static int d[][] = new int[101][101];
	static int n,m;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		
		for(int i=1; i<=n; i++)
			Arrays.fill(d[i], INF);
		
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if(d[a][b] > c)
				d[a][b] = c;
		}
		
		for(int i=1; i<=n; i++)
			d[i][i] = 0;
		
		for(int z=1; z<=n; z++)
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					d[i][j] = Math.min(d[i][j], d[i][z]+d[z][j]);
				}
			}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
	}
}
