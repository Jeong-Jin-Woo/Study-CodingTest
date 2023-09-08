

/*
import java.util.*;
public class ¼¶ÀÇ°³¼ö{
	static int n, m;
	static int[][] map = new int[50][50];
	public static boolean dfs(int x, int y) {
		if(x < n && y < m && x >= 0 && y >=0) { 
			if(map[x][y] == 1) {
				map[x][y] = 0;
				dfs(x-1,y);
				dfs(x+1,y);
				dfs(x,y-1);
				dfs(x,y+1);
				dfs(x-1,y-1);
				dfs(x+1,y+1);
				dfs(x+1,y-1);
				dfs(x-1,y+1);
				return true;
			}
			else return false;
		}
		return false;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while(true) {
			m = in.nextInt();
			n = in.nextInt();
			if(m==0&& n==0) break;
			for(int i=0; i<map.length; i++) {
				Arrays.fill(map[i],0);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					map[i][j] = in.nextInt();
				}
			}
	
			int answer = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(dfs(i, j))
						answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
*/