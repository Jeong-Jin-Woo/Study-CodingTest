import java.util.*;

public class Main {
	static final int INF = (int) 1e9;
	static int[][] map = new int[10][10];
	static int[] count = { 0, 5, 5, 5, 5, 5 };
	static int answer = INF;

	static void dfs(int x, int y, int cnt) {
		if (answer <= cnt) {
			return;
		}
		if (x >= 9 && y >= 10) {
			answer = Math.min(answer, cnt);
			return;
		}
		if (y > 9) {
			dfs(x + 1, 0, cnt);
			return;
		}
		if (map[x][y] == 1) {
			for (int size = 5; size >= 1; size--) {
				if (count[size] > 0 && chk(x, y, size)) {
					chg(x, y, size, 0);
					count[size] -= 1;
					dfs(x, y + 1, cnt + 1);
					chg(x, y, size, 1);
					count[size] += 1;
				}
			}
		} else {
			dfs(x, y + 1, cnt);
			return;
		}
	}

	static void chg(int x, int y, int size, int get) {
		for (int i = x; i < x + size && i < 10; i++) {
			for (int j = y; j < y + size && j < 10; j++) {
				map[i][j] = get;
			}
		}
	}

	static boolean chk(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || j < 0 || i>=10 || j >= 10 || map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = in.nextInt();
			}
		}
		dfs(0, 0, 0);
		System.out.println(answer == INF ? -1 : answer);
	}
}
