import java.util.*;
class Position{
	int x;
	int y;
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
public class 인구이동 {
	static int n, low, high, count;
	static int[][] graph = new int[100][100];
	static int[][] union = new int[100][100];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void process(int x, int y, int index) {
		Queue<Position> q = new LinkedList<>();
		ArrayList<Position> arr = new ArrayList<>();
		arr.add(new Position(x,y));
		int total = graph[x][y];
		int cnt = 1;
		union[x][y] = index;
		q.offer(new Position(x,y));
		while(!q.isEmpty()) {
			Position p = q.poll();
			x = p.getX();
			y = p.getY();
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && union[nx][ny] == -1) {
					int dif = Math.abs(graph[nx][ny] - graph[x][y]);
					if(dif >= low && dif <= high) {
						union[nx][ny] = index;
						q.offer(new Position(nx, ny));
						cnt++;
						total += graph[nx][ny];
						arr.add(new Position(nx, ny));
					}
				}
			}
		}
		int avg = total / cnt;
		for(int i=0; i<arr.size(); i++) {
			int nx = arr.get(i).getX();
			int ny = arr.get(i).getY();
			graph[nx][ny] = avg;
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		low = in.nextInt();
		high = in.nextInt();
		count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				graph[i][j] = in.nextInt();
			}
		}
		
		while(true) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					union[i][j] = -1;
				}
			}
			int index = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(union[i][j] == -1) {
						process(i, j, index);
						index++;
					}
				}
			}
			if(index == n*n) break;
			count++;
		}
		System.out.println(count);
	}
}