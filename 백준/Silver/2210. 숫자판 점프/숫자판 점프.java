import java.util.*;
public class Main{
	static int n = 5;
	static ArrayList<String> arr = new ArrayList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void dfs(int x, int y, int count, String s,String[][] map) {
		if(count == 6) {
			if(!arr.contains(s)) {
				arr.add(s);
			}
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0<=nx&&nx<5&&0<=ny&&ny<5) {
				dfs(nx, ny, count+1, s+map[nx][ny], map);
			}
		}
		
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String map [][] = new String[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = in.next();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dfs(i,j,0,"",map);
			}
		}
		System.out.print(arr.size());
	}
}