import java.util.*;
public class Main{
	static final int INF = (int)1e9;
	static int n = 5; //5x5 보드
	static int answer = INF;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static void dfs(int x, int y, int sum, int count, int[][] map) { // x, y, 사과 먹은 횟수, 이동 횟수, map
		if(sum == 3) {
			answer = Math.min(answer, count);
			return;
		}
		map[x][y] = -1;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] != -1) {
				if(map[nx][ny] == 1) {
					map[nx][ny] = -1;
					dfs(nx, ny, sum+1, count+1, map);
					map[nx][ny] = 1;
				}
				else {
					map[nx][ny] = -1;
					dfs(nx, ny, sum, count+1, map);
					map[nx][ny] = 0;
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int map[][] = new int[5][5];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = in.nextInt();
			}
		}
		int x = in.nextInt();
		int y = in.nextInt();
		dfs(x, y, 0, 0, map);
		if(answer == INF) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
}
