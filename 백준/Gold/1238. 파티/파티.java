import java.util.*;
class Position implements Comparable<Position>{
	public int index;
	public int dist;
	Position(int index, int dist){
		this.index=index;
		this.dist=dist;
	}
	@Override
	public int compareTo(Position other) {
		return Integer.compare(dist, other.dist);
	}
}
public class Main{
	static final int INF = (int) 1e9;
	static int n, m, x;
	static ArrayList<ArrayList<Position>> arr = new ArrayList<>();
	static int[] map, back;
	static void dijkstra(int node) {
		PriorityQueue<Position> pq = new PriorityQueue<>();
		map[x] = 0;
		int count = 0;
		pq.offer(new Position(x, 0));
		while(!pq.isEmpty()) {
			Position now = pq.poll();
			int index = now.index;
			int dist = now.dist;
			if(map[index] < dist) continue;
			for(int i=0; i<arr.get(index).size(); i++) {
				int cost = map[index] + arr.get(index).get(i).dist;
				if(cost < map[arr.get(index).get(i).index]) {
					map[arr.get(index).get(i).index] = cost;
					pq.offer(new Position(arr.get(index).get(i).index, cost));
				}
			}
		}
		
	}
	static void dijkstraBack(int node) {
		PriorityQueue<Position> pq = new PriorityQueue<>();
		back[node] = 0;
		pq.offer(new Position(node, 0));
		while(!pq.isEmpty()) {
			Position now = pq.poll();
			int index = now.index;
			int dist = now.dist;
			if(back[index] < dist) continue;
			for(int i=0; i<arr.get(index).size(); i++) {
				int cost = back[index] + arr.get(index).get(i).dist;
				if(cost < back[arr.get(index).get(i).index]) {
					back[arr.get(index).get(i).index] = cost;
					pq.offer(new Position(arr.get(index).get(i).index, cost));
				}
			}
		}
		
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		x = in.nextInt();
		map = new int[n+1];
		back = new int[n+1];
		Arrays.fill(map, INF);
		for(int i=0; i<=n; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			arr.get(a).add(new Position(b,c));
		}
		int answer = 0;
		dijkstra(0);
		for(int i=1; i<=n; i++) {
			Arrays.fill(back, INF);
			dijkstraBack(i);
			answer = Math.max(answer, map[i] + back[x]);
		}
		System.out.println(answer);
	}
}