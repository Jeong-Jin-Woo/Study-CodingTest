import java.util.*;
public class Main {
	static int n, m;
	static int r, c, d;
	static int[][] map;
	static boolean[][] visit;
	static int answer = 0;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static void dfs(int x, int y, int d) {

		if(!visit[x][y]) {
			visit[x][y] = true;
			answer += 1;
		}
		for(int i=0; i<4; i++) {
			d = d <= 0 ? 3 : d - 1;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(!visit[nx][ny]) {
				dfs(nx, ny, d);
				return;
			}
		}
		
		int nx = x - dx[d];
		int ny = y - dy[d];
		if(map[nx][ny] != 1) {
			dfs(nx,ny,d);
		}
		
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		r = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = in.nextInt();
				if(map[i][j] == 1) visit[i][j] = true;
			}
		}
		dfs(r,c,d);

		System.out.println(answer);
	}
}