import java.util.*;

public class Main {
	static int n, m;
	static char[][] map = new char[21][21];
	static boolean[] alphabet = new boolean[27];
	static int max = 1;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void dfs(int x, int y, int cnt) {
		if (x >= n || y >= m || x < 0 || y < 0)
			return;
		if (!alphabet[map[x][y] - '0' - 17]) {
			alphabet[map[x][y] - '0' - 17] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < n && ny < m && nx >= 0 && ny >= 0) {
					dfs(nx, ny, cnt + 1);
				}
			}
			alphabet[map[x][y] - '0' - 17] = false;
		} else {
			max = Math.max(max, cnt);
			return;
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();

		for (int i = 0; i < n; i++) {
			String str = in.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		dfs(0, 0, 0);
		System.out.println(max);
	}
}