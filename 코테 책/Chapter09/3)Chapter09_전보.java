import java.util.*;
class Node implements Comparable<Node>{
	private int index;
	private int dist;
	public int getIndex() {
		return index;
	}
	public int getDist() {
		return dist;
	}
	Node(int index, int dist){
		this.index = index;
		this.dist = dist;
	}
	@Override
	public int compareTo(Node other) {
		if(dist < other.dist) {
			return -1;
		}
		return 1;
	}
}
public class Chapter09_3_Àüº¸{
	static final int INF = (int)1e9;
	static int n,m,c;
	static int d[] = new int[30001];
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		d[start] = 0;
		q.offer(new Node(start, 0));
		while(!q.isEmpty()) {
			Node node = q.poll();
			int index = node.getIndex();
			int dist = node.getDist();
			
			if(d[index] < dist) continue;
			
			for(int i=0; i<graph.get(index).size(); i++) {
				int cost = d[index] + graph.get(index).get(i).getDist();
				if(cost < d[graph.get(index).get(i).getIndex()]) {
					d[graph.get(index).get(i).getIndex()] = cost;
					q.offer(new Node(graph.get(index).get(i).getIndex(), cost));
				}
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		c = in.nextInt();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=1; i<=m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			
			graph.get(a).add(new Node(b,c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(c);
		
		int answer_count = 0;
		int answer_sum = 0;
		for(int i=1; i<=n; i++) {
			if(d[i] == INF || i == c)
				continue;
			else {
				answer_count++;
				answer_sum = Math.max(answer_sum, d[i]);
			}
		}
		System.out.println(answer_count + " " +answer_sum);
	}
}