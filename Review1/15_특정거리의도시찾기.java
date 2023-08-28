import java.util.*;
class Node implements Comparable<Node>{
	int index;
	int dist;
	Node(int index, int dist){
		this.index = index;
		this.dist = dist;
	}
	public int getIndex() {
		return index;
	}
	public int getDist() {
		return dist;
	}
	@Override
	public int compareTo(Node other) {
		return Integer.compare(dist, other.dist);
	}
}
public class 특정거리의도시찾기 {
	static final int INF = (int)1e9;
	static int d[] = new int[300001];
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static void simulation(int x) {
		PriorityQueue<Node> pq = new PriorityQueue<>();		
		pq.add(new Node(x, 0));
		d[x] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int index = now.getIndex();
			int dist = now.getDist();
			if(d[index] < dist) continue;
			for(int i=0; i<graph.get(index).size(); i++) {
				int cost = d[index] + graph.get(index).get(i).getDist();
				if(cost < d[graph.get(index).get(i).getIndex()]) {
					d[graph.get(index).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int x = in.nextInt();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		for(int i=1; i<=m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			graph.get(a).add(new Node(b, 1));
		}
		Arrays.fill(d, INF);
		
		simulation(x);
		
		boolean chk = false;
		for(int i=1; i<=n; i++) {
			if(d[i] == k) {
				System.out.println(i);
				chk = true;
			}
		}
		if(!chk) {
			System.out.println("-1");
		}
	}
}