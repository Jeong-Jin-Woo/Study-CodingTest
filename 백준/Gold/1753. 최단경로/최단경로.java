import java.util.*;
class Node implements Comparable<Node>{
	public int index;
	public int dist;
	Node(int index, int dist){
		this.index=index;
		this.dist=dist;
	}
	@Override
	public int compareTo(Node other) {
		return Integer.compare(dist, other.dist);
	}
}
public class Main{
	static int n, m;
	static ArrayList<ArrayList<Node>> node = new ArrayList<>();
	static int[] visit;
	static final int INF = (int)1e9;
	static void dijkstra(int start) {
		visit[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int index = now.index;
			int dist = now.dist;
			if(dist > visit[index]) continue;
			for(int i=0; i<node.get(index).size(); i++) {
				int cost = node.get(index).get(i).dist + visit[index];
				if(cost < visit[node.get(index).get(i).index]) {
					visit[node.get(index).get(i).index] = cost;
					pq.offer(new Node(node.get(index).get(i).index, cost));
				}
			}
		}
	}
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	n = in.nextInt();
    	m = in.nextInt();
    	visit = new int[n+1];
    	Arrays.fill(visit, INF);
    	for(int i=0; i<=n; i++)
    		node.add(new ArrayList<>());
    	int start = in.nextInt();
    	for(int i=0; i<m; i++) {
    		int a = in.nextInt();
    		int b = in.nextInt();
    		int c = in.nextInt();
    		node.get(a).add(new Node(b,c));
    	}
    	dijkstra(start);
    	for(int i=1; i<=n; i++) {
    		System.out.println(visit[i] == INF ? "INF" : visit[i]);
    	}
    }
}

