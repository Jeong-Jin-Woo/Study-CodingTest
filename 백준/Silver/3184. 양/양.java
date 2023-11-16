import java.util.*;
class Position{
	public int x;
	public int y;
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Main{
	static int n, m;
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visit;
	static int[] bfs(int x, int y) {
		int sheep = 0;
		int wolf = 0;
		visit[x][y] = true;
		if(map[x][y] == 'v') {
			wolf += 1;
		}
		else if(map[x][y] == 'o')
			sheep += 1;
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		while(!q.isEmpty()) {
			Position now = q.poll();
			x = now.x;
			y = now.y;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx <n && ny <m && !visit[nx][ny] && map[nx][ny] != '#') {
					if(map[nx][ny] == 'o') {
						sheep += 1;
					}
					else if(map[nx][ny] == 'v'){
						wolf += 1;
					}
					visit[nx][ny] = true;
					q.offer(new Position(nx, ny));
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(visit[i][j] + " ");
//			}System.out.println();
//		}
		int answer[] = new int[2];
		answer[0] = sheep;
		answer[1] = wolf;
		return answer;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new char[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int[] answer = new int[2];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] != '#' && !visit[i][j]) {
					int get[] = bfs(i, j); // 0이 양, 1이 늑대
//					System.out.println(get[0] +" " + get[1]);
					if(get[0] != 0 || get[1] != 0) {
						if(get[0] > get[1]) {
							answer[0] += get[0];
						}
						else {
							answer[1] += get[1];
							
						}
					}
				}
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
		
	}
}