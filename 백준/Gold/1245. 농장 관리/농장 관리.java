import java.util.*;

class Position {
	public int x;
	public int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int answer = 0;
	static int min = 500;
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };

	static void bfs(int x, int y, int v) {
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		visit[x][y] = true;
		boolean chk = true;
		while (!q.isEmpty()) {
			Position now = q.poll();
			x = now.x;
			y = now.y;
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if(map[nx][ny] == v && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new Position(nx, ny));
					}
					else if(map[nx][ny] > v) {
						chk = false;
					}
				}
			}
		}
		if(chk) answer += 1;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = in.nextInt();
				min = Math.min(min, map[i][j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j] && map[i][j] > min) {
					bfs(i, j, map[i][j]);
				}
			}
		}
		System.out.println(answer);

	}
}
