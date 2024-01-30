import java.util.*;

public class Main {
	static int n;
	static int map[][];
	static int answer = (int) 1e9;
	static boolean visit[];

	static void dfs(int start, int count) {
		if (count == n / 2) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if (visit[i] && visit[j]) {
						a += map[i][j] + map[j][i];
					}
					if (!visit[i] && !visit[j]) {
						b += map[i][j] + map[j][i];
					}
				}
			}
			answer = Math.min(answer, Math.abs(a - b));
			return;
		}
		for (int i = start; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, count + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
			}
		}

		dfs(0, 0);
		System.out.println(answer);
	}
}
