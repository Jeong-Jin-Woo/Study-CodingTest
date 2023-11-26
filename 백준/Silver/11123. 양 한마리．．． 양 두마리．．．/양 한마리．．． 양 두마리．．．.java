import java.util.*;
public class Main{
	static int n, m;
	static char[][] map;
	static boolean dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= m) return false;
		if(map[x][y] == '#') {
			map[x][y] = '.';
			dfs(x + 1, y);
			dfs(x - 1, y);
			dfs(x, y + 1);
			dfs(x, y - 1);
			return true;
		}
		return false;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		while(c-- != 0) {
			n = in.nextInt();
			m = in.nextInt();
			map = new char[n][m];
			for(int i=0; i<n; i++) {
				String str = in.next();
				for(int j=0; j<m; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			int answer = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(dfs(i,j)) {
						answer += 1;
					}
				}
			}
			System.out.println(answer);
		}
	}
}
