import java.util.*;
public class Main{
	static int n, m;
	static int[][] map;
	static int[] dx = {0,0,-1,1,-1,1,-1,1};
	static int[] dy = {-1,1,0,0,-1,1,1,-1};
	static boolean dfs(int x, int y) {
		if(x < 0 || y< 0 || x >= n || y >= m || map[x][y] == 0) return false;
		if(map[x][y] == 1) {
			map[x][y] = 0;
			for(int i=0; i<8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					dfs(nx, ny);
				}
			}
			return true;
		}
		return false;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = in.nextInt();
			}
		}
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) {
					if(dfs(i,j)) answer += 1;
				}
			}
		}
		System.out.println(answer);
	}
}
