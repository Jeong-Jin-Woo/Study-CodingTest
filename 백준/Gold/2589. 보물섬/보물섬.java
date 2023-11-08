import java.util.*;
class Position{
	public int x;
	public int y;
	public int count;
	Position(int x, int y, int count){
		this.x=x;
		this.y=y;
		this.count=count;
	}
}
public class Main{
	static final int INF = (int)1e9;
	static int n,m;
	static int[][] map;
	static char[][] MAP;
	static int answer = 0;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static void bfs(int x, int y) {
		Queue<Position> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];
		visit[x][y] = true;
		q.offer(new Position(x, y, 0));
		while(!q.isEmpty()) {
			Position now = q.poll();
			x = now.x;
			y = now.y;
			int c = now.count;
			for(int i=0; i<4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(nx >= 0 && ny >=0 && nx < n && ny <m && MAP[nx][ny] != 'W' && !visit[nx][ny]) {
					q.offer(new Position(nx, ny, c+1));
					visit[nx][ny] = true;
					map[nx][ny] = map[x][y] + 1;
					answer = Math.max(answer, c+1);
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}System.out.println();
		
	}
//	static void dfs(int count, int x, int y) {
//		if(count == 2) {
//			bfs(x, y);
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					map[i][j] = bmap[i][j];
//					MAP[i][j] = BMAP[i][j];
//				}
//			}
//			return;
//		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				if(MAP[i][j] != 'W' && !chk[i][j]) {
//					chk[i][j] = true;
//					MAP[i][j] = 'B';
//					dfs(count + 1, i, j);
//					MAP[i][j] = 'L';
//					chk[i][j] = false;
//				}
//			}
//		}
//	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		MAP = new char[n][m];
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<m; j++) {
				MAP[i][j] = str.charAt(j);
				if(str.charAt(j) == 'W') {
					map[i][j] = -1;
				}
				else {
					map[i][j] = 0;
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(MAP[i][j] == 'L')
					bfs(i, j);
			}
		}
		System.out.println(answer);
	}
}