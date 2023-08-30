import java.util.*;
public class ¿¬±¸¼Ò {
	static int n,m;
	static int[][] map = new int[8][8];
	static int[][] bmap = new int[8][8];
	static int answer = 0;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void virus(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < n && ny < m && nx >= 0 && ny >= 0 && bmap[nx][ny] == 0) {
				bmap[nx][ny] = 2;
				virus(nx,ny);
			}
		}
	}
	public static int chk() {
		int result = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(bmap[i][j] == 0)
					result++;
			}
		}
		return result;
	}
	public static void dfs(int start) {
		if(start == 3) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					bmap[i][j] = map[i][j];
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(bmap[i][j] == 2)
						virus(i, j);
				}
			}
			answer = Math.max(answer, chk());
			return;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					start++;
					map[i][j] = 1;
					dfs(start);
					start--;
					map[i][j] = 0;
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
			}
		}
		dfs(0);
		System.out.println(answer);
	}
}