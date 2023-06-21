import java.util.*;
class Maze{
	int x;
	int y;
	
	Maze(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
}

public class Chapter05_4_πÃ∑Œ≈ª√‚ {
	static int maze[][] = new int[201][201];
	static int n,m;
	static int[] mx = {1,-1,0,0};
	static int[] my = {0,0,1,-1};
	static int bfs(int x, int y) {
		Queue<Maze> loc = new LinkedList<>();
		loc.offer(new Maze(x,y));
		while(!loc.isEmpty()) {
			Maze mm = loc.poll();
			for(int i=0; i<4; i++) {
				int nx = mx[i] + mm.getX();
				int ny = my[i] + mm.getY();
				
				if(nx<0 || ny<0 ||nx>=n || ny >=m) continue;
				if(maze[nx][ny] == 0) continue;
				if(maze[nx][ny] == 1) {
					maze[nx][ny] = maze[mm.getX()][mm.getY()] + 1;
					loc.offer(new Maze(nx, ny));
				}
			}
		}
		return maze[n-1][m-1];
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		
		for(int i=0; i<n; i++) {
			String str = in.nextLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(1,1));
	}
}












/*



public class Chapter05_4_πÃ∑Œ≈ª√‚ {
	static int maze[][] = new int[200][200];
	static int n, m;
	static int dx[] = {-1, 1 ,0 ,0};
	static int dy[] = {0, 0, -1, 1};
	public static int bfs(int x, int y) {
		Queue<Maze> q = new LinkedList<>();
		q.offer(new Maze(x,y));
		while(!q.isEmpty()) {
			Maze loc = q.poll();
			x = loc.getX();
			y = loc.getY();
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(maze[nx][ny] == 0) continue;
				if(maze[nx][ny] == 1) {
					maze[nx][ny] = maze[x][y] + 1;
					q.offer(new Maze(nx,ny));
				}
			}
		}
		
		return maze[n-1][m-1];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		
		for(int i=0; i<n; i++) {
			String str  = in.nextLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		int answer = bfs(0,0);
		System.out.println(answer);
	}

}
*/