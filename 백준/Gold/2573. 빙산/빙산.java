import java.util.*;
class Position{
	int x;
	int y;
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
public class Main{	
	static int n, m;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int[][] map = new int[301][301];
	static int[][] vmap = new int[301][301];
	static boolean[][] visit;
	public static boolean dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 0) {
			return false;
		}
		if(!visit[x][y]) {
			visit[x][y] = true;
			dfs(x-1,y);
			dfs(x+1,y);
			dfs(x,y-1);
			dfs(x,y+1);
			return true;
		}
		return false;
	}
	public static void melt(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i]; 
			int ny = y + dy[i];
			if(vmap[nx][ny] == 0 && map[x][y] > 0) {
				map[x][y] -= 1;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = in.nextInt();
			}
		}
		
		int year = 0;
		while(true) {
			int cnt = 0;
			visit = new boolean[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] != 0) {
						if(dfs(i,j)) cnt += 1;
					}
				}
			}
			if(cnt >= 2 || cnt < 1) break;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					vmap[i][j] = map[i][j];
				}
			}
			
			int b = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] != 0) {
						melt(i,j);
					}
					if(map[i][j] == 0)
						b += 1;
				}
			}
			year += 1;
			if(b == n*m) year = 0;
		}

		System.out.println(year);
	}
}