import java.util.*;
class Position{
	int x;
	int y;
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX() { return x; }
	public int getY() { return y; }
}
public class Main{
	static final int INF = (int)1e9;
	static int n;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new int[n][n];
		dp = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j)-'0';
				dp[i][j] = INF;
			}
		}
		Queue<Position> pos = new LinkedList<>();
		int x = 0, y = 0;
		dp[x][y] = 0;
		pos.offer(new Position(x,y));
		while(!pos.isEmpty()) {
			Position now = pos.poll();
			x = now.getX();
			y = now.getY();
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n &&  ny < n && dp[nx][ny] > dp[x][y]) {
					if(map[nx][ny] == 1) {
						dp[nx][ny] = dp[x][y];
					}
					else {
						dp[nx][ny] = dp[x][y] + 1;
					}
					pos.offer(new Position(nx, ny));
				}
			}
		}
		System.out.println(dp[n-1][n-1]);
	}
}
