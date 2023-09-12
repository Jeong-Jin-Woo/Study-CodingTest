import java.util.*;
class Position{
	int x;
	int y;
	boolean wall;
	int dist;
	Position(int x, int y, int dist, boolean wall){
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.wall = wall;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDist() {
		return dist;
	}
	public boolean getWall() {
		return wall;
	}
}
public class 벽부수고이동하기{
	static final int INF = (int)1e9;
	static int n,m;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		int[][] map = new int[n][m];
		int[][] backup = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String s = in.next();
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.valueOf(s.charAt(j) - '0');
				backup[i][j] = map[i][j];
			}
		}
		Queue<Position> pos = new LinkedList<>();
		boolean[][][] visit = new boolean[n][m][2];
		pos.offer(new Position(0,0,1,false));
		int min = INF;
		while(!pos.isEmpty()) {
			Position p = pos.poll();
			int x = p.getX();
			int y = p.getY();
			int dist = p.getDist();
			boolean w = p.getWall();
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(x == n-1 && y == m-1) {
					System.out.println(p.getDist());
					return;
				}

				if(nx >= n || ny >= m || nx < 0 || ny < 0) {
					continue;
				}
				
				if(map[nx][ny] == 0) {
					if(p.getWall() && !visit[nx][ny][1]) { //벽 부순거
						visit[nx][ny][1] = true;
						pos.offer(new Position(nx, ny, dist + 1, true));
					}
					if(!p.getWall() && !visit[nx][ny][0]) { //안부순거
						visit[nx][ny][0] = true;
						pos.offer(new Position(nx, ny, dist + 1, false));
					}
				}
				else if(map[nx][ny] == 1) {
					if(!p.getWall()) {
						visit[nx][ny][1] = true;
						pos.offer(new Position(nx, ny, dist + 1, true));
					}
				}
			}
			
		}
		System.out.println(-1);
		
	}
}