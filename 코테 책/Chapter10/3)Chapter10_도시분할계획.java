import java.util.*;
class Node implements Comparable<Node>{
	int x;
	int y;
	int dist;
	Node(int x, int y, int dist){
		this.x = x;
		this.y = y;
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
	@Override
	public int compareTo(Node other) {
		return Integer.compare(dist, other.dist);
	}
}
public class Chapter10_3_도시분할계획 {
	static int v,e;
	static ArrayList<Node> graph = new ArrayList<>();
	static int[] root = new int[100001];
	public static int find(int r) {
		if(root[r] == r)
			return r;
		else {
			root[r] = find(root[r]);
			return root[r];
		}
	}
	public static void root(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) root[b] = a;
		else root[a] = b;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		v = in.nextInt();
		e = in.nextInt();
		
		for(int i=1; i<=v; i++) {
			root[i] = i;
		}
		for(int i=0; i<e; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int dist = in.nextInt();
			graph.add(new Node(a,b,dist));
		}
		Collections.sort(graph);
		
		int answer = 0;
		int last = 0;
		for(int i=0; i<graph.size(); i++) {
			int a = graph.get(i).getX();
			int b = graph.get(i).getY();
			int dist = graph.get(i).getDist();
			if(find(a) != find(b)) {
				root(a, b);
				answer += dist;
				last = dist;
			}
		}
		System.out.println(answer - last);
	}
}