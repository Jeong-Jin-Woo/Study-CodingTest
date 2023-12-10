import java.util.*;
public class Main{
	static int n, m;
	static int answer = 0;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static void dfs(int x, int y, int sum, int count) {
		if(count == 4) {
			answer = Math.max(answer, sum);
			return;
		}
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >=0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny]) {
				if(count == 2) {
					visit[nx][ny] = true;
					dfs(x, y, sum + map[nx][ny], count + 1);
					visit[nx][ny] = false;
				}
				visit[nx][ny] = true;
				dfs(nx, ny, sum + map[nx][ny], count + 1);
				visit[nx][ny] = false;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = in.nextInt();
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visit[i][j]) {
					visit[i][j] = true;
					dfs(i, j, map[i][j], 1);
					visit[i][j] = false;
				}
			}
		}
		System.out.println(answer);
	}
}
