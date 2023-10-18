import java.util.*;
class Node implements Comparable <Node>{
	private int index;
	private int dist;
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
		if(dist < other.getDist())
			return -1;
		return 1;
	}
}
public class Chapter17_39_È­¼ºÅ½»ç {
	static final int INF = (int)1e9;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int answer[] = new int[T];
		for(int Case=0; Case < T; Case++) {
			int n,m;
			int d[] = new int[15626];
			ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
			
			n = in.nextInt();
			Arrays.fill(d, INF);
			
			for(int i=0; i<n*n; i++) {
				graph.add(new ArrayList<Node>());
			}
			int a[] = new int[n*n];
			for(int i=0; i<n*n; i++) {
				a[i] = in.nextInt();
			}
			for(int i=0; i<n*n; i++) {
				if(i+1 < n*n && i%n != n-1)
					graph.get(i).add(new Node(i+1,a[i+1]));
				if(i-1 > 0 && i%n != 0)
					graph.get(i).add(new Node(i-1,a[i-1]));
				if(i+n < n*n)
					graph.get(i).add(new Node(i+n,a[i+n]));
				if(i-n > 0)
					graph.get(i).add(new Node(i-n,a[i-n]));
			}
			
//			dijkstra(0, a[0]);

			PriorityQueue<Node> q = new PriorityQueue<Node>();
			q.offer(new Node(0,a[0]));
			d[0] = a[0];
			while(!q.isEmpty()) {
				Node node = q.poll();
				int index = node.getIndex();
				int dist = node.getDist();
				if(d[index] < dist) continue;
				for(int i=0; i<graph.get(index).size(); i++) {
					int cost = d[index] + graph.get(index).get(i).getDist();
					if(cost < d[graph.get(index).get(i).getIndex()]) {
						d[graph.get(index).get(i).getIndex()] = cost;
						q.offer(new Node(graph.get(index).get(i).getIndex(),cost));
					}
				}
			}
			answer[Case] = d[n*n-1];
		}
		for(int i=0; i<T; i++)
			System.out.println(answer[i] + " ");
	}
}
