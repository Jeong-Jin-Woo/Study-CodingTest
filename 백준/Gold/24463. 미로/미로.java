import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Position{
	int x;
	int y;
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
public class Main {
	static int n, m;
	static ArrayList<Position> start = new ArrayList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static void dfs(int x, int y, int targetX, int targetY) {
		if(targetX == x && y == targetY) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++) {
				sb.append(map[i]);
				sb.append("\n");
			}
			System.out.println(sb.toString());
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(map[i][j]);
//				}System.out.println();
//			}
			return;
		}
		map[x][y] = '.';
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if(map[nx][ny] == '@') {
					map[nx][ny] = '.';
					dfs(nx, ny, targetX, targetY);
					map[nx][ny] = '@';
				}
			}
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = (s.charAt(j) == '.')?'@':'+';
				if((i == 0 || j == 0 || i == n-1 || j == m-1) && map[i][j] == '@') {
					start.add(new Position(i, j));
				}
			}
		}
//		Scanner in = new Scanner(System.in);
//		n = in.nextInt();
//		m = in.nextInt();
//		map = new char[n][m];
//		for(int i=0; i<n; i++) {
//			String str = in.next();
//			for(int j=0; j<m; j++) {
//				map[i][j] = str.charAt(j);
//				if((i == 0 || j == 0 || i == n-1 || j == m-1) && map[i][j] == '.') {
//					start.add(new Position(i, j));
//				}
//				if(map[i][j] =='.')
//					map[i][j] = '@';
//			}
//		}
//		for(int i=0; i<start.size(); i++) {
//			System.out.println(start.get(i).getX() + " " + start.get(i).getY());
//		}
		dfs(start.get(0).getX(), start.get(0).getY(), start.get(1).getX(), start.get(1).getY());
	}
}