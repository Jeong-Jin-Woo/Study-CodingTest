import java.util.*;
class Position{
	public int x, y;
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Solution {
	static int map[][];
	static boolean visit[];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static ArrayList<Position> pos = new ArrayList<>();
	static int n;
	static final int INF = (int)1e9;
	static int min = INF;
	static int max = 0;
	static void dfs(int index, int sum, int on) {
		if(index == pos.size()) {
			if(on > max) {
				max = on;
				min = sum;
			}
			else if(on == max) {
				min = Math.min(min, sum);
			}
			return;
		}
		if(!visit[index]) {
			int x = pos.get(index).x;
			int y = pos.get(index).y;
			visit[index] = true;
			for(int i=0; i<4; i++) {
				int nx = x;
				int ny = y;
				int count = 0;
				while(true) {
					nx += dx[i];
					ny += dy[i];
					if(nx < 0 || ny <0 || nx >= n || ny >= n) {
						break;
					}
					if(map[nx][ny] == 1) {
						count = 0;
						break;
					}
					count += 1;
				}
				nx = x;
				ny = y;
				for(int j=0; j<count; j++) {
					nx += dx[i];
					ny += dy[i];
					map[nx][ny] = 1;
				}
				if(count != 0)
					dfs(index + 1, sum + count, on + 1);
				else
					dfs(index + 1, sum + count, on);
				nx=x;
				ny=y;
				for(int j=0; j<count; j++) {
					nx += dx[i];
					ny += dy[i];
					map[nx][ny] = 0;
				}
			}
			visit[index] = false;
		}
	}
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int T;
		T = in.nextInt();
		for (int test = 1; test <= T; test++) {
			n = in.nextInt();
			map = new int[n][n];
			pos = new ArrayList<>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = in.nextInt();
					if(i == 0 || j == 0 || i == n-1 || j == n-1) continue;
					if(map[i][j] == 1) {
						pos.add(new Position(i, j));
					}
				}
			}
			visit = new boolean[pos.size()];
			min = INF;
			max = 0;
			dfs(0, 0, 0);
			System.out.println("#"+ test + " " + min);
		}
	}
}
