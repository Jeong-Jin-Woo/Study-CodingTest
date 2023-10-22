import java.util.*;
public class Main{
	static int n, m;
	static int[][] map = new int[8][8];
	static int[][] bmap = new int[8][8];
	static int answer = 0;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static void virus(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >=0 && ny >=0 && nx <n && ny < m) {
				if(map[nx][ny] == 0) {
					map[nx][ny] = 2;
					virus(nx, ny);
				}
			}
		}
	}
	static int count() {
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0)
					count += 1;
			}
		}
		return count;
	}
	static void dfs(int count) {
		if(count == 3) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					map[i][j] = bmap[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 2) {
						virus(i,j);
					}
				}
			}
			answer = Math.max(answer, count());
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(bmap[i][j] == 0) {
					bmap[i][j] = 1;
					count += 1;
					dfs(count);
					bmap[i][j] = 0;
					count -= 1;
				}
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
				bmap[i][j] = map[i][j];
			}
		}
		dfs(0);
		System.out.println(answer);
		
	}
}
