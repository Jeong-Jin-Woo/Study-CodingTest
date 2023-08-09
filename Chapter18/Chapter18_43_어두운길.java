import java.util.*;
class Node implements Comparable<Node>{
	int a;
	int b;
	int dist;
	Node(int a, int b, int dist){
		this.a = a;
		this.b = b;
		this.dist = dist;
	}
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getDist() {
		return dist;
	}
	@Override
	public int compareTo(Node other) {
		return Integer.compare(dist, other.dist);
	}
}
public class Chapter18_43_어두운길 {
	static int n, m;
	static ArrayList<Node> graph = new ArrayList<>();
	static int root[] = new int[200001];
	
	public static int find(int r) {
		if(root[r] == r)
			return r;
		return root[r] = find(root[r]);
	}
	public static void root(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b) root[b] = a;
		else root[a] = b;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		
		for(int i=1; i<=n; i++) {
			root[i] = i;
		}
		
		for(int i=1; i<=m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int dist = in.nextInt();
			graph.add(new Node(a,b,dist));
		}
		Collections.sort(graph);
		
		int answer = 0;
		int total = 0;
		for(int i=0; i<graph.size(); i++) {
			total += graph.get(i).getDist();
			if(find(graph.get(i).getA()) != find(graph.get(i).getB())){
				root(graph.get(i).getA(), graph.get(i).getB());
				answer += graph.get(i).getDist();
			}
		}
		System.out.println(total - answer);
	}
}