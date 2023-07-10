import java.util.*;
public class Chapter17_38_정확한순위 {
	static final int INF = (int)1e9;
	static int d[][] = new int[501][501];
	static int n,m;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		
		for(int i=0; i<=n; i++) {
			Arrays.fill(d[i], INF);
		}
		for(int i=0; i<=n; i++)
			d[i][i] = 0;
		
 		for(int i=1; i<=m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			d[a][b] = 1;
		}
		for(int z=1; z<=n; z++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
						d[i][j] = Math.min(d[i][j], d[i][z] + d[z][j]); 
				}
			}
		}
		int answer = 0;
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=1; j<=n; j++) {
				if(d[i][j] != INF || d[j][i] != INF) {
					sum++;
				}
			}
			if(sum == n)
				answer++;
		}
		System.out.println(answer);
	}
}
