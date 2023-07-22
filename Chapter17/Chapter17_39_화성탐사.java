import java.util.*;
class Node implements Comparable<Node>{
	int x;
	int y;
	int dist;
	Node(int x, int y, int dist){
		this.x= x;
		this.y= y;
		this.dist = dist;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDist() {
		return dist;
	}
	public int compareTo(Node other) {
		if(dist < other.dist)
			return -1;
		return 1;
	}
}
public class Chapter17_39_È­¼ºÅ½»ç {
	static final int INF = (int)1e9;
	static int dx[]  = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int test=0;test<T; test++) {
			int n = in.nextInt();
			
			int[][] graph = new int[n][n];
			int[][] d = new int[n][n];
			for(int i=0; i<n; i++) {
				Arrays.fill(d[i], INF);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					graph[i][j] = in.nextInt();
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0,0,graph[0][0]));
			d[0][0] = graph[0][0];
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int x = node.getX();
				int y = node.getY();
				int dist = node.getDist();
				if(d[x][y] < dist) continue;
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx < 0 || nx >= n || ny <0 || ny >=n) continue;
					int cost = graph[x+dx[i]][y+dy[i]] + dist;
					if(cost < d[nx][ny]) {
						d[nx][ny] = cost;
						pq.offer(new Node(nx, ny, cost));
					}
				}
			}
			
			System.out.println(d[n-1][n-1]);
		}
	}
}
