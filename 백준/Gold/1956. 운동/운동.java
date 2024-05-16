import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i != j) {
						map[i][j] = INF;
					}
				}
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				map[a][b] = Math.min(map[a][b], v);
			}
			for (int z = 1; z <= n; z++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (i == j)
							continue;
						map[i][j] = Math.min(map[i][j], map[i][z] + map[z][j]);
					}
				}
			}
			int answer = INF;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(i == j) continue;
					if (map[i][j] != INF && map[j][i] != INF) {
						answer = Math.min(answer, map[i][j] + map[j][i]);
					}
				}
			}
			System.out.println(answer != INF ? answer : -1);
	}
}
