import java.util.*;
class Position{
	public int x;
	public int y;
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Me{
	public int x;
	public int y;
	public int cnt;
	Me(int x, int y, int cnt){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}
public class Main{
	static int n,m;
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new char[n][m];
		Queue<Me> me = new LinkedList<>();
		Queue<Position> fire = new LinkedList<>();
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') {
					me.offer(new Me(i,j,0));
				}
				if(map[i][j] == 'F') {
					fire.offer(new Position(i,j));
				}
			}
		}
		while(true) {
			int len = fire.size();//불이 움직
			for(int i=0; i<len; i++) {
				Position now = fire.poll();
				int x = now.x;
				int y = now.y;
				for(int c=0; c<4; c++) {
					int nx = x + dx[c];
					int ny = y + dy[c];
					if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == '.') {
						map[nx][ny] = 'F';
						fire.offer(new Position(nx, ny));
					}
				}
			}
			
			len = me.size();//내가 움직이는거
			for(int i=0; i<len; i++) {
				Me now = me.poll();
				int x = now.x;
				int y = now.y;
				int cnt = now.cnt;
				for(int c=0; c<4; c++) {
					int nx = x + dx[c];
					int ny = y + dy[c];
					if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
						System.out.println(cnt + 1);
						return;
					}
					if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == '.') {
						map[nx][ny] = 'J';
						me.offer(new Me(nx, ny, cnt + 1));
					}
				}
			}
			if(len == 0) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
		
		
		
	}
}
