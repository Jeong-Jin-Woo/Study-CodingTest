import java.util.*;
class Position{
	public int x;
	public int y;
	public int z;
	public int dist;
	Position(int x, int y, int z, int dist){
		this.x=x;
		this.y=y;
		this.z=z;
		this.dist=dist;
	}
}
public class Main{
	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {-1,1,0,0,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int h = in.nextInt();
		int[][][] map = new int[h][n][m];
		Queue<Position> q = new LinkedList<>();
		for(int z=0; z<h; z++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					map[z][i][j] = in.nextInt();
					if(map[z][i][j] == 1) {
						q.offer(new Position(i,j,z,0));
					}
				}
			}
		}
		int answer = 0;
		while(!q.isEmpty()) {
			int len = q.size();
			for(int l=0; l<len; l++) {
				Position now = q.poll();
				int x = now.x;
				int y = now.y;
				int z = now.z;
				int dist = now.dist;
				for(int i=0; i<6; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int nz = z + dz[i];
					if(nx >=0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h && map[nz][nx][ny] == 0) {
						map[nz][nx][ny] = 1;
						q.offer(new Position(nx, ny, nz, dist+1));
						answer = Math.max(answer, dist+1);
					}
				}
			}
		}
		for(int z=0; z<h; z++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[z][i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(answer);
		
	}
}
