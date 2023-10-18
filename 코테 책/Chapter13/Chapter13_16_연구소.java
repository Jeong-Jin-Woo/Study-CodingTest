import java.util.*;
public class Chapter13_16_¿¬±¸¼Ò {
	static int map[][] = new int[8][8];
	static int bmap[][] = new int[8][8];
	static int n, m, count;
	static int answer = 0;
	
	public static void virus(int y, int x) {
		int dx[] = {0, 0, 1, -1};
		int dy[] = {1, -1, 0, 0};
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
				if(bmap[ny][nx] == 0) {
					bmap[ny][nx] = 2;
					virus(ny, nx);
				}
			}
		}
	}
	public static int getCount() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(bmap[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void dfs(int count) {
		if(count == 3) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					bmap[i][j] = map[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(bmap[i][j] == 2)
						virus(i,j);
				}
			}
			answer = Math.max(answer, getCount());
			return;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					count++;
					dfs(count);
					map[i][j] = 0;
					count--;
				}
			}
		}
	}
	public static void main(String[] args) {
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