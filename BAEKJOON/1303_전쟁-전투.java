import java.util.*;
public class 전쟁_전투{
	static int n,m;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] map = new int[101][101];
	static boolean[][] visit = new boolean[101][101];
	static int s = 0;
	public static int dfs(int x, int y, int num) {
		if(x < 0 || y < 0 || x >= n || y > m) return 0;
		if(map[x][y] == num && !visit[x][y]) {
			map[x][y] = 0;
			visit[x][y] = true;
			s += 1;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					dfs(nx, ny, num);
				}
			}
		}
		return s;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<m; j++) {
				if(str.charAt(j) == 'W') {
					map[i][j] = 1;
				}
				else {
					map[i][j] = 2;
				}
			}
		}

		int W = 0, B = 0;
		for(int a=1; a<=2; a++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					s = 0;
					int num = dfs(i,j,a);
					if(a == 1) {
						//W일때
						W += Math.pow(num, 2);
					}
					else if(a == 2) {
						B += Math.pow(num, 2);
					}
				}
			}
		}
		System.out.println(W + " " + B);
	}
}
