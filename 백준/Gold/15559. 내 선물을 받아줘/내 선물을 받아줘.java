import java.util.*;
public class Main{
	static int n,m;
	static char[][] map;
	static int[][] visit;
	static boolean dfs(int x, int y, int count) {
		if(visit[x][y] == count) return true;
			if(map[x][y] == 'W' && visit[x][y] <= count) {
				visit[x][y] += count;
				if(dfs(x, y-1, count)) return true;
				else {
					visit[x][y] -= count;
					return false;
				}
			}
			else if(map[x][y] == 'E'&& visit[x][y] <= count) {
				visit[x][y] += count;
				if(dfs(x, y+1, count)) return true;
				else {
					visit[x][y] -= count;
					return false;
				}
			}
			else if(map[x][y] == 'N'&& visit[x][y] <= count) {
				visit[x][y] += count;
				if(dfs(x-1, y, count))return true;
				else {
					visit[x][y] -= count;
					return false;
				}
			}
			else if(map[x][y] == 'S'&& visit[x][y] <= count) {
				visit[x][y] += count;
				if(dfs(x+1, y, count))return true;
				else {
					visit[x][y] -= count;
					return false;
				}
			}
		
		return false;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new char[n][m];
		visit = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int answer = 0;
		int set = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
					if(visit[i][j] == 0) {
						if(dfs(i,j,answer + 1)) {
							answer += 1;
						}
					}
			}
		}
		System.out.println(answer);
	}
}