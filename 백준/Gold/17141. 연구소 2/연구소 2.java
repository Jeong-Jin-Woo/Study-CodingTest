import java.util.*;
class Position{
	public int x;
	public int y;
	public int cnt;
	Position(int x, int y, int cnt){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}
public class Main {
	static final int INF = (int) 1e9;
	static int n, m;
	static int map[][];
	static int bmap[][];
	static boolean visit[];
	static int virus[];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static ArrayList<Position> pos = new ArrayList<>();
	static int answer = INF; 
	static void dfs(int start, int count) {
		if(count == m) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(bmap[i][j] == 2) {
						map[i][j] = 0;
					}
					else
						map[i][j] = bmap[i][j];
				}
			}
			bfs();
			return;
		}
		for(int i=start; i<pos.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				virus[count] = i;
				dfs(i, count + 1);
				visit[i] = false;
			}
		}
	}
	
	static void bfs() {
		int max = 0;
		boolean[][] visitmap = new boolean[n][n];
		Queue<Position> v = new LinkedList<>();
		for(int i=0; i<m; i++) {
			int x = pos.get(virus[i]).x;
			int y = pos.get(virus[i]).y;
			v.offer(new Position(x, y, 0));
			map[x][y] = 2;
			visitmap[x][y] = true;
		}
		while(!v.isEmpty()) {
			Position now = v.poll();
			int x = now.x;
			int y = now.y;
			int c = now.cnt;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visitmap[nx][ny]) {
					if(map[nx][ny] == 0) {
						map[nx][ny] = 2;
						visitmap[nx][ny] = true;
						v.offer(new Position(nx, ny, c + 1));
						max = Math.max(max, c+1);
					}
				}
			}
		}		
		if(possible()) {
			answer = Math.min(answer, max);
			return;
		}
	}
	static boolean possible() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[n][n];
		bmap = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = in.nextInt();
				if(map[i][j] == 2) {
					pos.add(new Position(i,j,0));
				}
				bmap[i][j] = map[i][j];
			}
		}
		virus = new int[pos.size()];
		visit = new boolean[pos.size()];
		dfs(0, 0);
		System.out.println(answer == INF ? -1 : answer);
	}
}
