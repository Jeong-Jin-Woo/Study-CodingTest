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
	static int n = 5;
	static int answer = 0;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static char map[][] = new char[5][5];
	static boolean visit[][] = new boolean[5][5];
	static void dfs(int start, int count) {
		if(count == 7) {
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) {
//					System.out.print(visit[i][j]);
//				}System.out.println();
//			}System.out.println();
			if(chk()) {
//				System.out.println("True");
				answer += 1;
			}
			return;
		}
		for(int i=start; i<25; i++) {
			visit[i/5][i%5] = true;
			dfs(i + 1, count + 1);
			visit[i/5][i%5] = false;
			
		}
	}
	static boolean chk() {
		boolean check[][] = new boolean[5][5];
		int x=0, y=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				check[i][j] = visit[i][j];
				if(check[i][j]) {
					x = i;
					y = j;
				}
			}
		}
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x,y));
		int countS = 0;
		int countY = 0;
		check[x][y] = false;
		if(map[x][y] == 'S') {
			countS += 1;
		}
		if(map[x][y] == 'Y') {
			countY += 1;
		}
		while(!q.isEmpty()) {
			Position now = q.poll();
			x = now.x;
			y = now.y;	
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && check[nx][ny]) {
					check[nx][ny] = false;
					if(map[nx][ny] == 'S') {
						countS += 1;
					}
					if(map[nx][ny] == 'Y') {
						countY += 1;
					}
					q.offer(new Position(nx, ny));
				}
			}
		}
		if(countS + countY == 7 && countS > countY) {
			return true;
		}
		else return false;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		dfs(0,0);
		System.out.println(answer);
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(map[i][j]);
//			}System.out.println();
//		}
	}
}