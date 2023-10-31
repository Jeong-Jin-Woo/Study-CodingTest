import java.util.*;
public class Main{
	static int n = 5; //5x5 보드
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int map[][] = new int[5][5];
	static boolean visit[][] = new boolean[5][5];
	static boolean chk = false;
	static void dfs(int x, int y, int sum, int count) { // x, y ,사과 먹은 개수, 이동 횟수
		if(count > 3) {
			return;
		}
		if(sum == 2) {
			chk = true;
			return;
		}
		visit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] != -1 && !visit[nx][ny]) {
				if(map[nx][ny] == 1) {
					visit[nx][ny] = true;
					dfs(nx, ny, sum+1, count+1);
					visit[nx][ny] = false;
				}
				else {
					visit[nx][ny] = true;
					dfs(nx, ny, sum, count+1);
					visit[nx][ny] = false;
				}
			}
		}
		visit[x][y] = false;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = in.nextInt();
			}
		}
		int x = in.nextInt();
		int y = in.nextInt();
		dfs(x, y, 0, 0);
		System.out.println(chk ? 1 : 0);
	}
}
