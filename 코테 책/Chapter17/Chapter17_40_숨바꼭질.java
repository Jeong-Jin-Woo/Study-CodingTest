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
		if(dist < other.getDist())
			return -1;
		return 1;
	}
}
public class Chapter17_40_¼û¹Ù²ÀÁú {
	static final int INF = (int)1e9;
	static int d[] = new int[20000];
	static int n,m,start;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static void dijkstra(int[] arr, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		d[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int index = node.getIndex();
			int dist = node.getDist();
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
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		
		Arrays.fill(d, INF);
		
		for(int i=0; i<=n; i++)
			graph.add(new ArrayList<Node>());
		
		for(int i=0; i<m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			graph.get(a).add(new Node(b,1));
			graph.get(b).add(new Node(a,1));
		}
		
		start = 1;
		dijkstra(d,start);
		
		int num = 0;
		for(int i=2; i<=n; i++) {
			if(d[i-1] < d[i]) 
				num = i;
		}
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(d[num] == d[i])
				cnt++;
		}
//		for(int i=1; i<=n; i++)
//			System.out.print(d[i] + " ");
		System.out.println(num + " "+ d[num] +" "+ cnt);
	}
}
