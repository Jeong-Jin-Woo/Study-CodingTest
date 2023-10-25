import java.util.*;
public class Main{
	static int n,m,t;
	static int answer = 0;
	static int[] dx = {-1,1,0,0,0};
	static int[] dy = {0,0,-1,1,0};
	static void dfs(int x, int y, int count, int sum, char[][] dist) { // x, y, 이동한 횟수, 먹은 개수, map정보
		if(count == t) {
			answer = Math.max(answer, sum);
			return;
		}
		for(int i=0; i<5; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >=0 && nx < n && ny < m && dist[nx][ny] != '#') {
				if(dist[nx][ny] == 'S') {
					dist[nx][ny] = '.';
					dfs(nx, ny, count+1, sum + 1, dist);
					dist[nx][ny] = 'S';
				}
				else
					dfs(nx, ny, count+1, sum, dist);
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		t = in.nextInt();
		char[][] map = new char[n][m];
		int x=0, y=0;
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'G') {
					x=i; y=j;
					map[i][j] = '.';
				}
			}
		}
		dfs(x,y,0,0, map);
		System.out.println(answer);
	}
}
