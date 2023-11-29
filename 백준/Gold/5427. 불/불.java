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
		int c = in.nextInt();
		while(c-- != 0) {
			m = in.nextInt();
			n = in.nextInt();
			map = new char[n][m];
			Queue<Me> me = new LinkedList<>();
			Queue<Position> fire = new LinkedList<>();
			for(int i=0; i<n; i++) {
				String str = in.next();
				for(int j=0; j<m; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '@') {
						me.offer(new Me(i,j,0));
					}
					if(map[i][j] == '*') {
						fire.offer(new Position(i,j));
					}
				}
			}
			int answer = 0;
			while(!me.isEmpty()) {
				int len = fire.size();
				for(int l=0; l<len; l++) {
					Position now = fire.poll();
					int x = now.x;
					int y = now.y;
					for(int i=0; i<4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(nx >= 0 && ny >= 0 && nx <n && ny < m && map[nx][ny] != '#' && map[nx][ny] != '*') {
							map[nx][ny] = '*';
							fire.offer(new Position(nx, ny));
						}
					}
				}
				len = me.size();
				boolean chk = true;
				for(int l=0; l<len; l++) {
					Me now = me.poll();
					int x = now.x;
					int y = now.y;
					int cnt = now.cnt;
					
					for(int i=0; i<4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(nx >= 0 && ny >= 0 && nx < n && ny<m) {
							if(map[nx][ny] == '.') {
								map[nx][ny] = '@';
								me.offer(new Me(nx, ny, cnt+1));
							}
						}
						else {
							if(chk) {
								answer = cnt + 1;
								chk = false;
								break;
							}
						}
					}
					if(!chk) break;
				}
				if(!chk) break;
			}
			System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);
		}
	}
}
